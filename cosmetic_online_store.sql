create database if not exists cosmetic_online_store;

use cosmetic_online_store;

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
primary key (productId)
);

create table Image (
imageId int not null auto_increment,
link text,
productId int,
primary key (imageId),
constraint fk_product_image foreign key (productId) references Product(productId)
);


create table Discount (
discountId int not null auto_increment,
discountCode varchar(20),
startDate date, 
endDate date,
amount varchar(5),
productId int,
constraint fk_discount foreign key (productId) references Product(productId),
primary key (discountId)
);


create table SelectedProduct (
selectedId int not null auto_increment,
quantity int,
productId int,
primary key(selectedId),
constraint fk_selected foreign key (productId) references Product(productId)
);

create table User (
userId int not null auto_increment,
username varchar(255),
password varchar(255),
firstName varchar(255),
lastName varchar(255),
address varchar(255),
city varchar(255),
email varchar(255),
phone varchar(20),
roleId int,
primary key(userId)
);

create table Cart (
cartId int not null auto_increment,
totalPrice varchar(20),
note text,
userId int,
primary key (cartId),
constraint fk_customer foreign key (userId) references User(userId)
);

create table SelectedProductCart (
selectedId int, 
cartId int,
primary key (selectedId, cartId),
constraint fk_selected_cart foreign key (selectedId) references SelectedProduct(selectedId),
constraint fk_cart foreign key (cartId) references Cart(cartId)
);

INSERT INTO `cosmetic_online_store`.`user` (`username`, `password`, `firstName`, `lastName`, `address`, `city`, `email`, `phone`, `roleId`) VALUES ('admin', 'admin', 'bao', 'thd', 'abc', 'hcm', 'bao@gmail.com', '1235567', '1');

