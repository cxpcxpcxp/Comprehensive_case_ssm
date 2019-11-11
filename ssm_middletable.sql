CREATE TABLE order_traveller(
   orderId varchar2(32),
   travellerId varchar2(32),
   PRIMARY KEY (orderId,travellerId),
   FOREIGN KEY (orderId) REFERENCES orders(id),
   FOREIGN KEY (travellerId) REFERENCES traveller(id)
)

insert into ORDER_TRAVELLER (orderid, travellerid) values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960'); insert into ORDER_TRAVELLER (orderid, travellerid) values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');