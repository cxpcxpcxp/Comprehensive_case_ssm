CREATE TABLE product(
   productId INT AUTO_INCREMENT PRIMARY KEY COMMENT "商品ID",
   productNum VARCHAR(50) NOT NULL UNIQUE COMMENT "商品编号",
   productName VARCHAR(50) COMMENT "商品名称",
   cityName VARCHAR(50) COMMENT "旅游城市",
   departureTime TIMESTAMP COMMENT "添加时间",
   productPrice DOUBLE COMMENT "商品价格",
   productDesc VARCHAR(500) COMMENT "商品描述",
   productStatus INT COMMENT "商品是否上架"
)
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10000', '北京三日游', '北京', NOW(), 1200, '不错的旅行', 1);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10001', '上海五日游', '上海', NOW(), 1800, '魔都我来了', 0);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10002', '北京三日游', '北京', NOW(), 1300, '不错的旅行', 1);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10003', '湖南三日游', '湖南', NOW(), 1600, '不错的旅行', 1);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10004', '湖北三日游', '湖北', NOW(), 1700, '不错的旅行', 1);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10005', '安徽三日游', '安徽', NOW(), 1700, '不错的旅行', 1);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10006', '黑龙江三日游', '黑龙江', NOW(), 1700, '不错的旅行', 1);
INSERT INTO product (productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus)
VALUES (NULL, '10007', '苏州三日游', '苏州', NOW(), 1700, '不错的旅行', 1);

CREATE TABLE `order`(
  orderId INT PRIMARY KEY AUTO_INCREMENT COMMENT "订单ID",
  orderNum VARCHAR(20) NOT NULL UNIQUE COMMENT "订单编号",
  orderTime TIMESTAMP COMMENT "订单生成时间",
  peopleCount INT COMMENT "旅游人数",
  orderDesc VARCHAR(500) COMMENT "订单描述",
  payType INT COMMENT "支付方式(0 支付宝 1 微信 2其它)",
  orderStatus INT COMMENT "订单状态(0 未支付 1 已支付)",
  productId VARCHAR(32) COMMENT "产品id",
  memberId VARCHAR(32) COMMENT "会员(联系人）id"
  -- FOREIGN KEY (productId) REFERENCES product(id),  FOREIGN KEY (memberId) REFERENCES member(id)
);

INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10000', NOW(), 2, '没什么', 0, 1, "10000", 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10001', NOW(), 2, '没什么', 0, 1, "10000", 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10002', NOW(), 2, '没什么', 0, 1, '10001', 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10003', NOW(), 2, '没什么', 0, 1, '10001', 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10004', NOW(), 2, '没什么', 0, 1, '10001', 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10005', NOW(), 2, '没什么', 0, 1, '10001', 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10006', NOW(), 2, '没什么', 0, 1, '10002', 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10007', NOW(), 2, '没什么', 0, 1, '10002', 1);
INSERT INTO `order` (orderId, orderNum, orderTime, peopleCount, orderDesc, payType, orderStatus, productId, memberId)
VALUES (NULL, '10008', NOW(), 2, '没什么', 0, 1, '10002', 1);

CREATE TABLE member(
       memberId INT AUTO_INCREMENT PRIMARY KEY COMMENT "主键",
       memberName VARCHAR(20) COMMENT "姓名",
       nickName VARCHAR(20) COMMENT "昵称",
       phoneNum VARCHAR(20) COMMENT "电话号码",
       email VARCHAR(20) COMMENT "邮箱"
)
INSERT INTO member (memberId, memberName, nickName, phoneNum, email)
VALUES (NULL, '张三', '小三', '18888888888', 'zs@163.com');


CREATE TABLE traveller(
	`travellerId` INT PRIMARY KEY AUTO_INCREMENT COMMENT "人物ID",
	`travellerName` VARCHAR(20) COMMENT "人物姓名",
	`sex` VARCHAR(20) COMMENT "人物性别",
	`phoneNum` VARCHAR(20) COMMENT "手机号码",
	`credentialsType` INT COMMENT "证件类型 0身份证 1护照 2军官证",
	`credentialsNum` VARCHAR(50) COMMENT "证件号码",
	`travellerType` INT COMMENT "旅客类型(人群) 0 成人 1 儿童"
)

INSERT INTO TRAVELLER (travellerId, travellerName, sex, phonenum, credentialstype, credentialsnum, travellertype)
VALUES (NULL, '张龙', '男', '13333333333', 0, '123456789009876543', 0);
INSERT INTO TRAVELLER (travellerId, travellerName, sex, phonenum, credentialstype, credentialsnum, travellertype)
VALUES (NULL, '张小龙', '男', '15555555555', 0, '987654321123456789', 1);

CREATE TABLE order_traveller(
   orderId VARCHAR(32) PRIMARY KEY COMMENT "订单ID",
   travellerId VARCHAR(32) COMMENT "旅客ID"
)
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10000', '10000');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10001', '10000');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10002', '10001');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10003', '10001');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10004', '10000');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10005', '10001');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10006', '10000');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10007', '10001');
INSERT INTO order_traveller (orderId, travellerId) VALUES ('10008', '10001');


SELECT * FROM `order`;

INSERT INTO product(productId, productNum, productName, cityName, departureTime, productPrice, productDesc, productStatus) VALUES
(NULL, 1008, "海南岛十日游", "海南", NOW(), 4000, "还可以的旅行", 0)

CREATE TABLE users(
  id int AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(50) UNIQUE NOT NULL,
  username VARCHAR(50),
  PASSWORD VARCHAR(50),
  phoneNum VARCHAR(20),
  STATUS INT
);

Insert into users(email,username,password,phonenum,status) values('krisswen@sina.cn','kriss','123','13545094482',0);

CREATE TABLE role(
  id int AUTO_INCREMENT PRIMARY KEY,
  roleName VARCHAR(50) ,
  roleDesc VARCHAR(50)
)

CREATE TABLE users_role(
  userId int,
  roleId int,
  PRIMARY KEY(userId,roleId),
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (roleId) REFERENCES role(id)
)

CREATE TABLE permission(
  id int AUTO_INCREMENT PRIMARY KEY,
  permissionName VARCHAR(50) ,
  url VARCHAR(50)
)

CREATE TABLE role_permission(
  permissionId int,
  roleId int,
  PRIMARY KEY(permissionId,roleId),
  FOREIGN KEY (permissionId) REFERENCES permission(id),
  FOREIGN KEY (roleId) REFERENCES role(id)
)