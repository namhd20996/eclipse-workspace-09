<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="bean-ctl" method="post">
		Fullname: <input type="text" name="fullname"> <br>
		 Age: <input type="text" name="age"> <br>
			 Salary:<input type="text" name="salary"> <br>
			Gender: <input type="radio" name="gender" value="true"><label>Nam</label>
			<input type="radio" name="gender" value="false"> Nữ
			<br>
		<select name="country">
			<option value="vn">Việt nam</option>
			<option value="my">Mỹ</option>
			<option value="lao">Lào</option>
		</select> <br>
		DoB: <input type="date" name="dob">
		<hr> 
		<input type="submit" value="Submit">
	</form>
</body>
</html>