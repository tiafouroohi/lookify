<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1><c:out value="${song.title}"/></h1>
<p>Artist: <c:out value="${song.artist}"/></p>
<p>Rating <c:out value="${song.rating}"/></p>

<a href="/dashboard">Dashboard</a>

</body>
</html>