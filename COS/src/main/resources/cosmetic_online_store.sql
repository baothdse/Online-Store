create database if not exists cosmetic_online_store;

use cosmetic_online_store;
create table Discount (
discountId int not null auto_increment,
discountCode varchar(20),
startDate date, 
endDate date,
amount int,
productId int,
primary key (discountId)
);

create table Product (
productId int not null auto_increment,
productName varchar(255) not null,
introduction text,
productKind varchar(255),
brand varchar(255),
price varchar(20),
productQuantity int,
addedDate date,
addedTime time,
soldQuantity int,
discountId int,
primary key (productId),
constraint fk_discount foreign key (discountId) references Discount(discountId) 
);

create table Image (
imageId int not null auto_increment,
link text,
productId int,
main boolean,
primary key (imageId),
constraint fk_product_image foreign key (productId) references Product(productId)
);

create table User (
userId int not null auto_increment,
username varchar(255),
password varchar(255),
roleId int,
primary key(userId)
);

create table Cart (
cartId int not null auto_increment,
totalPrice varchar(20),
checkOut boolean,
primary key (cartId)
);

create table CartDetail (
cartId int not null,
fullName varchar(255),
address varchar(255),
city varchar(255),
email varchar(255),
phone varchar(20),
addedDate date,
addedTime time,
primary key (cartId),
constraint fk_cart_detail foreign key (cartId) references Cart(cartId)
);

create table SelectedProduct (
selectedId int not null auto_increment,
quantity int,
productId int,
cartId int,
primary key(selectedId),
constraint fk_selected foreign key (productId) references Product(productId),
constraint fk_cart foreign key (cartId) references Cart(cartId)
);

create table News(
newId int not null auto_increment,
header text,
content text,
addedDate date,
addedTime time,
userId int,
primary key (newId),
constraint fk_user_news foreign key (userId) references User(userId)
);

create table Videos(
videoId int not null auto_increment,
link text,
addedDate date,
addedTime time,
userId int,
primary key (videoId),
constraint fk_user_video foreign key (userId) references User(userId)
);
INSERT INTO `cosmetic_online_store`.`user` (`username`, `password`, `roleId`) VALUES ('admin', 'admin', '1');

