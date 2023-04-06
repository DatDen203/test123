<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<form:form action="save" method="POST" modelAttribute="obj">
		<form:hidden path="idStudent" />
		<section class="vh-100" style="background-color: #fbfbfb;">
			<div class="container h-100">
				<div class="row d-flex justify-content-center align-items-center"
					style="padding-top: 50px;">
					<div class="col-xl-7">
						<h3 class="mb-4" style="color: #150ECC">${title}</h3>
						<div class="card" style="border-radius: 15px;">
							<div class="card-body">
								<div class="row align-items-center pt-4 pb-3">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">Full name</h6>
									</div>
									<div class="col-md-9 pe-5">
										<form:input path="name"
											cssClass="form-control form-control-lg" />
									</div>
								</div>
								<hr class="mx-n3">
								<div class="row align-items-center py-3">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">Age</h6>
									</div>
									<div class="col-md-9 pe-5">
										<form:input path="age" cssClass="form-control form-control-lg" />
									</div>
								</div>
								<hr class="mx-n3">
								<div class="row align-items-center py-3">
									<div class="col-md-3 ps-5">
										<h6 class="mb-0">Classroom</h6>
									</div>
									<div class="col-md-9 pe-5">
										<form:input path="classStudent"
											cssClass="form-control form-control-lg" />
									</div>
								</div>
								<hr class="mx-n3">
								<div class="text-center">
									<button type="submit" class="btn btn-success">Success</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form:form>
</body>

</html>