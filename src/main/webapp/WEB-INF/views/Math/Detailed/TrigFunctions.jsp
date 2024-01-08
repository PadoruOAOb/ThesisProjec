<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>三角函數課程</title>
    <link rel="stylesheet" href="/ThesisProjec/styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
    <style>
        .TEST001 {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 100px;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            border: 20;
        }

        .course-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 600px;
            text-align: center;
        }

        .video-container {
            margin-top: 20px;
            border: 1px solid #ddd;
            padding: 10px;
            text-align: center;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>



<body>
    <div class="TEST001">
    
        <div class="course-container">
            <h2>三角函數課程</h2>
            <p>這是一個深入研究三角函數的課程，</br>讓你深刻理解三角函數的概念和應用。</p>
            <p>購買課程即可獲得：</p>
            <ul>
                <h3>豐富的課程內容：</h3>
                深入介紹三角函數的基本概念，如正弦、餘弦、和正切。</br>
                提供實際的例子和應用場景，以幫助學生理解三角函數在現實生活中的應用。</br>
                包括數學模型和圖形演示，以視覺化三角函數的特性。 </br>
                強調不同角度的三角函數計算和應用。</br>
                <h3>專業的指導:</h3>
                由經驗豐富、專業的數學教育者擔任指導，確保學生得到高品質的教育。</br> 
                提供實時問答和解說，以解決學生在學習過程中的疑問。</br>
                舉辦定期的指導課程，讓學生有機會深入研究和探討特定主題。 </br>
                使用互動式工具和教學方法，使學生更輕鬆地理解三角函數的概念。</br>
                <h3>課程證書</h3>
                提供完課後，學生將獲得正式的三角函數課程完成證書。</br>
                證書應包含學生的名稱、課程名稱、完成日期等基本資訊，以便他們能在履歷或學習紀錄中展示。</br>
                這個證書是學生參與並成功完成課程的有力證明，增加了他們的數學學習成就感。</br>
            </ul>
            <button onclick="addToCart()">購買課程</button>
        </div>
        
        
        <div class="video-container">
            <h3>試看內容</h3>
            <!-- 使用 iframe 嵌入 YouTube 影片，修改 src 屬性為相應的嵌入代碼 -->
            <iframe width="560" height="315"
                src="https://www.youtube.com/embed/VIDEO_ID" frameborder="0"
                allowfullscreen></iframe>
        </div>
    </div>
    
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>


</html>
<script>
    function purchaseCourse() {
        // 在這裡可以添加購買課程的相應處理邏輯
        alert('成功加入購物車了喔!!');
    }
</script>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>

