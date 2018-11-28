<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
<style type="text/css">
	ul,li{
		list-style:none;
	}
</style>
</head>
<body>
	<jsp:include page="../Header.jsp"/>
	<h1>프로젝트 수정</h1>
	<form action="pUpdate.do" method="post">
	<input type="hidden" name="pno" value="${project.getPno()}">
	<ul>
		<li>
			<label>제목</label><input type="text" name="pname" value="${project.getPname()}"/>		
		</li>
	</ul>
	<ul>
		<li>
			<label>내용</label>
			<textarea id="ta" rows="6" cols="40" name="content" >${project.getContent()}</textarea>	
		</li>
	</ul>	
	<ul>
		<li>
			<label>시작일</label><input type="text" name="sta_date" value="${project.getSta_date()}" >		
		</li>
	</ul>
	<ul>
		<li>
			<label>종료일</label><input type="text" name="end_date" value="${project.getEnd_date()}">		
		</li>
	</ul>
	<ul>
		<li>
			<label>태그</label><input type="text" name="tags" value="${project.getTags()}" >		
		</li>
	</ul>
	
	<input type="submit" value="수정">
	<input type="button" value="취소" onclick="location.href='pList.do'">
	</form>
	<jsp:include page="../Tail.jsp"/>
</body>
</html>