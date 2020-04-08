<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Online Shop Home Page</title>
</head>

<body>
	<h2>Online Shop Home Page</h2>
	<br>
	<a href="productList">Show all products</a>
	<br>
	Find product
	<br>
	<form:form action="searchProduct" modelAttribute="productName" method="POST">
		<form:input path="name" />
		<input type="submit" value="Search" />
	</form:form>
	<br>
	Add product to cart
	<br>
	<form:form action="addProductToCart" modelAttribute="addedProduct" method="POST">
		<form:input path="name" />
		<form:input path="amount" />
		<input type="submit" value="Add" />
	</form:form>
</body>

</html>