<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
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
	}
</style>
<body>
	<div class="container mt-5">
		<c:if test="${ empty cartItems || cartItems.size == 0}">
	    	無資料
	    </c:if>
		<h2 class="mb-4">已購買的課程</h2>
		<!-- Course Card -->
		<c:forEach items="${ cartItems }" var="cartItem">
			<div class="card mb-3" style="width: 18rem;">
				<img src="/ThesisProjec${ cartItem.course.courseImg }" class="card-img-top" alt="Course Image">
				<div class="card-body">
					<h5 class="card-title">${ cartItem.course.courseName }</h5>
					<!-- <a href="/ThesisProjec/mvc/user/Test001" class="btn btn-primary">點我立即上課</a> -->
					<a href="/ThesisProjec/mvc/user/course/${ cartItem.course.courseId }" class="btn btn-primary">點我立即上課</a>
				</div>
			</div>
		</c:forEach>
		

		<!-- 可以加入更多已購買課程的卡片 -->
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>

</body>

</html>
