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
values('微積分入門課程','加入我們的微積分入門課程，探索數學的無窮魅力。這是一個適合數學愛好者和學術追求者的精選課程，將為你帶來深厚的微積分基礎。
課程亮點:基礎理論深入： 微積分的核心理論將被深入淺出地介紹，以確保你對這一重要領域有全面的理解。
應用案例：透過真實應用案例，學會如何在現實生活中應用微積分，包括物理學、工程學和經濟學等領域。
互動學習：課程中包括豐富的互動元素，例如問答環節和小組討論，讓學習變得更加生動有趣。',' 微積分入門課程

這是一門深入研究微積分基礎概念的入門課程，旨在幫助學生建立對微積分的堅實理解。

購買課程即可獲得：

豐富的課程內容：

微積分基本概念的全面介紹，包括極限、導數和積分。
實際案例和應用場景，幫助學生理解微積分在科學、工程和其他領域中的實際應用。
使用數學模型和圖形演示，以視覺化微積分的概念和原理。
強調微積分在解決實際問題中的重要性。
專業的指導：

由經驗豐富、專業的數學教育者擔任指導，確保學生得到高品質的教育。
提供實時問答和解說，解決學生在學習過程中的疑問。
定期的指導課程，讓學生有機會深入研究和探討特定的微積分主題。
使用互動式工具和教學方法，使學生更輕鬆地理解微積分的核心概念。
課程證書：

學生完成課程後，將獲得正式的微積分入門課程完成證書。
證書應包含學生的名稱、課程名稱、完成日期等基本資訊，以供履歷或學習紀錄使用。
這個證書是學生參與並成功完成課程的有力證明，有助於提升他們的數學學習成就感。','/img/math.png',1, 850, 1);

insert into course(courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId) 
values('統計學基礎課程','歡迎加入我們的統計學基礎課程，這是一個為初學者準備的課程，將帶你深入了解統計學的基本概念和應用。


無論你是準備進入統計學領域還是想提升自己的統計學知識，這個課程都是你的最佳選擇。
課程亮點： 基礎理論掌握： 學習統計學的基本理論，包括概率、假設檢定、回歸分析等核心內容。
實際應用案例：透過豐富的實際案例，學會如何應用統計學方法解決現實生活中的問題。
統計軟體應用：學習使用常見的統計軟體，如R或Python，進行數據分析和視覺化。','統計學基礎課程

這是一門深入研究統計學基礎概念的入門課程，旨在協助學生建立對統計學的牢固理解。

購買課程即可獲得：

豐富的課程內容：

統計學的基本概念全面介紹，包括描述統計和推論統計。
實際案例和應用場景，協助學生理解統計學在不同領域中的實際應用，如商業、科學和社會研究。
使用數學模型和圖形演示，以視覺化統計學的概念和方法。
強調統計學在資料分析和決策過程中的關鍵角色。
專業的指導：

由經驗豐富、專業的統計學教育者擔任指導，確保學生得到高品質的教育。
提供實時問答和解說，解決學生在學習過程中的疑問。
定期的指導課程，讓學生有機會深入研究和探討特定的統計學主題。
使用互動式工具和教學方法，使學生更輕鬆地理解統計學的核心概念。
課程證書：

學生完成課程後，將獲得正式的統計學基礎課程完成證書。
證書應包含學生的名稱、課程名稱、完成日期等基本資訊，以供履歷或學習紀錄使用。
這個證書是學生參與並成功完成課程的有力證明，有助於提升他們的統計學學習成就感。','/img/math3.png',1, 200, 1);

insert into course(courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId) 
values('N5日文學習課程','N5日文學習課程歡迎您。這是一門精選的課程，旨在從基礎開始學習日文，並致力於掌握N5水平的語言技能。即使是初學者也可以放心參與。


課程亮點：
基礎理論深入：通過深入學習日文的核心理論，確保您能夠獲得扎實的語言基礎。
應用案例：通過實際應用案例，學會在現實生活中應用日文，包括日常交流、商務溝通等方面。
互動學習：課程中包含豐富的互動元素，如問答環節和小組討論，使學習更加生動有趣。','N5級別日文的基本概念全面介紹，包括常用的詞彙、語法和基本句型。
實際對話和應用場景，協助學生理解N5日文在日常生活中的實際應用，如自我介紹、購物和旅行。
使用生動的語境和練習，以提高學生的聽、說、讀、寫能力。
強調N5考試的相關技巧和戰略，幫助學生更好地應對考試。
專業的指導：

由經驗豐富、專業的日語教育者擔任指導，確保學生得到高品質的教育。
提供實時問答和解說，解決學生在學習過程中的疑問。
定期的指導課程，讓學生有機會深入研究和探討特定的日文學習主題。
使用互動式工具和教學方法，使學生更輕鬆地理解N5日文的核心概念。
課程證書：

學生完成課程後，將獲得正式的N5日文學習課程完成證書。
證書應包含學生的名稱、課程名稱、完成日期等基本資訊，以供履歷或學習紀錄使用。
這個證書是學生參與並成功完成課程的有力證明，有助於提升他們的日文學習成就感。','/img/JP/JP01.png',1, 500, 2);

insert into course(courseName, courseDescription,courseDetail, courseImg, teacher, price, typeId) 
values('日常生活中的日文應用','參加我們的日常生活中的日文應用課程，探索日文的無窮魅力。這門課程適合想要提升實際日文應用能力的學習者，將為您帶來更深厚的日文基礎。
課程亮點：
日文交流技能：提升您的日文口語和書寫技能，讓您能夠在日常生活中流利地使用日文。
實際應用場景：通過實際應用場景，學習在不同情境下靈活運用日文，包括工作、旅行等方面。
文化體驗：了解日文語境中的文化和習俗，豐富您對日文的理解。','日常生活中的日文應用課程

這是一門針對日文初學者的輕鬆課程，目的在於讓學生在日常生活中能夠輕鬆運用日文。

購買課程即可獲得：

豐富的課程內容：

介紹日本日常生活中實用的日文表達，包括社交場合、餐廳用餐、購物、旅行等。
透過實際對話和場景練習，幫助學生更自信地應對實際生活中的溝通情境。
使用豐富的語境和實例，以提升學生的聽、說、讀、寫能力。
課程強調輕鬆的學習氛圍，讓學生在輕松的氛圍中提升日文能力，並不注重考試技巧。
','/img/JP/JP03.png',1, 100, 2);
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