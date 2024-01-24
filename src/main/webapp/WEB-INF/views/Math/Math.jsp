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
			<c:forEach items="${course.courses}" var="Course">
				<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
					<div class="card">
						<img src="../../img/math.png" class="card-img-top"
							alt="Math Course 1">
						<div class="card-body m-0">
							<h5 class="card-title fs-3">${Course.courseName}</h5>
							<p class="card-text">${Course.courseDescription}</p>
							<a class="btn btn-primary"
								href="/ThesisProjec/mvc/user/trigFunctions">詳細課程</a>
						</div>
					</div>
				</div>
			</c:forEach>


			<!-- 第二個課程 -->
			<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
				<div class="card">
					<img src="../../img/math2.png" class="card-img-top"
						alt="Math Course 2">
					<div class="card-body ">
						<h5 class="card-title fs-3 pt-auto">微積分入門課程</h5>
						<p class="card-text">
							加入我們的微積分入門課程，探索數學的無窮魅力。這是一個適合數學愛好者和學術追求者的精選課程，將為你帶來深厚的微積分基礎。<br>
							課程亮點:基礎理論深入： 微積分的核心理論將被深入淺出地介紹，以確保你對這一重要領域有全面的理解。<br>
							應用案例：透過真實應用案例，學會如何在現實生活中應用微積分，包括物理學、工程學和經濟學等領域。 <br>
							互動學習：課程中包括豐富的互動元素，例如問答環節和小組討論，讓學習變得更加生動有趣。<br>
						</p>
						<button class="btn btn-primary ">購買課程</button>
					</div>
				</div>
			</div>

			<!-- 第三個課程 -->
			<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
				<div class="card">
					<img src="../../img/math3.png" class="card-img-top"
						alt="Math Course 3">
					<div class="card-body">
						<h5 class="card-title fs-3 pt-auto">統計學基礎課程</h5>
						<p class="card-text">
							歡迎加入我們的統計學基礎課程，這是一個為初學者準備的課程，將帶你深入了解統計學的基本概念和應用。<br>
							無論你是準備進入統計學領域還是想提升自己的統計學知識，這個課程都是你的最佳選擇。<br> 課程亮點： 基礎理論掌握：
							學習統計學的基本理論，包括概率、假設檢定、回歸分析等核心內容。<br>
							實際應用案例：透過豐富的實際案例，學會如何應用統計學方法解決現實生活中的問題。<br>
							統計軟體應用：學習使用常見的統計軟體，如R或Python，進行數據分析和視覺化。<br>
						</p>
						<a class="btn btn-primary"
							href="/ThesisProjec/mvc/user/trigFunctions">詳細課程 </a>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>
