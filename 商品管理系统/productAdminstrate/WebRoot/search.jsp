<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="product.lg.vo.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'search.jsp' starting page</title>
    
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
  <center>
    <table border="1" width="80%">
    	<tr>
    		<th>商品编号</th>
    		<th>商品名称</th>
    		<th>商品价格</th>
    		<th>商品数量</th>
    		<th>商品生产商</th>
    		<th>修改数据</th>
    		<th>删除数据</th>
    	</tr>
    	<%
    	List<Product> all=(List<Product>)request.getAttribute("data");
    	if(all==null || all.size()<1){
    		out.print("<tr><td bgcolor='#FFFFFF' colspan='5'>没有任何商品信息！</td></tr>");
    		}else{
    		for(Product product:all){
    	%>
    	<tr>
    		<form action="UpdateServlet" method="post">
    		<td><input type="text" name="id1" value="<%=product.getId() %>" disabled /></td>
    		<td><input type="text" name="name" value="<%=product.getName() %>" /></td>
    		<td><input type="text" name="price" value="<%=product.getPrice() %>" /></td>
    		<td><input type="text" name="count" value="<%=product.getCount() %>" /></td>
    		<td><input type="text" name="factory" value="<%=product.getFactory() %>" /></td>
    		<td>
    		
    		<input type="hidden" name="id" value="<%=product.getId() %>">
    		<input type="submit" value="修改">
    		</td>
    		</form>
    		<td>
    		<form action="DeleteServlet" method="post">
    		<input type="hidden" name="id" value="<%=product.getId() %>" />
    		<input type="submit" value="删除">
    		</form>
    		</td>
    	</tr>
    	<%
    	}
    	}
    	 %>
    </table>
    </center>
    <a href="create.jsp">返回</a>
  </body>
</html>
