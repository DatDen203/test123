<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<style type="text/css">
.container {
	margin: 0px;
	padding: 0px;
	max-width: 100%
}

.content {
	float: left;
	display: table-cell;
	margin-right: 10px
}

.img_item {
	float: left;
	width: 45%;
	float: left;
}

.info_item {
	float: left;
	width: 55%;
	float: left;
}

.item {
	width: 18rem;
	float: left;
	margin: 10px;
	width: 350px;
	height: 200px
}

.img_student {
	height: 120px;
	display: block;
	margin-top: 10px;
}

.a {
	font-size: 15px;
}

.contentx {
	min-height: 1000px;
	padding-left: 17px
}

.footer {
	position: relative;
	bottom: 0;
	width: 100%;
	height: 50px;
}
</style>

<script type="text/javascript">
	function doDelete(id) {
		if (confirm("are you sure to delete Student with ID=" + id)) {
			window.location = "delete?idStudent=" + id;
		}
	}
</script>

<body>
	<div class="container container-fluid">
		<nav class="navbar navbar-light bg-light" style="width: 100%">
			<div class="container-fluid">
				<div>
					<a class="navbar-brand" href="/crud-student/list">List Of
						Student</a> <a href="/crud-student/add"> <img alt="img add"
						src="https://cdn-icons-png.flaticon.com/512/1057/1057240.png"
						style="width: 35px; height: 35px; margin-bottom: 5px"></a>
				</div>

				<form:form action="/crud-student/search" method="GET"
					cssClass="d-flex">
					<input class="form-control me-2" name="name"
						placeholder="search by name" style="width: 300px" />
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form:form>
			</div>
		</nav>

		<div class="badge bg-primary text-wrap"
			style="width: 6rem; margin-left: 25px">Count:
			${listStudent.size()}</div>

		<div class="contentx">
			<c:forEach items="${listStudent}" var="c" varStatus="loopCounter">
				<c:set var="id" value="${c.idStudent}" />
				<div class="item shadow p-3 bg-body rounded"
					style="height: 170px">
					<div class="card-body">
						<div class="img_item">
							<img alt="img student"
								src="https://cdn-icons-png.flaticon.com/512/9572/9572711.png"
								class="img_student " data-bs-toggle="modal"
								data-bs-target="#detail${id}">
						</div>
						<div class="info_item">
							<h6 class="card-subtitle mb-2 text-muted">ID: ${id}</h6>
							<h5 class="card-text a">Name: ${c.name}</h5>
							<h5 class="card-text a">Age: ${c.age}</h5>
							<h5 class="card-text a">Class: ${c.classStudent}</h5>
							<a href="/crud-student/updateStudent?idStudent=${id}"
								class="btn btn-outline-success btn-sm"
								style="height: 30px; margin-right: 10px;">Update</a> <a
								class="btn btn-outline-danger btn-sm" style="height: 30px"
								onclick="doDelete('${id}')">Delete</a>
						</div>
					</div>
				</div>

				<c:if test="${loopCounter.count %4 == 0}">
					<br>
				</c:if>

				<!-- Modal Detail-->
				<div class="modal fade" id="detail${id}" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Student's
									details</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<div class="child">
									<img alt="img student"
										src="https://cdn-icons-png.flaticon.com/512/9572/9572711.png"
										class="img_student">
								</div>
								<div class="child">
									<h6 class="card-subtitle mb-2 text-muted">ID: ${id}</h6>
									<h5 class="card-text a">Name: ${c.name}</h5>
									<h5 class="card-text a">Age: ${c.age}</h5>
									<h5 class="card-text a">Class: ${c.classStudent}</h5>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<!-- <footer class="footer text-center text-white">
			<p class="text-center p-3 bg-primary">
				© 2023Copyright: <a class="text-white"
					href="https://www.facebook.com/DatDenNe"
					style="text-decoration: none;">footer.author</a>
			</p>
		</footer> -->

	</div>
</body>
</html>