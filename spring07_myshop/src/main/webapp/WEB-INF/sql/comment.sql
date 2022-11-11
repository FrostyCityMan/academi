CREATE table pcomment(
  cno number primary key, -- 댓글번호
  pno number not null, -- 상품 번호
  content varchar2(255) not null, --댓글 내용
  wname varchar2(255) not null, --작성자
  regdate date default sysdate --작성일
);

--create sequence
CREATE SEQUENCE pcomment_seq;
commit;