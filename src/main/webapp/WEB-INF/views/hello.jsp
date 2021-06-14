<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/button.css"/>" />
<body>
	<div class="container">
		<!-- header -->
		<div class="head" style="background-color: ">
		</div>
		<!-- body -->
		<div class="row" align="center">
			<div class="col" >
				<h1>Hello World</h1>
				<a href="${pageContext.request.contextPath}/facebookLogin">
					<button class="loginBtn loginBtn--facebook">Login with
					Facebook</button></a>
			</div>
		</div>
		<!-- footer -->
		<div></div>
	</div>
	
</body>
</html>