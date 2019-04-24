package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class JDBC {
 
		private static Connection conn;
		private static Statement stmt;
		private static ResultSet rs;
		

		private void getMyConnection(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root" , "123456");//鑾峰彇杩炴帴
				
				stmt = conn.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		private void close(){
			try {
				
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public int update(String sql){
			int num = 0;  
			getMyConnection();
			try {
				num = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				
				e.printStackTrace();
			} finally {
				close();
			}
			return num;
		}
		

		public ArrayList<HashMap<String,String>> query(String sql){
			
			 ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
			 getMyConnection();
			 try {
				 rs = stmt.executeQuery(sql);
				 ResultSetMetaData rsmt = rs.getMetaData();
				 while(rs.next()){
					HashMap<String,String> map = new HashMap<String,String>();
					for (int i = 1; i <= rsmt.getColumnCount(); i++) {
						String key = rsmt.getColumnName(i);  
						String value = rs.getString(i);
						map.put(key, value);	
					}
					list.add(map); 
				 }
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
		}
		

		public ArrayList<String[]> newQuery(String sql) {
			ArrayList<String[]> list = new ArrayList<String[]>();
			getMyConnection();
			try {
				rs = stmt.executeQuery(sql);
				ResultSetMetaData rsmt = rs.getMetaData();
				while(rs.next()){
					String[] array = new String[rsmt.getColumnCount()];
					for(int i = 1;i <= rsmt.getColumnCount();i++) {
						array[i-1] = rs.getString(i);
					}
					list.add(array);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
		}

		public ArrayList<String[]> pageQuery(String sql,int currentPageNum,int pageCount){
			
			String newSql = sql + " limit "+(currentPageNum-1)*pageCount+","+pageCount;
			
			ArrayList<String[]> arr = newQuery(newSql);
			
			return arr;
			
		}
}
