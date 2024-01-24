<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

<body style="padding-top: 100px;" class="d-flex flex-column min-vh-100">

 ${resources}
 
 <%--
	 [
	 	Resource(resourceId=1, courseId=1, link=/mvc/video/v2/1, createTime=2024-01-23, updateTime=2024-01-23, type=1), 
	 	Resource(resourceId=2, courseId=1, link=/download/material1, createTime=2024-01-23, updateTime=2024-01-23, type=2)
	 ]
 --%>

    <div class="container mt-5">
        <h2 class="mb-4">${ course.courseName }</h2>
        <!-- 課程內容 -->
        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">${ course.courseDescription }</h5>
                <p class="card-text">${ course.courseDetail }</p>
            </div>
        </div>
        
        <!-- 影片區域 -->
        <c:forEach items="${ resources }" var="resource">
        	<c:if test="${ resource.type == 1 }">
	        	<div class="card mb-4">
		            <div class="card-body">
		               <h5 class="card-title">課程影片</h5>
		               <!-- 靜態資源：（Servlet 容器）
					   <video width="640" height="360" controls preload="metadata" class="m-2">
						   <source src="/ThesisProjec/mvc/video/v1" type="video/mp4">
					   </video> -->
		               <!-- 使用 iframe 嵌入 YouTube 影片，修改 src 屬性為相應的嵌入代碼-->
			           <video width="640" height="360" controls preload="metadata" class="m-2">
			            	<source src="/ThesisProjec${ resource.link}" type="video/mp4">
					   </video>
					</div>
		        </div>
        	</c:if>
        </c:forEach>
        
        <!-- 下載教材區域 -->
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">課程教材</h5>
                <p class="card-text">下載課程的額外教材。</p>
                <!-- 加入下載按鈕以下載課程教材 -->
                <c:forEach items="${ resources }" var="resource" varStatus="loop">
		        	<c:if test="${ resource.type == 2 }">
						<a href="/ThesisProjec${ resource.link}.pdf" class="btn btn-primary" download>下載教材${ loop.index + 1 }</a>
		        	</c:if>
		        </c:forEach>
                <!-- 如有更多教材，可加入更多按鈕 -->
            </div>
        </div>
    </div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>

</html>
