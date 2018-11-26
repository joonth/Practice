<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add</title>
<style type="text/css">
	ul,li{
		list-style:none;
	}
</style>
</head>
<body>
	<jsp:include page="../Header.jsp"/>
	<h1>프로젝트 등록</h1>
	<form action="pAdd.do">
	<ul>
		<li>
			<label>제목</label><input type="text" name="pname"/>		
		</li>
	</ul>
	<ul>
		<li>
			<label>내용</label>
			<textarea rows="6" cols="40" name="content"></textarea>	
		</li>
	</ul>	
	<ul>
		<li>
			<label>시작일</label><input type="text" name="sta_date" >		
		</li>
	</ul>
	<ul>
		<li>
			<label>종료일</label><input type="text" name="end_date" >		
		</li>
	</ul>
	<ul>
		<li>
			<label>태그</label><input type="text" name="tags" >		
		</li>
	</ul>
	
	<input type="submit" value="추가">
	<input type="reset" value="취소">
	</form>
	<jsp:include page="../Tail.jsp"/>
</body>
</html>