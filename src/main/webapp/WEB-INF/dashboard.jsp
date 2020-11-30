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

<h1>Dashboard</h1>

<a href="/add">Add Song</a>

<form action="/search" method="POST">
<input type="text" name="search" placeholder="Search Artist">
<input type="submit" value="submit">

<c:forEach items="${allSongs}" var="song">
<p><a href="/song/${song.id}"><c:out value="${song.title }"></c:out></a></p>
<p><c:out value="${song.artist }"></c:out></p>
<p><c:out value="${song.rating }"></c:out></p>

<a href="/song/${song.id}/delete">Delete</a>
</c:forEach>



</body>
</html>