<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Amount</th>
			<th>Price</th>
			<c:forEach var="tempProduct" items="${products}">
				<tr>
					<td>${tempProduct.name}</td>
					<td>${tempProduct.amount}</td>
					<td>${tempProduct.price}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/">Back to start</a>
	</p>
</body>
</html>