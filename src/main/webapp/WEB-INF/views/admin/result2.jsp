<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- pom.xml에서 jstl을 관리해주기 때문에 따로 lib 삽입 없이 taglib 사용 가능 -->
		<h1>결과 보기</h1>
		<h2>강아지 이름</h2>
		<h3>
			<c:forEach var="k" items="${dogName}">
				<li>${k}</li>
			</c:forEach>
		</h3>
		<hr>
		
		<h2>배우 이름</h2>
		<h3>
			<c:forEach var="k" items="${list}">
				<li>${k}</li>
			</c:forEach>
		</h3>
		
	</body>
</html>