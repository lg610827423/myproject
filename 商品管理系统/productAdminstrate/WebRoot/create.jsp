<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'create.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  
   <%
   String info=(String)request.getAttribute("info");
   if(info!=null){
    %>
  <h4><%=info %></h4>
  <%
  }
   %>
    <form action="CreateServlet" method="post" >
    商品&nbsp;&nbsp;编号：<input type="text" name="id" title="输入4位的商品编码" ><br>
    商品&nbsp;&nbsp;名称：<input type="text" name="name"><br>
    商品&nbsp;&nbsp;价格：<input type="text" name="price" title="精确到百分位"><br>
    商品&nbsp;&nbsp;数量：<input type="text" name="count"><br>
    商品生产商：<input type="text" name="factory"><br>
    <input type="submit" value="添加">
    <input type="reset" value="重置">
    </form>
    <form action="SearchServlet" method="post">
    	请输入查询关键字：<input type="text" name="kw">
    	<input type="submit" value="查询">
    </form>
  </body>
</html>
