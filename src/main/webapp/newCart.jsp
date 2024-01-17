<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>課程頁面</title>
</head>
<body>

    <h2>課程頁面</h2>

    <!-- 課程列表 -->
    <div>
        <h3>課程1</h3>
        <form method="post" action="/addToCart">
            <input type="hidden" name="courseId" value="1">
            <button type="submit">加入購物車</button>
        </form>
    </div>

    <div>
        <h3>課程2</h3>
        <form method="post" action="/addToCart">
            <input type="hidden" name="courseId" value="2">
            <button type="submit">加入購物車</button>
        </form>
    </div>

    <!-- 購物車內容 -->
    <div>
        <h2>購物車</h2>
        <ul>
            <!-- 這裡可以顯示購物車內容，根據實際情況動態生成 -->
            <li>課程1</li>
            <li>課程2</li>
        </ul>
    </div>

</body>
</html>
