<%@page import="vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<% List<Member> members =(List<Member>)request.getAttribute("members"); %>
<body>
	<jsp:include page="../Header.jsp"/>
  <h1>회원리스트</h1>
  	<a href=Add>회원추가</a><br>
	<%for(Member member : members){ %>
		<%=member.getMno()%>,
		<a href="Update?mno=<%=member.getMno()%>"><%=member.getMname() %></a>,
		<%=member.getEmail() %>,
		<%=member.getCre_date() %><a href="Delete?mno=<%=member.getMno()%>">[삭제]</a><br>
	<% }%>
	<jsp:include page="../Tail.jsp"/>
</body>
</html>
