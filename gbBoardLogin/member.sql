--회원가입 start
CREATE TABLE gb_MEMBER(
    MEMBERMAIL VARCHAR(50) NOT NULL,
    USERID VARCHAR2(40) NOT NULL,
    USERPASS VARCHAR2(100) NOT NULL,
    USERNAME VARCHAR2(40) NOT NULL,
    REGDATE DATE DEFAULT SYSDATE,
    PRIMARY KEY(USERID)
);

drop table gb_member;

delete from gb_member;
commit;
select * from gb_member;
--회원가입 end