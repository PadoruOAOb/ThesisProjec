USE `learning` ;

-- 建立 user
select userId, username, password, email, level, authType, authId from user;
-- insert into user(username, password, email, level) values ( 'OAOb', '123', 'OAOb@example.com', 1 );

-- 建立課程類別
select typeId, typeName from type;
insert into type(typeName) values('數學'),('日文'),('英文');

-- 建立課程
select courseId, courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId, createTime from course;

insert into course(courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId) 
values('三角函數專屬課程','歡迎加入我們的三角函數專屬課程，這是一個精心設計的課程，旨在深入探討正弦、餘弦和正切等三角函數的神奇世界。無論你是初學者還是已經對數學充滿熱情，這個課程都將為你打開全新的數學視野。
課程亮點：
理論和實踐結合： 我們將理論知識與實際應用相結合，通過生動的實例和實際問題，讓你更好地理解三角函數的本質。
生動教學：由資深數學教師授課，以清晰而生動的方式解釋三角函數的概念，讓學習變得輕鬆有趣。
實用應用：學會如何應用三角函數解決現實生活中的問題，包括物理、工程和計算機科學等多個領域。','豐富的課程內容：
深入介紹三角函數的基本概念，如正弦、餘弦、和正切。
提供實際的例子和應用場景，以幫助學生理解三角函數在現實生活中的應用。
包括數學模型和圖形演示，以視覺化三角函數的特性。
強調不同角度的三角函數計算和應用。
專業的指導:
由經驗豐富、專業的數學教育者擔任指導，確保學生得到高品質的教育。
提供實時問答和解說，以解決學生在學習過程中的疑問。
舉辦定期的指導課程，讓學生有機會深入研究和探討特定主題。
使用互動式工具和教學方法，使學生更輕鬆地理解三角函數的概念。
課程證書
提供完課後，學生將獲得正式的三角函數課程完成證書。
證書應包含學生的名稱、課程名稱、完成日期等基本資訊，以便他們能在履歷或學習紀錄中展示。
這個證書是學生參與並成功完成課程的有力證明，增加了他們的數學學習成就感。','/img/math.png',1, 1000, 1);


insert into course(courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId) 
values('N5日文學習課程','N5日文學習課程歡迎您。這是一門精選的課程，旨在從基礎開始學習日文，並致力於掌握N5水平的語言技能。即使是初學者也可以放心參與。
課程亮點：
基礎理論深入：通過深入學習日文的核心理論，確保您能夠獲得扎實的語言基礎。
應用案例：通過實際應用案例，學會在現實生活中應用日文，包括日常交流、商務溝通等方面。
互動學習：課程中包含豐富的互動元素，如問答環節和小組討論，使學習更加生動有趣。','','/img/JP/JP01.png',1, 500, 2);

insert into course(courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId) 
values('微積分入門課程','加入我們的微積分入門課程，探索數學的無窮魅力。這是一個適合數學愛好者和學術追求者的精選課程，將為你帶來深厚的微積分基礎。
課程亮點:基礎理論深入： 微積分的核心理論將被深入淺出地介紹，以確保你對這一重要領域有全面的理解。
應用案例：透過真實應用案例，學會如何在現實生活中應用微積分，包括物理學、工程學和經濟學等領域。
互動學習：課程中包括豐富的互動元素，例如問答環節和小組討論，讓學習變得更加生動有趣。',' ','/img/math.png',1, 850, 1);

-- resource
select resourceId, courseId, link, createTime, updateTime, type from resource;
insert into resource (courseId, link,type) values (1,'/mvc/video/v2/1', 1);
insert into resource (courseId, link,type) values (1,'/download/material1', 2);

-- cart
select cartId, userId, amount, isCheckOut, checkOutTime from cart;
insert into cart(userId, amount, isCheckOut) values(1, 1500, 0);


-- cart item
select cartItemId, cartId, courseId, price, qty from cartItem;
insert into cartItem(cartId, courseId, price) values (1,1,1000),(1,2,500);


-- 結帳alter
select cartId, userId, amount, isCheckOut, checkOutTime from cart where userId = 1;
update cart set isCheckOut =1 , checkOutTime = Now() where cartId = 1 and userId = 1;

-- 我的課程
select u.userId,u.username, cs.courseImg, cs.courseName, cs.courseDescription,cs.courseDetail
from user u, cart c, cartitem i, course cs 
where u.userId = c.userId and c.cartId = i.cartId and i.courseId = cs.courseId and u.userId = 1 and c.isCheckOut = 1;

-- 我的課程 > 點我立即數學課
select u.userId, u.username, cs.courseName, cs.courseDetail, rs.link
from user u, course cs, resource rs ,cart c 
where u.userId = 1 and cs.courseId =1  and c.isCheckOut = 1 ;

-- 我的課程 > 點我立即日文課
select u.userId, u.username, cs.courseName, cs.courseDetail, rs.link
from user u, course cs, resource rs ,cart c 
where u.userId = 1 and cs.courseId =2  and c.isCheckOut = 1 ;

-- 課程購物車
select u.userId ,u.username, cs.courseName ,cs.price,cs.courseImg, c.cartId
from user u, course cs, cart c 
where u.userId = 1 and c.userId =1 and  c.isCheckOut = 0;

-- 選擇課程 > 數學
select u.userId, u.username, cs.courseName, cs.courseDescription ,cs.courseImg ,cs.typeId
from user u, course cs ,type t
where  u.userId = 1 and  t.typeId=1  and cs.typeId= 1 ;

-- 選擇課程 > 日文
select u.userId, u.username, cs.courseName, cs.courseDescription ,cs.courseImg ,cs.typeId
from user u, course cs ,type t
where  u.userId = 1 and  t.typeId=2  and cs.typeId= 2 ;