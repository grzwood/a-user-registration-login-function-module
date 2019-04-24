package servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import db.JDBC;
//import db.UserDB;



//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/RegProc")
public class RegProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//UserDB user=new UserDB();
		ArrayList<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		String sqlupdate;
		String sqlselect;
		boolean flag=true;
		int num=0;
		String name=request.getParameter("username");
		String psw=request.getParameter("password");
		sqlupdate="INSERT INTO user VALUES ('" + name + "','" + psw + "')";
		sqlselect="SELECT * FROM user";
		JDBC jdbc = new JDBC();
		result=jdbc.query(sqlselect);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).get("username"));
			if(result.get(i).get("username").equals(name)){
				System.out.println("用户已存在");
				flag=false;
			}

		}
		if(flag){
		num = jdbc.update(sqlupdate);
		System.out.println(num);
		}
		System.out.println(flag);
		if(num!=0){
			response.sendRedirect("Register_success.jsp");
		}
		else{
			response.sendRedirect("Register_failure.jsp");
		}

		
	}
	

}
