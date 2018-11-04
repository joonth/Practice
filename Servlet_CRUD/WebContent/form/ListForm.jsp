<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>

<body>
	<jsp:include page="../Header.jsp"/>
  <h1>회원리스트</h1>
  <a href=Add>회원추가</a><br>
  <c:forEach var="member" items="${members}">
    ${member.mno},
    <a href="Update?mno=${member.mno}">${member.mname}</a>,
    ${member.email},
    ${member.cre_date}
    <a href="Delete?mno=${member.mno}">[삭제]</a><br>
  </c:forEach>
	<jsp:include page="../Tail.jsp"/>
</body>
</html>
