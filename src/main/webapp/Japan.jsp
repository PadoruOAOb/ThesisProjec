<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>
<head>
    <!-- 你的 head 內容... -->
</head>
<body class="d-flex flex-column min-vh-100">
	<main class="container mt-4">
		<h2 class="mb-4">數學課程列表</h2>
		<div class="row">
			<!-- 第一課程 -->
			<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
				<div class="card">
					<img src="./img/JP/JP01.png" class="card-img-top" alt="00 Course 1">
					<div class="card-body m-0">
						<h5 class="card-title fs-3">N5日文學習課程</h5>
						<p class="card-text">
							N5日文學習課程歡迎您。這是一門精選的課程，旨在從基礎開始學習日文，並致力於掌握N5水平的語言技能。即使是初學者也可以放心參與。<br>
							課程亮點：<br> 基礎理論深入：通過深入學習日文的核心理論，確保您能夠獲得扎實的語言基礎。<br>
							應用案例：通過實際應用案例，學會在現實生活中應用日文，包括日常交流、商務溝通等方面。<br>
							互動學習：課程中包含豐富的互動元素，如問答環節和小組討論，使學習更加生動有趣。<br>
						</p>
						<a class="btn btn-primary" href="/ThesisProjec/mvc/user/japaneseLearning">詳細課程
						</a>
					</div>
				</div>
			</div>

			<!-- 第二課程 -->
			<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
				<div class="card">
					<img src="../../img/math2.png" class="card-img-top" alt="Math Course 2">
					<div class="card-body ">
						<h5 class="card-title fs-3 pt-auto">日常生活中的日文應用</h5>
						<p class="card-text">
							參加我們的日常生活中的日文應用課程，探索日文的無窮魅力。這門課程適合想要提升實際日文應用能力的學習者，將為您帶來更深厚的日文基礎。<br>
							課程亮點：<br> 日文交流技能：提升您的日文口語和書寫技能，讓您能夠在日常生活中流利地使用日文。<br>
							實際應用場景：通過實際應用場景，學習在不同情境下靈活運用日文，包括工作、旅行等方面。<br>
							文化體驗：了解日文語境中的文化和習俗，豐富您對日文的理解。<br>
						</p>
						<a class="btn btn-primary" href="/ThesisProjec/mvc/user/japaneseApplication">詳細課程
						</a>
					</div>
				</div>
			</div>
			<!-- 第三課程 -->
			<div class="col-md-4 mb-4 p-5 m-0 pt-auto pb-1">
				<div class="card">
					<img src="../../img/math3.png" class="card-img-top" alt="Math Course 3">
					<div class="card-body">
						<h5 class="card-title fs-3 pt-auto">日文文化深度了解</h5>
						<p class="card-text">
							歡迎加入我們的日文文化深度了解課程，這是一門為喜歡日本文化的學習者準備的課程，將帶您深入了解日本文化的多個層面。<br>
							課程亮點：<br> 傳統與現代的融合：通過深度探討傳統和現代的日本文化，使您能夠更全面地了解這個國家的獨特之處。<br>
							文學與藝術：介紹日本豐富的文學和藝術，讓您感受到這個文化的深度和多樣性。<br>
							日本日常生活：了解日本人的日常生活方式，包括飲食、節慶、社交習慣等方面。<br>
						</p>
						<a class="btn btn-primary" href="/ThesisProjec/mvc/user/japaneseCulture">詳細課程
						</a>
					</div>
				</div>
			</div>
		</div>
	</main>
</body>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>
