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
<title>Book</title>
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
				<h1>Book info</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${book.id}</h3>
				<p>
					<strong>Book title: </strong>${book.title} 
				</p>
				<p>
					<strong>Wrote by</strong>: ${book.authors}
				</p>
				<p>
					<a href="<spring:url value="/books" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>

				</p>

			</div>
		</div>
	</section>
</body>
</html>
