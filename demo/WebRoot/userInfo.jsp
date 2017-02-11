<%@ page language="java" import="java.util.*,java.text.*" contentType="text/html; charset=utf-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	 .title{
		 width: 30%;	
		 background-color: #CCC;
		 font-weight: bold;
	 }
	 .content{
	     width:70%;
	     background-color: #CBCFE5;
	 }
	 
   </style>  
  </head>
  
  <body>
    <h1>用户信息</h1>
    <hr>
    <center>
<%--      <jsp:useBean  id="UserRegister" class="entity.User" scope="session"/>    --%>
     <table width="600" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td class="title">用户名：${ UserRegister.username}</td>
<%--           <td class="content">&nbsp;<jsp:getProperty name="UserRegister" property="username"/></td> --%>
        </tr>
        <tr>
          <td class="title">密码：${ UserRegister.password}</td>
<%--           <td class="content">&nbsp;<jsp:getProperty name="UserRegister" property="password"/></td> --%>
        </tr>
     </table>
    </center>
  </body>
</html>
