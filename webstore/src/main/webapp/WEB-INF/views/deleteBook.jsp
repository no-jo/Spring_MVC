<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Delete book</h1>
				<p>Book ${book.id} was deleted.</p>
			</div>
		</div>
	</section>
			<a href="<spring:url value="/books" />" class="btn btn-default"> <span
				class="glyphicon-hand-left glyphicon"></span> back to search
			</a>

</body>
</html>