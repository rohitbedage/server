<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--  importing spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Welcome to Spring MVC : page served via Spring framework....@
		${requestScope.server_time}</h5>
	<h5>
		<a
			href="product/add?name=pen&category=stationary&price=50.5&qty=3&creation_date=12/23/2019">Handling
			Request Parameters</a>
	</h5>
	<h5>
		<a
			href="product/add2?name=pen&category=stationary&price=50.5&qty=3&creation_date=2020-5-25">Handling
			Request Parameters n Date Time Formatting</a>
	</h5>
	<%--URL rewriting if needed n makes all URI relative to root of curnt web app  --%>
	<h5>
		<a href="<spring:url value='/user/login'/>">User Login</a>
	</h5>
</body>
</html>