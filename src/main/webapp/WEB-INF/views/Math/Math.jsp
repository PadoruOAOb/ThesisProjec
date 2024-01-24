<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<head>

</head>



<body class="d-flex flex-column min-vh-100">
	<main class="container mt-4">
		<h2 class="mb-4">數學課程列表</h2>
		<div class="row">
			<!-- 循環內包含所有課程 -->
			 <c:forEach items="${ Course }" var="course">
				<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
					<div class="card">
						<img src="/ThesisProjec${ course.courseImg }" class="card-img-top"
							alt="Math Course 1">
						<div class="card-body m-0">
							<h5 class="card-title fs-3">${ course.courseName }</h5>
							<p class="card-text">${ course.courseDescription }</p>
							<a class="btn btn-primary"
								href="/ThesisProjec/mvc/user/trigFunctions">詳細課程</a>
						</div>
					</div>
				</div>
			</c:forEach> 
		</div>
	</main>
</body>
