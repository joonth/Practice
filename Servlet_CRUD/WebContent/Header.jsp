<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background-color:#00008b; color:#ffffff; height:20px; padding:5px;">
	PRACTICE

<span style="float:right;">
	<a style="color:white;" href="<%=request.getContextPath()%>/pList.do">프로젝트</a>
	<a style="color:white;" href="<%=request.getContextPath()%>/List.do">회원</a>
	<c:if test="${empty sessionScope.smember or empty sessionScope.smember.email}">
	<a style="color:white;" href="<%=request.getContextPath()%>/Login.do">로그인</a>
	</c:if>
	
	<c:if test="${!empty sessionScope.smember and !empty sessionScope.smember.email}">
	${sessionScope.smember.mname}
	(<a style="color:white;" href="<%=request.getContextPath()%>/Logout.do">로그아웃</a>)
	</c:if>
</span>
</div>
