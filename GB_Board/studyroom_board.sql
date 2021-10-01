create table studyroom(
    study_name varchar2(30) constraint pk_stroom primary key,
    study_tag varchar2(15) not null,
    region varchar2(30),
    max_number number(5)    
);

select * from studyroom;

