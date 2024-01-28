<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<main>
	<div class="row">
		<img src="./img/Home.png" alt="首頁圖片" class="Home">
		<div class="d-flex flex-column bd-highlight mb-3 align-items-center">


			<section class="featured-course w-50" role="button">
				<h2 class=m-0>精選課程</h2>
				<div id="carouselExampleCaptions" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleCaptions"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="./img/BALL/Dog.png" class="d-block w-100" alt="測試">
							<div
								class="carousel-caption d-none d-md-block bg-dark text-white">
								<h5>寵物訓練師</h5>
								<p>想了解你家的狗狗貓貓嗎?</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="./img/BALL/Ball.png" class="d-block w-100" alt="棒球">
							<div
								class="carousel-caption d-none d-md-block bg-dark text-white">
								<h5>來打棒球吧</h5>
								<p>開始來學打棒球!!</p>
							</div>
						</div>
						<div class="carousel-item">
							<img src="./img/BALL/Kitty.png" class="d-block w-100"
								alt="1561615156615">
							<div
								class="carousel-caption d-none d-md-block bg-dark text-white">
								<h5>讀懂貓貓</h5>
								<p>讀懂貓，瞭解貓，成為貓?</p>
							</div>
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</section>

			<section class="latest-posts w-50" role="button">
				<h2 class=m-0>讓你休息~看一下迷因吧</h2>
				<div id="carouselExampleControls" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="./img/MEME/Cheese.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="./img/MEME/code.png" class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="./img/MEME/Uber.png" class="d-block w-100" alt="能放gif嗎">
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleControls" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleControls" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</section>
		</div>
	</div>
</main>


<%@ include file="/WEB-INF/views/include/footer.jsp"%>
