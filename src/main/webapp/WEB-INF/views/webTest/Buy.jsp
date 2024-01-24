<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>購買課程</title>
    <!-- 引入你的樣式表或引用Bootstrap等框架 -->
    <body>
    <!-- 購買課程的內容 -->
    <h2>購買課程</h2>
    <p>課程名稱: Java基礎課程 | 價格: $50</p>
    
    <!-- 購買按鈕 -->
    <button onclick="addToCart(6, 'Java基礎課程', 50)">加入購物車</button>
    
</body>
    <script>
        function addToCart(courseId, courseName, price) {
            // 使用JavaScript將所選課程信息添加到購物車
            var cartItem = {
                courseId: courseId,
                courseName: courseName,
                price: price
            };
            
            // 將購物車項目轉換為JSON字符串
            var cartItemJson = JSON.stringify(cartItem);
            
            // 將JSON字符串發送到後端處理
            // 這裡可以使用Ajax或表單提交等方式發送到SpringMVC的Controller
            // 示範中使用表單提交
            var form = document.createElement("form");
            form.setAttribute("method", "post");
            form.setAttribute("action", "/ThesisProjec/mvc/cart/addToCart");
            form.setAttribute("hidden", true);

            var input = document.createElement("input");
            input.setAttribute("type", "text");
            input.setAttribute("name", "cartItemJson");
            input.setAttribute("value", cartItemJson);

            form.appendChild(input);
            document.body.appendChild(form);

            form.submit();
        }
    </script>
</head>

</html>
