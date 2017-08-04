<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Books</title>
</head>
<body>
	<nav class="navbar navbar-fixed-top" style="background: white">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/webstore">e-Library</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="isAnonymous()">
					<li><a href="<c:url value="/login" />"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li><a href="#"> You are logged in as:  <sec:authentication
								property="principal.username" />
					</a></li>
					<li><a href="<c:url value="/j_spring_security_logout"/>">
							<span class="glyphicon glyphicon-log-out"></span> Logout
					</a></li>
				</sec:authorize>
			</ul>
		</div>
	</nav>
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