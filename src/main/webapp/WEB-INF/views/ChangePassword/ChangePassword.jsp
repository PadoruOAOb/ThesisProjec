<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
  
 <!--http://localhost:8080/ThesisProjec/ChangePassword.jsp -->
</head>
<body style="padding-top: 100px;" class="d-flex flex-column min-vh-100">

    <!-- 主要內容區域 -->
    <main class="d-flex justify-content-center align-items-center flex-grow-1">
        <div>
            <h2>Change Password</h2>

            <form class="pure-form" action="./ChangePassword" method="post">
                <!-- 原密碼輸入欄 -->
                <div style="padding: 15px">
                    <label for="currentPassword">請輸入原本密碼 : </label>
                    <input type="password" id="oldPPassword" name="oldPassword" required>
                </div >

                <!-- 新密碼輸入欄 -->
                <div style="padding: 15px">
                    <label for="newPassword">請輸入新密碼 : </label>
                    <input type="password" id="newPassword" name="newPassword" required>
                </div>

                <!-- 重複確認新密碼輸入欄 -->
                <div style="padding: 15px">
                    <label for="confirmPassword">請在一次輸入新密碼 : </label>
                    <input type="password" id="confirmPassword" name="newPassword" required>
                </div>

                <!-- 提交按鈕 -->
                <button type="submit">Change Password</button>
                <div style="color: red">${ errorMessage }</div>
            </form>
        </div>
    </main>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>

</body>
</html>

