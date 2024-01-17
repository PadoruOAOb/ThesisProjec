<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>學習平台</title>
<link rel="stylesheet" href="/ThesisProjec/styles.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<link rel="icon"
	href="${pageContext.request.contextPath}/img/icon/icon.png"
	type="image/png">
</head>

<body>
	<!-- Bootstrap 導覽列 -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-secondary fs-3 fixed-top p-0 ">
		<div class="container-fluid p-3 fs-3">
			<a class="navbar-brand fs-1 text-white"
				href="/ThesisProjec/index.jsp">學無止境</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active text-white"
						aria-current="page" href="/ThesisProjec/index.jsp">首頁</a></li>
					<li class="nav-item"><a class="nav-link text-white"
						href="/ThesisProjec/mvc/user/MyCourses">我的課程</a></li>
					<li class="nav-item"><a class="nav-link text-white"
						href="/ThesisProjec/mvc/user/cart">課程購物車</a></li>
					<li class="nav-item dropdown "><a
						class="nav-link dropdown-toggle text-white" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 選擇課程 </a>
						<ul class="dropdown-menu text-white"
							aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item"
								href="/ThesisProjec/mvc/user/japan">日文</a></li>
							<li><a class="dropdown-item"
								href="/ThesisProjec/mvc/user/math">數學</a></li>
							<li><a class="dropdown-item" href="#">英文</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item " href="#">聯絡我們</a></li>
						</ul>
					<li class="nav-item"><a class="nav-link text-white"
						href="/ThesisProjec/mvc/user/ChangePassword">使用者</a></li>
					</li class="nav-item">
					<li>
					<a class="nav-link text-white" href="/ThesisProjec/newCart.jsp">測試中購物車</a>
					</li class="nav-item">
					<li>
					<a class="nav-link text-white" href="/ThesisProjec/Buy.jsp">測試中課程購買頁面</a>
					</li>
					
					
				</ul>

				<c:if test="${ empty user }">
					<a class="btn btn-outline-success fs-3 text-white submit"
						href="<%=request.getContextPath()%>/mvc/user/login">登入</a>
				</c:if>

				<c:if test="${ not empty user }">
					<p class="text-white me-3 m-0">
						Welcome, ${ user.username } ! <a
							href="${ pageContext.request.contextPath }/mvc/user/logout"
							class="btn btn-outline-danger m-0">Logout</a>
					</p>
				</c:if>

			</div>
		</div>
	</nav>
</body>

</html>