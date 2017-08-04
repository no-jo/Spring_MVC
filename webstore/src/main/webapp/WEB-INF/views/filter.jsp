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
				<h1>Books</h1>
				<p>Select criteria to display books</p>
			</div>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-12" style="padding-bottom: 15px">

					<div class="caption">
						<h3>Books</h3>
						<p>Enter search criteria</p>

						<form action="/webstore/books/find" class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<label class="control-label col-lg-2" for="name">Title</label>
									<div class="col-lg-30">
										<input type="text" name="title" class="form:input-large">
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-lg-2" for="name">Author</label>
									<div class="col-lg-30">
										<input type="text" name="author" class="form:input-large">
									</div>
								</div>

								<div class="form-group">
									<div class="col-lg-offset-2 col-lg-10">
										<input type="submit" value="Search" class="btn btn-primary">


							<a href="/webstore/books/all" class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Show all books
							</a> <a href="<spring:url value="/" />" class="btn btn-default">
								<span class="glyphicon-hand-left glyphicon"></span> back
							</a>
									</div>

								</div>
							</fieldset>
						</form>
						
						
					</div>
				</div>
			</div>

	</section>


</body>
</html>
