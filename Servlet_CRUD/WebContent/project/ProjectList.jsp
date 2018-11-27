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
<style>
  table,td,th,tr{
    border : 1px solid black;
  }
</style>
</head>

<body>
	<jsp:include page="../Header.jsp"/>
  <h1>프로젝트 목록</h1>
  <a href="pAdd.do">신규 프로젝트</a>
  <table>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>시작일</th>
      <th>종료일</th>
      <th>상태</th>
      <th></th>
    </tr>
    <c:forEach var="project" items="${projects}">
      <tr>
        <td>${project.pno}</td>
        <td><a href="pUpdate.do">${project.pname}</a></td>
        <td>${project.sta_date}</td>
        <td>${project.end_date}</td>
        <td>${project.state}</td>
        <td><a href="#">[삭제]</a></td>
      </tr>
    </c:forEach>


  </table>


	<jsp:include page="../Tail.jsp"/>
</body>
</html>
