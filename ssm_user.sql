CREATE TABLE users(
   id varchar2(32) default SYS_GUID() PRIMARY KEY,
   email VARCHAR2(50) UNIQUE NOT NULL,
   username VARCHAR2(50),
   PASSWORD VARCHAR2(50),
   phoneNum VARCHAR2(20),
   STATUS INT
);
Insert into users(email,username,password,phonenum,status) values('krisswen@sina.cn','kriss','123','13545094482',0);