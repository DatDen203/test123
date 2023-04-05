<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style type="text/css">
.content {
	float: left;
	display: table-cell;
	margin-right: 10px
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
	<a href="/crud-student/add">add</a>
	<c:forEach items="${requestScope.listStudent}" var="c"
		varStatus="loopCounter">
		<c:set var="id" value="${c.idStudent}" />
		<div
			style="background-color: #d0d000; width: 500px; height: 100px; margin: 10px"
			class="content">
			<div>${id}</div>
			<div>${c.name}</div>
			<div>${c.age}</div>
			<div>${c.classStudent}</div>
			<div>
				<a href="/crud-student/updateStudent?idStudent=${id}">Edit</a> <a
					href="#" onclick="doDelete('${id}')">Delete</a>
			</div>
		</div>
		<c:if test="${loopCounter.count %2 == 0}">
			<br>
		</c:if>
	</c:forEach>
</body>
</html>