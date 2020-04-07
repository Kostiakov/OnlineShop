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
	<form:form action="searchProduct" modelAttribute="productName" method="POST">
		<form:input path="name" />
		<input type="submit" value="Search" />
	</form:form>
</body>

</html>