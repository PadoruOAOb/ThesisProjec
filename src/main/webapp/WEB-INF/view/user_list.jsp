<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<ul>
	<c:forEach items="${ users }" var="user">
		<li>${ user.userId } , ${ user.username }, ${ user.email } , ${ user.level }</li>
	</c:forEach>
</ul>