create table board(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default current_date,
	cnt number(5) default 0
);

insert into board(seq, title, writer, content) 
values(1, '가입인사', '채규태', '잘 부탁드립니다.');