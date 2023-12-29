<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>註冊</title>
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
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

form {
	background-color: #fff;
	padding: 40px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 400px;
	text-align: center;
}

h2 {
	color: #333;
	font-size: 28px;
	font-weight: bold;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 10px;
	color: #555;
	font-size: 16px;
}

input {
	width: 100%;
	margin-bottom: 20px;
	padding: 10px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

button {
	background-color: #4caf50;
	color: #fff;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<form modelAttribute="user" action="./mvc/user/register" method="post" onsubmit="return validateForm()">
    <h2>註冊</h2>

    <label for="email">電子郵件：</label>
    <input type="email" id="email" name="email" required> 

    <label for="username">使用者名稱：</label>
    <input type="text" id="username" name="username" required>

    <label for="password">密碼：</label>
    <input type="password" id="password" name="password" required>

    <label for="confirmPassword">確認密碼：</label>
    <input type="password" id="confirmPassword" name="confirmPassword" required>

    <button type="submit">註冊</button>
</form>

	<script>
		function validateForm() {
			// 檢查出生年月日是否在當天註冊之前
			var birthdate = new Date(document.getElementById('birthdate').value);
			var today = new Date();
			if (birthdate >= today) {
				alert('出生年月日必須在當天註冊之前。');
				return false;
			}

			// 檢查電子郵件格式是否正確
			var email = document.getElementById('email').value;
			var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			if (!emailRegex.test(email)) {
				alert('請輸入正確的電子郵件格式。');
				return false;
			}

			// 密碼條件檢查
			var password = document.getElementById('password').value;
			if (!isValidPassword(password)) {
				alert('密碼應足夠安全，並包含字母、數字和特殊字符。');
				return false;
			}

			return true;
		}

		// 密碼條件檢查的方法
		function isValidPassword(password) {
			// 實際的密碼條件檢查邏輯
			// 這裡只是一個簡單的範例，實際應用可能需要更複雜的邏輯
			var regex = /^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\S+$).{8,}$/;
			return regex.test(password);
		}
	</script>

</body>


</html>