/*product*/
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('KEM DƯỠNG CHIẾT XUẤT CÚC LA MÃ', 'Dưỡng trắng da bằng Vitamin B3 nồng độ cao, cho da sáng màu mà không bào mòn hoặc tổn hại đến da. Chất kem nhẹ, mịn dễ thấm vào da, nuôi dưỡng da khỏe từ bên trong. Với chiết xuất cúc la mã, kem hoàn toàn dịu nhẹ cho da nhạy cảm. Kem phù hợp với da dầu lẫn da khô, hỗ trợ giảm các đốm nâu trên da hiệu quả. ', 'Body', 'Narguirite', '100000', '100', '2017-04-21', '18:37');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('KEM GIẢM THÂM MẮT CHIẾT XUẤT NỤ TẦM XUÂN', 'Với thành phần chứa các axit béo có lợi như Omega 3-6-9, Beta Carotene, Vitamin C,...cung cấp dưỡng chất cho da, giúp da luôn ẩm mượt, căng mịn, đàn hồi. Bên cạnh đó kem còn giúp giảm bọng mắt, giảm nếp nhăn và cải thiện quầng thâm tối màu. ', 'Da mặt', 'Narguirite', '170000', '50', '2017-04-21', '18:39:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('SERUM DƯỠNG TRẮNG TÁI TẠO DA BAN ĐÊM', 'Với chiết xuất dịch ốc sên và chiết xuất 10 loại hoa giúp hồi phục, tái tạo da yếu, dưỡng trắng, cho da căng mịn, đàn hồi, ngăn ngừa lão hóa. Cách sử dụng: mỗi tối, xoa đều 1-2 giọt serum trong lòng bàn tay, sau đó áp đều lên khắp mặt và cổ. Bảo quản: nơi khô mát, tránh ánh nắng trực tiếp. Lưu ý: sản phẩm không dùng cho da mụn hoặc da bị kích ứng, thử trước ra cổ tay hoặc góc hàm trước khi sử dụng.', 'Body', 'Narguirite', '195000', '35', '2017-04-21', '18:40:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('GEL LOẠI DA CHẾT NHA ĐAM', 'Loại bỏ sạch lớp da chết với cellulose thực vật, cực kì an toàn cho da, giúp cho da thông thoáng, dễ hấp thụ các dưỡng chất từ các sản phẩm dưỡng da, se lỗ chân lông hiệu quả, ngừa được tình trạng da bị khô sần, mụn.', 'Da mặt', 'Narguirite', '120000', '100', '2017-04-21', '18:41:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('ALL DAY MAKE UP BODY CREAM', 'Với chỉ số SPF 45 PA+++, bảo vệ da bạn dưới tia UV, đồng thời trong kem có lớp phấn mịn che phủ cho da, giúp da bật tông lập tức. Chất kem mềm mịn, tan nhanh trên da. Trong kem chứa Vitamin B3 cho da được dưỡng suốt cả ngày. ', 'Body', 'Narguirite', '195000', '65', '2017-04-21', '18:42:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('KEM DƯỠNG TRẮNG HỒNG DA BAN ĐÊM', 'Với Vitamin B3 dồi dào dưỡng ẩm chuyên sâu cho da, giúp da mềm mại, trắng hồng từ bên trong. Chất kem mềm mịn, giúp thao tác thoa kem nhanh chóng và dễ dàng. ', 'Body', 'Narguirite', '255000', '100', '2017-04-21', '18:43:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('SERUM GIẢM NÁM VÀ TÀN NHANG - NGĂN NGỪA LÃO HÓA', 'Với hoạt chất Alpha-Arbutin làm ức chế các enzym sản sinh sắc tố melanin sẫm màu - nguyên nhân hình thành nám và tàn nhang - giúp cho các vết nám và tàn nhang mờ đi, đồng thời dưỡng trắng, giảm nếp nhăn và ngăn ngừa lão hóa hiệu quả.', 'Da mặt', 'Narguirite', '300000', '150', '2017-04-21', '18:43:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('NHŨ TƯƠNG DÀNH CHO DA DẦU/ DA MỤN', 'Với hoạt chất Pionin, tinh nghệ nano và chiết xuất lá cây lộc đề có công dụng kháng khuẩn cho da, giúp làm dịu đi những nốt mụn đang viêm sưng, làm khô cồi mụn và kiểm soát lượng dầu trên da. ', 'Da mặt', 'Narguirite', '240000', '120', '2017-04-21', '18:44:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('KEM DƯỠNG TRẮNG TRỊ THÂM SAU MỤN', 'Với cơ chế đẩy lùi melanin song song với chế độ dinh dưỡng phục hồi, #KemTrịThâmSauMụn vừa xoá tan các vết thâm, vừa giúp kích thích tái tạo da mới, lấy lại sức sống cho da. Kem sử dụng NIACINAMIDE và ARBUTIN là hai hoạt chất chính để làm trắng da, kết hợp một số Axit béo thiết yếu để tăng trưởng màng tế bào, và các chiết xuất tự nhiên giúp chống oxy hoá hiệu quả dành riêng cho DA SAU MỤN.', 'Da mặt', 'Narguirite', '295000', '50', '2017-04-21', '18:45:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('MẶT NẠ NGỦ CẤP NƯỚC HYALURONIC ACID', 'Diện mạo hoàn toàn mới, công thức cải tiến với chất gel trong suốt, tươi mát, đặc biệt thấm nhanh vào da #MặtNạNgủ Narguerite nuôi dưỡng da suốt cả đêm dài, dưỡng ẩm tối ưu với Hyaluronic Acid mang lại cho bạn làn da mềm mại, mịn màng mỗi sáng sau khi thức dậy.', 'Da mặt', 'Narguirite', '225000', '20', '2017-04-21', '18:46:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('TẮM TRẮNG THUỐC BẮC', 'Sản phẩm 100% thiên nhiên, mọi đối tượng đều có thể sử dụng được kể cả mẹ đang mang thai. Sản phẩm giúp tẩy sạch lớp da chết, giảm mụn trên body và giúp da mềm mịn, thấm kem dưỡng gấp 3 lần.', 'Body', 'Narguirite', '120000', '45', '2017-04-21', '18:47:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('SERUM ĐẶC TRỊ THÂM MÔI', 'Với thành hoàn toàn thiên nhiên, không hóa chất và chất bảo quản, serum hoàn toàn an toàn cho da môi, giúp cải thiện màu môi hiệu quả, lọc các độc tố từ cặn mỹ phẩm, nuôi dưỡng da môi cho môi luôn hồng hào, đầy sức sống. Serum còn có thể làm một lớp lót mỏng trước khi son môi cho màu son lên đều. ', 'Da mặt', 'Narguirite', '125000', '20', '2017-04-21', '18:47:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('MUỐI TẮM CÀ PHÊ', 'Với hạt cà phê nguyên chất, chiết xuất thảo dược, trái cây cùng Vitamin E và mật ong giúp nhẹ nhàng loại bỏ da chết, cung cấp độ ẩm cho da, giúp da mịn màng, ẩm mượt. Muối tắm đồng thời còn giảm thâm hoặc các vết chai sần ở đầu gối, khuỷu tay,...', 'Body', 'Narguirite', '160000', '63', '2017-04-21', '18:48:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('KEM TẨY TRANG KHOÁNG NÚI LỬA', 'KEM TẨY TRANG KHOÁNG NÚI LỬA', 'Da mặt', 'Narguirite', '170000', '28', '2017-04-21', '18:49:00');
INSERT INTO `cosmetic_online_store`.`product` (`productName`, `introduction`, `productKind`, `brand`, `price`, `productQuantity`, `addedDate`, `addedTime`) VALUES ('SỮA RỬA MẶT KHOÁNG NÚI LỬA', 'Chứa các hạt khoáng núi lửa cực nhỏ giúp làm sạch sâu từ lỗ chân lông, sữa rửa mặt ít bọt, phù hợp với nhiều loại da kể da cả mụn. Bên cạnh đó sản phẩm không chứa hương liệu mà có tinh dầu tràm trà nguyên chất giúp kháng khuẩn và ngừa mụn hiệu quả. Sản phẩm cam kết không gây khô da, bào mòn da hoặc làm mỏng da. ', 'Da mặt', 'Narguirite', '170000', '28', '2017-04-21', '18:50:00');
UPDATE `cosmetic_online_store`.`product` SET `introduction`='Chứa các hạt khoáng núi lửa cực nhỏ giúp làm sạch sâu từ lỗ chân lông, kem giúp làm tan đi lớp trang điểm một cách dễ dàng, không gây khô ráp da mà giúp da mềm ẩm sau mỗi lần sử dụng. Bên cạnh đó sản phẩm không chứa hương liệu mà có tinh dầu tràm trà nguyên chất giúp kháng khuẩn và ngừa mụn hiệu quả.' WHERE `productId`='14';
