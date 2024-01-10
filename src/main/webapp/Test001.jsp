<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

<body style="padding-top: 100px;">

    <div class="container mt-5">
        <h2 class="mb-4">三角函數課程</h2>

        <!-- 課程內容 -->
        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">三角函數介紹</h5>
                <p class="card-text">探索三角函數的基本概念，包括正弦、餘弦和正切。</p>
            </div>
        </div>

        <!-- 影片區域 -->
        <div class="card mb-4">
            <div class="card-body">
               <h5 class="card-title">課程影片</h5>
               <!-- 靜態資源：（Servlet 容器）
			   <video width="640" height="360" controls preload="metadata" class="m-2">
				   <source src="/ThesisProjec/mvc/video/v1" type="video/mp4">
			   </video>
			    -->
               <!-- 使用 iframe 嵌入 YouTube 影片，修改 src 屬性為相應的嵌入代碼 -->
	           <video width="640" height="360" controls preload="metadata" class="m-2">
	            	<source src="/ThesisProjec/mvc/video/v2" type="video/mp4">
			   </video>
			</div>
        </div>

        <!-- 下載教材區域 -->
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">課程教材</h5>
                <p class="card-text">下載課程的額外教材。</p>
                <!-- 加入下載按鈕以下載課程教材 -->
                <a href="/ThesisProjec/download/material1.pdf" class="btn btn-primary" download>下載教材 1</a>
                <a href="/ThesisProjec/download/material2.pdf" class="btn btn-primary" download>下載教材 2</a>
                <!-- 如有更多教材，可加入更多按鈕 -->
            </div>
        </div>
    </div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>

</html>
