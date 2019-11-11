CREATE TABLE member(
       id varchar2(32) default SYS_GUID() PRIMARY KEY,
       NAME VARCHAR2(20),
       nickname VARCHAR2(20),
       phoneNum VARCHAR2(20),
       email VARCHAR2(20)
)
insert into MEMBER (id, name, nickname, phonenum, email) values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');