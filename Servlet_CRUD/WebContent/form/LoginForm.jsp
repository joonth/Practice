<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
  <h1>Login</h1>
  <form action="../Login.do" method="post">
    이메일 : <input type="text" name="email"><br>
    비밀번호 : <input type="text" name="pwd"><br>
    <input type="submit" value="로그인">
  </form>
</body>
</html>