/*product*/
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (1,'KEM DƯỠNG CHIẾT XUẤT CÚC LA MÃ','Dưỡng trắng da bằng Vitamin B3 nồng độ cao, cho da sáng màu mà không bào mòn hoặc tổn hại đến da. Chất kem nhẹ, mịn dễ thấm vào da, nuôi dưỡng da khỏe từ bên trong. Với chiết xuất cúc la mã, kem hoàn toàn dịu nhẹ cho da nhạy cảm. Kem phù hợp với da dầu lẫn da khô, hỗ trợ giảm các đốm nâu trên da hiệu quả. ','Body','Narguirite','100000',100,'2017-04-21','18:37:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (2,'KEM GIẢM THÂM MẮT CHIẾT XUẤT NỤ TẦM XUÂN','Với thành phần chứa các axit béo có lợi như Omega 3-6-9, Beta Carotene, Vitamin C,...cung cấp dưỡng chất cho da, giúp da luôn ẩm mượt, căng mịn, đàn hồi. Bên cạnh đó kem còn giúp giảm bọng mắt, giảm nếp nhăn và cải thiện quầng thâm tối màu. ','face','Narguirite','170000',50,'2017-04-21','18:39:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (3,'SERUM DƯỠNG TRẮNG TÁI TẠO DA BAN ĐÊM','Với chiết xuất dịch ốc sên và chiết xuất 10 loại hoa giúp hồi phục, tái tạo da yếu, dưỡng trắng, cho da căng mịn, đàn hồi, ngăn ngừa lão hóa. Cách sử dụng: mỗi tối, xoa đều 1-2 giọt serum trong lòng bàn tay, sau đó áp đều lên khắp mặt và cổ. Bảo quản: nơi khô mát, tránh ánh nắng trực tiếp. Lưu ý: sản phẩm không dùng cho da mụn hoặc da bị kích ứng, thử trước ra cổ tay hoặc góc hàm trước khi sử dụng.','Body','Narguirite','195000',35,'2017-04-21','18:40:00',1);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (4,'GEL LOẠI DA CHẾT NHA ĐAM','Loại bỏ sạch lớp da chết với cellulose thực vật, cực kì an toàn cho da, giúp cho da thông thoáng, dễ hấp thụ các dưỡng chất từ các sản phẩm dưỡng da, se lỗ chân lông hiệu quả, ngừa được tình trạng da bị khô sần, mụn.','face','Narguirite','120000',100,'2017-04-21','18:41:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (5,'ALL DAY MAKE UP BODY CREAM','Với chỉ số SPF 45 PA+++, bảo vệ da bạn dưới tia UV, đồng thời trong kem có lớp phấn mịn che phủ cho da, giúp da bật tông lập tức. Chất kem mềm mịn, tan nhanh trên da. Trong kem chứa Vitamin B3 cho da được dưỡng suốt cả ngày. ','Body','Narguirite','195000',65,'2017-04-21','18:42:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (6,'KEM DƯỠNG TRẮNG HỒNG DA BAN ĐÊM','Với Vitamin B3 dồi dào dưỡng ẩm chuyên sâu cho da, giúp da mềm mại, trắng hồng từ bên trong. Chất kem mềm mịn, giúp thao tác thoa kem nhanh chóng và dễ dàng. ','Body','Narguirite','255000',100,'2017-04-21','18:43:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (7,'SERUM GIẢM NÁM VÀ TÀN NHANG - NGĂN NGỪA LÃO HÓA','Với hoạt chất Alpha-Arbutin làm ức chế các enzym sản sinh sắc tố melanin sẫm màu - nguyên nhân hình thành nám và tàn nhang - giúp cho các vết nám và tàn nhang mờ đi, đồng thời dưỡng trắng, giảm nếp nhăn và ngăn ngừa lão hóa hiệu quả.','face','Narguirite','300000',150,'2017-04-21','18:43:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (8,'NHŨ TƯƠNG DÀNH CHO DA DẦU/ DA MỤN','Với hoạt chất Pionin, tinh nghệ nano và chiết xuất lá cây lộc đề có công dụng kháng khuẩn cho da, giúp làm dịu đi những nốt mụn đang viêm sưng, làm khô cồi mụn và kiểm soát lượng dầu trên da. ','face','Narguirite','240000',120,'2017-04-21','18:44:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (9,'KEM DƯỠNG TRẮNG TRỊ THÂM SAU MỤN','Với cơ chế đẩy lùi melanin song song với chế độ dinh dưỡng phục hồi, #KemTrịThâmSauMụn vừa xoá tan các vết thâm, vừa giúp kích thích tái tạo da mới, lấy lại sức sống cho da. Kem sử dụng NIACINAMIDE và ARBUTIN là hai hoạt chất chính để làm trắng da, kết hợp một số Axit béo thiết yếu để tăng trưởng màng tế bào, và các chiết xuất tự nhiên giúp chống oxy hoá hiệu quả dành riêng cho DA SAU MỤN.','face','Narguirite','295000',50,'2017-04-21','18:45:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (10,'MẶT NẠ NGỦ CẤP NƯỚC HYALURONIC ACID','Diện mạo hoàn toàn mới, công thức cải tiến với chất gel trong suốt, tươi mát, đặc biệt thấm nhanh vào da #MặtNạNgủ Narguerite nuôi dưỡng da suốt cả đêm dài, dưỡng ẩm tối ưu với Hyaluronic Acid mang lại cho bạn làn da mềm mại, mịn màng mỗi sáng sau khi thức dậy.','face','Narguirite','225000',20,'2017-04-21','18:46:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (11,'TẮM TRẮNG THUỐC BẮC','Sản phẩm 100% thiên nhiên, mọi đối tượng đều có thể sử dụng được kể cả mẹ đang mang thai. Sản phẩm giúp tẩy sạch lớp da chết, giảm mụn trên body và giúp da mềm mịn, thấm kem dưỡng gấp 3 lần.','Body','Narguirite','120000',45,'2017-04-21','18:47:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (12,'SERUM ĐẶC TRỊ THÂM MÔI','Với thành hoàn toàn thiên nhiên, không hóa chất và chất bảo quản, serum hoàn toàn an toàn cho da môi, giúp cải thiện màu môi hiệu quả, lọc các độc tố từ cặn mỹ phẩm, nuôi dưỡng da môi cho môi luôn hồng hào, đầy sức sống. Serum còn có thể làm một lớp lót mỏng trước khi son môi cho màu son lên đều. ','face','Narguirite','125000',20,'2017-04-21','18:47:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (13,'MUỐI TẮM CÀ PHÊ','Với hạt cà phê nguyên chất, chiết xuất thảo dược, trái cây cùng Vitamin E và mật ong giúp nhẹ nhàng loại bỏ da chết, cung cấp độ ẩm cho da, giúp da mịn màng, ẩm mượt. Muối tắm đồng thời còn giảm thâm hoặc các vết chai sần ở đầu gối, khuỷu tay,...','Body','Narguirite','160000',63,'2017-04-21','18:48:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (14,'KEM TẨY TRANG KHOÁNG NÚI LỬA','Chứa các hạt khoáng núi lửa cực nhỏ giúp làm sạch sâu từ lỗ chân lông, kem giúp làm tan đi lớp trang điểm một cách dễ dàng, không gây khô ráp da mà giúp da mềm ẩm sau mỗi lần sử dụng. Bên cạnh đó sản phẩm không chứa hương liệu mà có tinh dầu tràm trà nguyên chất giúp kháng khuẩn và ngừa mụn hiệu quả.','face','Narguirite','170000',28,'2017-04-21','18:49:00',0);
INSERT INTO `product` (`productId`,`productName`,`introduction`,`productKind`,`brand`,`price`,`productQuantity`,`addedDate`,`addedTime`,`soldQuantity`) VALUES (15,'SỮA RỬA MẶT KHOÁNG NÚI LỬA','abc','abc','abc','100000',20,'2017-05-01','16:00:12',0);

/*image */
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (1,'https://www.seeklogo.net/wp-content/uploads/2016/05/instagram-icon-logo-vector-download.jpg',1,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (2,'https://www.seeklogo.net/wp-content/uploads/2016/11/wechat-logo-preview.png',2,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (3,'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/Microsoft_Skype_for_Business_logo.svg/2000px-Microsoft_Skype_for_Business_logo.svg.png',3,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (4,'https://www.seeklogo.net/wp-content/uploads/2016/11/twitter-icon-circle-blue-logo-preview.png',4,0);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (5,'https://facebookbrand.com/wp-content/themes/fb-branding/prj-fb-branding/assets/images/fb-art.png',5,0);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (6,'https://instagram-brand.com/wp-content/themes/ig-branding/assets/images/ig-logo-email.png',6,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (7,'http://www.okclipart.com/img112/qwrzspaugbfluvvkjcne.png',7,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (8,'http://logos-download.com/wp-content/uploads/2016/05/Xiaomi_logo.png',8,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (9,'https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-9/17425883_444388445902946_840160261761131966_n.jpg?oh=2c4cd3a7202cc63d94b8ca302cde04ac&oe=59984B04',9,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (10,'https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-9/17426329_444388485902942_5602682544270258837_n.jpg?oh=80ec727cb7e7393e177ed7e2d8b05bb7&oe=5989E89A',10,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (11,'https://scontent.fsgn2-2.fna.fbcdn.net/v/t1.0-9/17457514_444388472569610_7480762216035585724_n.jpg?oh=4db015e4020aecf6121cfc50369fb371&oe=59760498',11,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (12,'https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-9/17424924_444388272569630_5881678812592811070_n.jpg?oh=4394efb206ba1d2aef3f669d3b3b2bb3&oe=5982F6D3',12,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (13,'https://scontent.fsgn2-2.fna.fbcdn.net/v/t1.0-9/17457674_444388365902954_1092747493647799506_n.jpg?oh=a54f1c02abf888cd88dfed81d0743c18&oe=597F3656',13,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (14,'https://scontent.fsgn5-2.fna.fbcdn.net/v/t1.0-9/17424924_444388272569630_5881678812592811070_n.jpg?oh=4394efb206ba1d2aef3f669d3b3b2bb3&oe=5982F6D3',14,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (15,'https://wiki.videolan.org/images/Ubuntu-logo.png',15,1);
INSERT INTO `image` (`imageId`,`link`,`productId`,`main`) VALUES (16,'https://wiki.videolan.org/images/Ubuntu-logo.png',15,0);

/*video*/
INSERT INTO `videos` (`videoId`,`link`,`addedDate`,`addedTime`,`userId`) VALUES (1,'https://youtu.be/NlrYn_dZdqk','2017-06-16','16:09:00',1);
INSERT INTO `videos` (`videoId`,`link`,`addedDate`,`addedTime`,`userId`) VALUES (2,'https://youtu.be/QNnLqF4R0l4','2017-06-16','16:10:00',1);
