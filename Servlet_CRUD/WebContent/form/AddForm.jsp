<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원추가</title>
</head>
<body>
  <h1>회원추가</h1>
  <form action="../Add.do" method="post">
    회원이름 : <input type="text" name="mname" ><br>
    이메일 : <input type="text" name="email" ><br>
    비밀번호 : <input type="password" name="pwd" ><br>
    <input type="submit" value="추가">
    <input type="button" value="취소" onclick="location.href='List'">
  </form>
</body>
</html>
