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
	margin: 0px auto;
	padding-left: 100px;
}

.content {
	float: left;
	display: table-cell;
	margin-right: 10px
}

.child {
	float: left;
	width: 50%;
}

.item {
	width: 18rem;
	float: left;
	margin: 10px;
	width: 350px;
	height: 200px
}

.img_student {
	width: 120px;
	height: 120px;
	display: block;
	margin-left: auto;
	margin-right: auto;
}

.a {
	font-size: 15px;
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
	<div class="container">
		<nav class="navbar navbar-light bg-light" style="width: 1100px">
			<div class="container-fluid">
				<div>
					<a class="navbar-brand" href="/crud-student/list">List Of Student</a> <a
						href="/crud-student/add"><img alt="img add"
						src="https://cdn-icons-png.flaticon.com/512/1057/1057061.png"
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
		<div>
			<c:forEach items="${listStudent}" var="c" varStatus="loopCounter">
				<c:set var="id" value="${c.idStudent}" />
				<div class="item shadow p-3 mb-5 bg-body rounded"
					style="height: 170px">
					<div class="card-body">
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
							<a class="text-decoration-none"
								href="/crud-student/updateStudent?idStudent=${id}">Update</a> <a
								class="text-decoration-none" href="#" class="card-link"
								onclick="doDelete('${id}')">Delete</a>
						</div>
					</div>
				</div>
				<c:if test="${loopCounter.count %3 == 0}">
					<br>
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>