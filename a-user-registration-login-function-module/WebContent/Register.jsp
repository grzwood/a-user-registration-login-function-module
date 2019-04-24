<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<script type="text/javascript">

function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false;}
  else {return true;}
  }
}
function testLength(field,alerttxt)
{
with (field)
  {
  //var s=value;
  if (value.length<6)
    {alert(alerttxt);return false;}
  else {return true;}
  }
}
function IsString(field,alerttxt)     
{     
	
	with(field){
        if(value.length!=0){    
        reg=/^[a-zA-Z0-9_]+$/;     
        if(!reg.test(value)){    
        	alert(alerttxt);
        	return false;
        }    
        }   
	}
}  
function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(password,"Password must be filled out!")==false)
	{password.focus();return false;}
  
  if (validate_required(username,"Username must be filled out!")==false)
    {username.focus();return false;}

  if (IsString(password,"密码格式不正确")==false)
  {password.focus();return false;}
  if (testLength(password,"密码长度必须大于6")==false)
  {password.focus();return false;}

  }
}

</script>
</head>
<body>
<h2>注册</h2>
	<form action="RegProc" onsubmit="return validate_form(this)" method="post">
	<p>用户名：<input type = "text" name="username"></p>
	<p>密码：     <input type = "text" name="password"></p>
	<p><input type="submit" value="Submit" /></p>
	</form>
</body>
</html>
