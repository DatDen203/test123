<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: "Inter", Arial, Helvetica, sans-serif;
}

.formbold-mb-5 {
	margin-bottom: 20px;
}

.formbold-main-wrapper {
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 20px;
}

.formbold-form-wrapper {
	margin: 0;
	padding: 0;
	max-width: 550px;
	width: 100%;
	background-color: rgb(227, 227, 227);
	padding: 40px;
	box-shadow: 0 4px 8px 0 rgba(192, 192, 192, 0.2), 0 6px 20px 0
		rgba(165, 165, 165, 0.19);
	border-radius: 20px;
	margin-top: 50px;
}

.formbold-form-label {
	display: block;
	font-weight: 500;
	font-size: 16px;
	color: #07074d;
	margin-bottom: 12px;
	font-weight: bold;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
}

.formbold-form-input {
	width: 100%;
	padding: 12px 24px;
	border-radius: 6px;
	border: 1px solid #e0e0e0;
	background: white;
	font-weight: 500;
	font-size: 16px;
	color: #6b7280;
	outline: none;
	resize: none;
}

.formbold-form-input:focus {
	border-color: #6a64f1;
	box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
}

.formbold-btn {
	text-align: center;
	font-size: 16px;
	border-radius: 6px;
	padding: 14px 32px;
	border: none;
	font-weight: 600;
	background-color: #6a64f1;
	color: white;
	width: 100%;
	cursor: pointer;
	font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande',
		'Lucida Sans', Arial, sans-serif;
	margin-top: 10px;
}

.formbold-btn:hover {
	box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
}

::placeholder {
	font-size: small;
}
</style>

<body>
	<div class="formbold-main-wrapper">
		<div class="formbold-form-wrapper">
			<form:form action="save" method="POST" modelAttribute="obj">
				<form:hidden path="idStudent" />
				<h3
					style="text-align: center; margin-bottom: 20px; font-size: 25px;">
					Add new Student</h3>
				<div class="formbold-mb-5">
					<label for="name" class="formbold-form-label"> Full Name </label>
					<form:input path="name" cssClass="formbold-form-input" />
				</div>
				<div class="formbold-mb-5">
					<label for="phone" class="formbold-form-label"> Age Number</label>
					<form:input path="age" />
				</div>
				<div class="formbold-mb-5">
					<label for="email" class="formbold-form-label"> Classroom</label>
					<form:input path="classStudent" />
				</div>
				<div>
					<button class="formbold-btn" type="submit">Add Student</button>
				</div>
			</form:form>
		</div>
	</div>
</body>

</html>