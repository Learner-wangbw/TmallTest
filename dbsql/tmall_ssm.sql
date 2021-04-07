/*
Navicat MySQL Data Transfer

Source Server         : 2020.4.9
Source Server Version : 50558
Source Host           : localhost:3306
Source Database       : tmall_ssm

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2021-04-05 16:05:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) NOT NULL COMMENT '分类的名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '女装 /内衣');
INSERT INTO `category` VALUES ('2', '男装 /运动户外');
INSERT INTO `category` VALUES ('3', '女鞋 /男鞋 /箱包');
INSERT INTO `category` VALUES ('4', '美妆 /个人护理');
INSERT INTO `category` VALUES ('5', '腕表 /眼镜 /珠宝饰品');
INSERT INTO `category` VALUES ('6', '手机 /数码 /电脑办公');
INSERT INTO `category` VALUES ('7', '母婴玩具');
INSERT INTO `category` VALUES ('8', '零食 /茶酒 /进口食品');
INSERT INTO `category` VALUES ('9', '生鲜水果');
INSERT INTO `category` VALUES ('10', '大家电 /生活电器');
INSERT INTO `category` VALUES ('11', '家具建材');
INSERT INTO `category` VALUES ('12', '汽车 /配件 /用品');
INSERT INTO `category` VALUES ('13', '家纺 /家饰 /鲜花');
INSERT INTO `category` VALUES ('14', '医药保健');
INSERT INTO `category` VALUES ('15', '厨具 /收纳 /宠物');
INSERT INTO `category` VALUES ('16', '图书音像');

-- ----------------------------
-- Table structure for `order_`
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `order_code` varchar(255) NOT NULL COMMENT '订单号',
  `address` varchar(255) NOT NULL COMMENT '收货地址',
  `post` varchar(255) NOT NULL COMMENT '邮编',
  `receiver` varchar(255) NOT NULL COMMENT '收货人姓名',
  `mobile` varchar(255) NOT NULL COMMENT '手机号码',
  `user_message` varchar(255) NOT NULL COMMENT '用户备注的信息',
  `create_date` datetime NOT NULL COMMENT '订单创建时间',
  `pay_date` datetime DEFAULT NULL COMMENT '订单支付时间',
  `delivery_date` datetime DEFAULT NULL COMMENT '发货日期',
  `confirm_date` datetime DEFAULT NULL COMMENT '确认收货日期',
  `user_id` int(11) DEFAULT NULL COMMENT '对应的用户id',
  `status` varchar(255) NOT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`),
  KEY `fk_order_user` (`user_id`),
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES ('16', '20210330111704414', '', '', '', '', '', '2021-03-30 00:00:00', '2021-03-30 00:00:00', '2021-03-30 00:00:00', '2021-03-30 00:00:00', '7', 'delete');
INSERT INTO `order_` VALUES ('17', '20210330111928376', '', '', '', '', '', '2021-03-30 00:00:00', '2021-03-30 00:00:00', '2021-03-30 00:00:00', '2021-03-30 00:00:00', '7', 'delete');
INSERT INTO `order_` VALUES ('27', '20210402134622717', '', '', '', '', '', '2021-04-02 13:46:22', null, null, null, '7', 'finish');
INSERT INTO `order_` VALUES ('28', '20210402140851807', '4.2测试', '0000', '测试', '11111111111', '', '2021-04-02 14:08:51', null, null, null, '7', 'finish');
INSERT INTO `order_` VALUES ('33', '20210402185618121', '', '', '', '', '', '2021-04-02 18:56:18', '2021-04-02 18:56:19', null, null, '7', 'waitDelivery');
INSERT INTO `order_` VALUES ('34', '20210402205752054', '', '', '', '', '', '2021-04-02 20:57:52', '2021-04-02 20:57:53', null, null, '7', 'waitDelivery');
INSERT INTO `order_` VALUES ('35', '20210403140323639', '4.3测试', '0000', 'Mr.Wang', '11111111111', '', '2021-04-03 14:03:23', '2021-04-03 14:03:25', '2021-04-03 14:04:00', '2021-04-03 14:05:16', '7', 'finish');
INSERT INTO `order_` VALUES ('36', '20210403140551566', '4.3测试2', '0000', 'Mr.Wang', '11111111111', '', '2021-04-03 14:05:51', '2021-04-03 14:05:53', '2021-04-03 14:06:05', '2021-04-03 14:06:15', '7', 'finish');
INSERT INTO `order_` VALUES ('37', '20210404205203824', '中国', '0000', 'Mr.Wang', '11111111111', '', '2021-04-04 20:52:03', '2021-04-04 20:52:07', null, null, '7', 'waitDelivery');
INSERT INTO `order_` VALUES ('38', '20210405144646355', '演示测试', '0000', 'Mr.Wang', '11111111111', '', '2021-04-05 14:46:46', '2021-04-05 14:47:29', null, null, '7', 'waitDelivery');

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应产品id',
  `order_id` int(11) DEFAULT NULL COMMENT '对应订单id',
  `user_id` int(11) NOT NULL COMMENT '对应用户id',
  `number` int(11) DEFAULT NULL COMMENT '对应产品购买的数量',
  PRIMARY KEY (`id`),
  KEY `fk_order_item_product` (`product_id`),
  KEY `fk_order_item_order` (`order_id`),
  KEY `fk_order_item_user` (`user_id`),
  CONSTRAINT `fk_order_item_order` FOREIGN KEY (`order_id`) REFERENCES `order_` (`id`),
  CONSTRAINT `fk_order_item_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_order_item_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('57', '9', null, '7', '1');
INSERT INTO `order_item` VALUES ('58', '8', '38', '7', '1');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) NOT NULL COMMENT '产品的名称',
  `sub_title` varchar(255) DEFAULT NULL COMMENT '小标题',
  `price` float DEFAULT NULL COMMENT '价格',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `category_id` int(11) DEFAULT NULL COMMENT '对应的分类id',
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('4', 'ROSETREE吊带睡裙女夏季性感蕾丝薄款带胸垫仙女风公主宫廷睡衣女', '透视蕾丝背部设计，释放性感魅力', '338', '345', '6666', '1');
INSERT INTO `product` VALUES ('5', '贝妍睡衣女春夏季纯棉短袖长裤家居服韩版大码可外穿薄款全棉套装', '舒适面料 柔软亲肤 时尚居家 休闲可外穿', '226', '111', '6666', '1');
INSERT INTO `product` VALUES ('7', '贝妍春夏季女士薄款睡衣韩版宽松可外穿女纯棉短袖长裤家居服套装', '舒适面料 柔软亲肤 时尚居家 韩版可外穿', '248', '369', '6666', '1');
INSERT INTO `product` VALUES ('8', '黑色波点连衣裙女2021年新款夏季洋气时尚大码女装宽松显瘦小黑裙', '优雅圆点 轻奢时尚', '422', '4396', '6666', '1');
INSERT INTO `product` VALUES ('9', '茵曼宽松短外套女士纯棉短款2021春秋新款休闲可爱绣花百搭外穿', '包针绣花的翻领设计，舒适质感的100%茵曼棉', '359', '369', '6666', '1');
INSERT INTO `product` VALUES ('10', '产品7', '', null, null, null, '1');
INSERT INTO `product` VALUES ('11', '产品8', '', null, null, null, '1');
INSERT INTO `product` VALUES ('12', '产品9', '', null, null, null, '1');
INSERT INTO `product` VALUES ('13', '产品10', '', null, null, null, '1');
INSERT INTO `product` VALUES ('14', '产品11', '', null, null, null, '1');
INSERT INTO `product` VALUES ('15', '产品12', '', null, null, null, '1');
INSERT INTO `product` VALUES ('16', '产品13', '', null, null, null, '1');
INSERT INTO `product` VALUES ('17', '产品14', '', null, null, null, '1');
INSERT INTO `product` VALUES ('18', '产品15', '', null, null, null, '1');
INSERT INTO `product` VALUES ('19', '产品16', '', null, null, null, '1');
INSERT INTO `product` VALUES ('20', '产品17', '', null, null, null, '1');
INSERT INTO `product` VALUES ('24', '龙牙三代烈刃弹力战术裤男运动户外长裤春秋男裤夏季工装裤子铁血', '告别秋冬静电尴尬', '598', '38', '100', '2');
INSERT INTO `product` VALUES ('25', '产品18', '', null, null, null, '1');

-- ----------------------------
-- Table structure for `product_image`
-- ----------------------------
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE `product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) DEFAULT NULL COMMENT '对应的产品id',
  PRIMARY KEY (`id`),
  KEY `fk_product_image_product` (`product_id`),
  CONSTRAINT `fk_product_image_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_image
-- ----------------------------
INSERT INTO `product_image` VALUES ('11', '4');
INSERT INTO `product_image` VALUES ('12', '4');
INSERT INTO `product_image` VALUES ('13', '4');
INSERT INTO `product_image` VALUES ('14', '4');
INSERT INTO `product_image` VALUES ('15', '4');
INSERT INTO `product_image` VALUES ('16', '5');
INSERT INTO `product_image` VALUES ('17', '5');
INSERT INTO `product_image` VALUES ('18', '5');
INSERT INTO `product_image` VALUES ('19', '5');
INSERT INTO `product_image` VALUES ('20', '5');
INSERT INTO `product_image` VALUES ('26', '7');
INSERT INTO `product_image` VALUES ('27', '7');
INSERT INTO `product_image` VALUES ('28', '7');
INSERT INTO `product_image` VALUES ('29', '7');
INSERT INTO `product_image` VALUES ('30', '7');
INSERT INTO `product_image` VALUES ('31', '8');
INSERT INTO `product_image` VALUES ('32', '8');
INSERT INTO `product_image` VALUES ('33', '8');
INSERT INTO `product_image` VALUES ('34', '8');
INSERT INTO `product_image` VALUES ('35', '8');
INSERT INTO `product_image` VALUES ('36', '9');
INSERT INTO `product_image` VALUES ('37', '9');
INSERT INTO `product_image` VALUES ('38', '9');
INSERT INTO `product_image` VALUES ('39', '9');
INSERT INTO `product_image` VALUES ('40', '9');
INSERT INTO `product_image` VALUES ('41', '10');
INSERT INTO `product_image` VALUES ('42', '10');
INSERT INTO `product_image` VALUES ('43', '10');
INSERT INTO `product_image` VALUES ('44', '10');
INSERT INTO `product_image` VALUES ('45', '10');
INSERT INTO `product_image` VALUES ('46', '11');
INSERT INTO `product_image` VALUES ('47', '11');
INSERT INTO `product_image` VALUES ('48', '11');
INSERT INTO `product_image` VALUES ('49', '11');
INSERT INTO `product_image` VALUES ('50', '11');
INSERT INTO `product_image` VALUES ('51', '12');
INSERT INTO `product_image` VALUES ('52', '12');
INSERT INTO `product_image` VALUES ('53', '12');
INSERT INTO `product_image` VALUES ('54', '12');
INSERT INTO `product_image` VALUES ('55', '12');
INSERT INTO `product_image` VALUES ('56', '13');
INSERT INTO `product_image` VALUES ('57', '13');
INSERT INTO `product_image` VALUES ('58', '13');
INSERT INTO `product_image` VALUES ('59', '13');
INSERT INTO `product_image` VALUES ('60', '13');
INSERT INTO `product_image` VALUES ('61', '14');
INSERT INTO `product_image` VALUES ('62', '14');
INSERT INTO `product_image` VALUES ('63', '14');
INSERT INTO `product_image` VALUES ('64', '14');
INSERT INTO `product_image` VALUES ('65', '14');
INSERT INTO `product_image` VALUES ('66', '15');
INSERT INTO `product_image` VALUES ('67', '15');
INSERT INTO `product_image` VALUES ('68', '15');
INSERT INTO `product_image` VALUES ('69', '15');
INSERT INTO `product_image` VALUES ('70', '15');
INSERT INTO `product_image` VALUES ('71', '16');
INSERT INTO `product_image` VALUES ('72', '16');
INSERT INTO `product_image` VALUES ('73', '16');
INSERT INTO `product_image` VALUES ('74', '16');
INSERT INTO `product_image` VALUES ('75', '16');
INSERT INTO `product_image` VALUES ('76', '17');
INSERT INTO `product_image` VALUES ('77', '17');
INSERT INTO `product_image` VALUES ('78', '17');
INSERT INTO `product_image` VALUES ('79', '17');
INSERT INTO `product_image` VALUES ('80', '17');
INSERT INTO `product_image` VALUES ('81', '18');
INSERT INTO `product_image` VALUES ('82', '18');
INSERT INTO `product_image` VALUES ('83', '18');
INSERT INTO `product_image` VALUES ('84', '18');
INSERT INTO `product_image` VALUES ('85', '18');
INSERT INTO `product_image` VALUES ('86', '19');
INSERT INTO `product_image` VALUES ('87', '19');
INSERT INTO `product_image` VALUES ('88', '19');
INSERT INTO `product_image` VALUES ('89', '19');
INSERT INTO `product_image` VALUES ('90', '19');
INSERT INTO `product_image` VALUES ('91', '20');
INSERT INTO `product_image` VALUES ('92', '20');
INSERT INTO `product_image` VALUES ('93', '20');
INSERT INTO `product_image` VALUES ('94', '20');
INSERT INTO `product_image` VALUES ('95', '20');
INSERT INTO `product_image` VALUES ('111', '24');
INSERT INTO `product_image` VALUES ('112', '24');
INSERT INTO `product_image` VALUES ('113', '24');
INSERT INTO `product_image` VALUES ('114', '24');
INSERT INTO `product_image` VALUES ('115', '24');
INSERT INTO `product_image` VALUES ('116', '25');
INSERT INTO `product_image` VALUES ('117', '25');
INSERT INTO `product_image` VALUES ('118', '25');
INSERT INTO `product_image` VALUES ('119', '25');
INSERT INTO `product_image` VALUES ('120', '25');

-- ----------------------------
-- Table structure for `property`
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) DEFAULT NULL COMMENT '属性名称',
  `category_id` int(11) NOT NULL COMMENT '对应的分类id',
  PRIMARY KEY (`id`),
  KEY `fk_property_category` (`category_id`),
  CONSTRAINT `fk_property_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of property
-- ----------------------------
INSERT INTO `property` VALUES ('1', '尺寸', '1');
INSERT INTO `property` VALUES ('2', '厚薄', '1');
INSERT INTO `property` VALUES ('3', '材质成分', '1');
INSERT INTO `property` VALUES ('4', '货号', '1');
INSERT INTO `property` VALUES ('5', '基础风格', '1');
INSERT INTO `property` VALUES ('6', '品牌', '1');
INSERT INTO `property` VALUES ('7', '尺寸', '2');
INSERT INTO `property` VALUES ('8', '产地', '2');

-- ----------------------------
-- Table structure for `property_value`
-- ----------------------------
DROP TABLE IF EXISTS `property_value`;
CREATE TABLE `property_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `product_id` int(11) NOT NULL COMMENT '对应产品id',
  `property_id` int(11) NOT NULL COMMENT '对应属性id',
  `value` varchar(255) DEFAULT NULL COMMENT '具体的属性值',
  PRIMARY KEY (`id`),
  KEY `fk_property_value_property` (`property_id`),
  KEY `fk_property_value_product` (`product_id`),
  CONSTRAINT `fk_property_value_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_property_value_property` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of property_value
-- ----------------------------
INSERT INTO `property_value` VALUES ('1', '4', '1', 'L M XL XLL');
INSERT INTO `property_value` VALUES ('2', '4', '2', '常规');
INSERT INTO `property_value` VALUES ('3', '4', '3', '棉66% 聚酯纤维34%');
INSERT INTO `property_value` VALUES ('4', '4', '4', 'UQ404133000');
INSERT INTO `property_value` VALUES ('5', '4', '5', '其他');
INSERT INTO `property_value` VALUES ('6', '4', '6', 'Uniqlo/优衣库');
INSERT INTO `property_value` VALUES ('11', '24', '7', 'L M XL XLL XLLL');
INSERT INTO `property_value` VALUES ('12', '24', '8', '中国');

-- ----------------------------
-- Table structure for `referal_link`
-- ----------------------------
DROP TABLE IF EXISTS `referal_link`;
CREATE TABLE `referal_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `text` varchar(255) NOT NULL COMMENT '超链显示的文字',
  `link` varchar(255) NOT NULL COMMENT '超链的地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of referal_link
-- ----------------------------
INSERT INTO `referal_link` VALUES ('1', '天猫会员', '#nowhere');
INSERT INTO `referal_link` VALUES ('2', '电器城', '#nowhere');
INSERT INTO `referal_link` VALUES ('3', '喵鲜生', '#nowhere');
INSERT INTO `referal_link` VALUES ('4', '医药馆', '#nowhere');
INSERT INTO `referal_link` VALUES ('5', '营业厅', '#nowhere');
INSERT INTO `referal_link` VALUES ('6', '魅力惠', '#nowhere');
INSERT INTO `referal_link` VALUES ('7', '飞猪旅游', '#nowhere');
INSERT INTO `referal_link` VALUES ('8', '苏宁易购', '#nowhere');

-- ----------------------------
-- Table structure for `review`
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `content` varchar(4000) DEFAULT NULL COMMENT '评价内容',
  `user_id` int(11) NOT NULL COMMENT '对应的用户id',
  `product_id` int(11) NOT NULL COMMENT '对应的产品id',
  `createDate` datetime DEFAULT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`),
  KEY `fk_review_product` (`product_id`),
  KEY `fk_review_user` (`user_id`),
  CONSTRAINT `fk_review_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_review_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('11', '不错！', '7', '4', '2021-03-30 11:18:51');
INSERT INTO `review` VALUES ('12', '可以的', '7', '4', '2021-03-30 11:21:02');
INSERT INTO `review` VALUES ('13', '测试 烦死了', '7', '4', '2021-04-02 10:39:19');
INSERT INTO `review` VALUES ('14', '111', '7', '7', '2021-04-02 10:41:43');
INSERT INTO `review` VALUES ('15', '测试', '7', '4', '2021-04-03 14:05:29');
INSERT INTO `review` VALUES ('16', '测试', '7', '4', '2021-04-03 14:06:23');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一索引id',
  `name` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'demo', '123456');
INSERT INTO `user` VALUES ('7', 'ks', '123456');
INSERT INTO `user` VALUES ('8', 'wbw', '123456');
INSERT INTO `user` VALUES ('11', 'test', '123456');
