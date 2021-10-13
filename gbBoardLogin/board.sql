--게시판 start----
--@게시판 테이블 생성!!
create table gb_board(
 bno number not null,
 title varchar2(100) not null,
 content clob not null,
 writer varchar2(100) not null,
 regdate date default sysdate,
 primary key(bno),
 HIT NUMBER DEFAULT 0,
 recnt number default 0 not null
);


select * from gb_board;
drop table gb_board;
--게시판 end----

--게시판 시퀀스 start--
--@게시판 시퀀스 테이블 생성
CREATE SEQUENCE GB_BOARD_SEQ
START WITH 1
INCREMENT BY 1;

drop sequence gb_board_seq;
--게시판 시퀀스 end--

--게시판 댓글 start
--@게시판 댓글 테이블 생성
create table gb_reply (
    bno number not null,
    rno number not null,
    content varchar2(1000) not null,
    writer varchar2(50) not null,
    regdate date default sysdate,
    primary key(bno, rno),
    CONSTRAINT gb_reply_bno FOREIGN KEY(bno) REFERENCES gb_board(bno) on delete cascade
);

drop table gb_reply;

delete from gb_reply;

--@게시판 댓글 시퀀스 생성
create sequence gb_reply_seq START WITH 1 MINVALUE 0;

drop sequence gb_reply_seq;
--게시판 댓글 end

--게시판 파일 start
--@게시판 파일 테이블 생성 
CREATE TABLE GB_FILE
(
    FILE_NO NUMBER,                         --파일 번호
    BNO NUMBER NOT NULL,                    --게시판 번호
    ORG_FILE_NAME VARCHAR2(260) NOT NULL,   --원본 파일 이름
    STORED_FILE_NAME VARCHAR2(36) NOT NULL, --변경된 파일 이름
    FILE_SIZE NUMBER,                       --파일 크기
    REGDATE DATE DEFAULT SYSDATE NOT NULL,  --파일등록일
    DEL_GB VARCHAR2(1) DEFAULT 'N' NOT NULL,--삭제구분
    PRIMARY KEY(FILE_NO)                    --기본키 FILE_NO
);

select * from gb_file;

delete from gb_file;

--@게시판 파일 시퀀스 생성
CREATE SEQUENCE SEQ_GB_FILE_NO
START WITH 1 
INCREMENT BY 1 
NOMAXVALUE NOCACHE;

drop sequence seq_gb_file_no;
select * from user_sequences;
--게시판 파일 end


--게시판 좋아요 start
--@게시판 좋아요 테이블 생성 
create table liketable(
    ltmid varchar2(100) not null,
    ltbid number not null,
    ltlike number default 0,
    FOREIGN KEY(ltmid) REFERENCES gb_member(userid) on delete cascade,
    FOREIGN KEY(ltbid) REFERENCES gb_board(bno) on delete cascade
);

select * from liketable;

delete from liketable;
commit;

drop table liketable;
--게시판 좋아요 end