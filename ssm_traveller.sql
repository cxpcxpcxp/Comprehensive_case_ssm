CREATE TABLE traveller(
id varchar2(32) default SYS_GUID() PRIMARY KEY,
NAME VARCHAR2(20),
sex VARCHAR2(20),
phoneNum VARCHAR2(20),
credentialsType INT,
credentialsNum VARCHAR2(50),
travellerType INT )

insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype) values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype) values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0, '987654321123456789', 1);