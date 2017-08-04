<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hello</title>
</head>
<body>
	<section>
		<div class="jumbotron" style="background-color: threeddarkshadow;">
			<div class="container" style="color: white;">
				<h1>${greeting}</h1>
				<p>${info}</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Books</h3>
						<p>View available books</p>
						<a href="/webstore/books" class="btn btn-default"> <span
							class="glyphicon-search glyphicon" /></span> Browse
						</a>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Add book</h3>
						<p>Insert new book</p>
						<a href="/webstore/books/add" class="btn btn-success"> <span
							class="glyphicon-plus glyphicon" /></span> Add book
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
