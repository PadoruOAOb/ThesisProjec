<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>購物車</title>
<!-- 引入 Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 自定義樣式 -->
<style>
body {
	background-color: #f8f9fa;
	padding: 20px;
}

.cart-container {
	max-width: 800px;
	margin: auto;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 12px;
	text-align: left;
	border: 1px solid #dee2e6;
}

th {
	background-color: #007bff;
	color: #fff;
}
</style>
</head>
<body>
	<div class="cart-container">
		<!-- 購物車內容 -->
		<h2 class="mt-4 mb-4">購物車</h2>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">課程名稱</th>
					<th scope="col">價格</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses}">
					<tr>
						<td>${course.courseName}</td>
						<td>${course.price}</td>
					</tr>
				</c:forEach>

				<!-- 調試信息 -->
				<c:if test="${empty courses}">
					<tr>
						<td colspan="2">購物車為空</td>
					</tr>
				</c:if>


			</tbody>
		</table>
	</div>

	<!-- 引入 Bootstrap JS，注意需先引入 Popper.js -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>

