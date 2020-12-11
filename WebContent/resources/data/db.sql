-- 게시판 qna

--1. 글번호 : qno > auto increment
--2. 작성자 : writer > emp
--3. 글제목 : title > 200자
--4. 글내용 : content > max
--5. 조회수 : readcount > 정수
--6. 작성일 : regdate > 년월일시분초
--7. 사진업 : imgfile > png, jpg, jpeg /  파일x, 경로
--8. 썸네일 : thumbnail > 100x100 px

create table if not exists qna(
	qno int(11) auto_increment,
	writer varchar(50) not null,
	title varchar(200) not null,
	content varchar(2000) default null,
	readcount int(8) not null default 0,
	regdate timestamp default current_timestamp,
	imgfile varchar(1000) default null,
	thumbnail varchar(1100) default null,
	primary key(qno)
) default charset=utf8;