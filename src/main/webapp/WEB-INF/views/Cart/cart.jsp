<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<div class="container mt-5">

	<%-- ${ cart } --%>
	<%-- ${ message } --%>

	<div class="row">
		<div class="col-md-8">
			<h2 class="mb-4">購物車</h2>
			<!-- 購物車內容 -->
			<c:forEach items="${ cart.cartItems }" var="item">
				<div class="cart-card">
					<img src="/ThesisProjec${ item.course.courseImg }" alt="課程收到"
						style="max-width: 50%; height: auto;">
					<h4 class="mt-3">${ item.course.courseName}</h4>
					<p>${ item.course.price }</p>
					<!-- 其他購物車內容項目 -->
				</div>
			</c:forEach>
		</div>
		<div class="col-md-4">
			<h2 class="mb-4">信用卡結帳</h2>
			<!-- 信用卡表單 -->
			<div class="credit-card-form">
				<!-- 可以加入更多信用卡相關的表單項目 -->

				<div class="form-group">
					<label for="creditCard">信用卡號碼</label>
					<div class="input-group">
						<input type="text" class="form-control" id="creditCard1"
							name="creditCard1" maxlength="4"
							onkeyup="moveToNext(this, 'creditCard2')" required> <input
							type="text" class="form-control" id="creditCard2"
							name="creditCard2" maxlength="4"
							onkeyup="moveToNext(this, 'creditCard3')" required> <input
							type="text" class="form-control" id="creditCard3"
							name="creditCard3" maxlength="4"
							onkeyup="moveToNext(this, 'creditCard4')" required> <input
							type="text" class="form-control" id="creditCard4"
							name="creditCard4" maxlength="4" required>
					</div>
				</div>

				<div class="form-group">
					<label for="expirationDate" class="form-label">到期日：</label>
					<!-- 到期日輸入框 -->
					<div class="input-group">
						<input type="text" class="form-control" id="expirationDate"
							name="expirationDate" placeholder="MM/YY"
							onkeyup="formatExpirationDate()" maxlength="5" required>
					</div>
				</div>
				<div class="form-group">
					<label for="cvv" class="form-label">CVV：</label> <input type="text"
						class="form-control" id="cvv" name="cvv" required>
				</div>
				<button type="submit" class="checkout-btn">結帳</button>
			</div>
		</div>
	</div>
	<!-- 購買後獲得的內容描述 -->
	<div class="mt-5">
		<h3>購買後您將獲得：</h3>
		<ul class="list-group">
			<li class="list-group-item">專屬課程影片</li>
			<li class="list-group-item">搭配影片使用的專屬教材</li>
			<!-- 其他購買後獲得的內容項目 -->
		</ul>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>

<script>
	function moveToNext(currentInput, nextInputId) {
		if (currentInput.value.length === currentInput.maxLength
				&& nextInputId !== null) {
			var nextInput = document.getElementById(nextInputId);
			nextInput.focus();
		}
	}

	function formatExpirationDate() {
		var expirationDateInput = document.getElementById('expirationDate');
		var inputValue = expirationDateInput.value;

		// 移除非數字的字符
		var cleanedValue = inputValue.replace(/\D/g, '');

		// 根據輸入的長度插入 /
		if (cleanedValue.length > 2) {
			cleanedValue = cleanedValue.substring(0, 2) + '/'
					+ cleanedValue.substring(2);
		}

		// 更新輸入框的值
		expirationDateInput.value = cleanedValue;

		// 購物車內容
		var cartContent = [];

		// 函數：將課程添加到購物車
		function addToCart() {
			// 獲取課程信息（您可能需要根據實際情況修改此處的代碼）
			var courseInfo = {
				name : "三角函數課程",
				price : 99.99
			};

			// 將課程添加到購物車
			cartContent.push(courseInfo);

			// 更新購物車內容顯示
			updateCartDisplay();
		}

		// 函數：更新購物車內容顯示
		function updateCartDisplay() {
			var cartContainer = document.getElementById("cart-content");
			cartContainer.innerHTML = ""; // 清空現有內容

			// 顯示購物車內容
			for (var i = 0; i < cartContent.length; i++) {
				var course = cartContent[i];
				var courseItem = document.createElement("div");
				courseItem.innerHTML = "<h4>課程名稱: " + course.name
						+ "</h4><p>價格: $" + course.price.toFixed(2) + "</p>";
				cartContainer.appendChild(courseItem);
			}
		}
	}
</script>

<style>
html, body {
	height: 100%;
	margin: 0;
}

body {
	display: flex;
	flex-direction: column;
}

.container {
	flex: 1;
	text-align: center; /* 居中对齐 */
}

.mt-5 {
	margin-top: 5rem; /* 调整顶部边距 */
}

/* 購物車內容卡片樣式 */
.cart-card {
	background-color: #f8f9fa;
	border: 1px solid #dee2e6;
	border-radius: 10px;
	padding: 20px;
	margin-bottom: 20px;
}

/* 信用卡表單樣式 */
.credit-card-form {
	background-color: #f8f9fa;
	border: 1px solid #dee2e6;
	border-radius: 10px;
	padding: 20px;
	text-align: left; /* 調整文字左對齊 */
}

/* 結帳按鈕樣式 */
.checkout-btn {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.checkout-btn:hover {
	background-color: #0056b3;
}

/* 通用表單樣式 */
.form-group {
	margin-bottom: 1rem;
}

.form-label {
	display: block;
	margin-bottom: 0.5rem;
}

.form-control {
	width: 100%;
	padding: 0.375rem 0.75rem;
	font-size: 1rem;
	line-height: 1.5;
	border: 1px solid #ced4da;
	border-radius: 0.25rem;
}
</style>
