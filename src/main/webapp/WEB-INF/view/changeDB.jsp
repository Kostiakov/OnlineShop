<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Amount</th>
			<th>Price</th>
			<th>Calories</th>
			<th>Life Time</th>
			<th>Delete</th>
			<c:forEach var="tempProduct" items="${products}">
				<c:url var="deleteLink" value="/deleteProductFromDB">
					<c:param name="productId" value="${tempProduct.id}"></c:param>
				</c:url>
				<tr>
					<td>${tempProduct.id}</td>
					<td>${tempProduct.name}</td>
					<td>${tempProduct.amount}</td>
					<td>${tempProduct.price}</td>
					<c:catch var="error1">
						<td>${tempProduct.calories}</td>
					</c:catch>
					<c:if test="${error1!=null}">
					</c:if>
					<c:catch var="error2">
						<td>${tempProduct.lifeTime}</td>
					</c:catch>
					<c:if test="${error2!=null}">
					</c:if>
					<td><a href="${deleteLink}">Delete</a> 
				</tr>
			</c:forEach>
		</tr>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/">Back to start</a>
	</p>
</body>
</html>