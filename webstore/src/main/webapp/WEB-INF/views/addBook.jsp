<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Add Book</title>
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
				<h1>Book</h1>
				<p>Add new book</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newBook" class="form-horizontal">
			<fieldset>
				<legend>Add new book</legend>

				<!-- Sample template for some fields in Book Entity -->
				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Title</label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text"
							class="form:input-large" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Author</label>
					<div class="col-lg-10">
						<form:input id="authors" path="authors" type="text"
							class="form:input-large" required="required" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="status">status</label>
					<div class="col-lg-10">
						<form:radiobutton path="status" value="FREE" required="required" />
						Free
						<form:radiobutton path="status" value="LOAN" required="required" />
						Loan
						<form:radiobutton path="status" value="MISSING"
							required="required" />
						Missing
					</div>
				</div>
			</fieldset>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Create" />
				</div>
			</div>
		</form:form>
	</section>
</body>
</html>
