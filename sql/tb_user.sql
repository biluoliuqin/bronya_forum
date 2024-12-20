SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userId` int NOT NULL AUTO_INCREMENT COMMENT '用户id-唯一标识',
  `userName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名-账号 用于登陆',
  `nickName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '密码',
  `isVip` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否是vip用户',
  `projectNum` int NULL DEFAULT NULL COMMENT '已有项目数',
  `reg_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `phoneNum` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `wrId` int NULL DEFAULT NULL COMMENT '工作室id',
  `headSculpture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像路径或者图片名',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `hobby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '爱好',
  PRIMARY KEY (`userId`) USING BTREE,
  INDEX `wrId`(`wrId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25842 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


INSERT INTO `tb_user` VALUES (1, 'biluo', '碧落瑠琴', '1234', 'true', 10, '2024-05-03 15:05:27', '15398412115', '1765353745@qq.com', 1, 'bronya.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (2, '琪亚娜', '琪亚娜.卡斯兰娜', '123456', 'false', 2, '2024-05-03 15:01:24', '123123213', NULL, NULL, 'kiana.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (3, '姬子', '姬子', '123456', 'true', 4, '2024-05-03 15:01:24', NULL, '', 1, 'jizi.jpg', NULL, NULL);
INSERT INTO `tb_user` VALUES (4, '雷电芽衣', '雷电芽衣', '123456', 'true', 13, '2024-05-03 15:01:24', NULL, NULL, 1, 'yayi.jpg', NULL, NULL);


SET FOREIGN_KEY_CHECKS = 1;

	
