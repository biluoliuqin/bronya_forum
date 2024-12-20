SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news`  (
  `newsId` int NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `theme` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主题',
  `content` varchar(4096) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主要内容',
  `photoUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  `newsTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发帖时间',
  `userId` int NULL DEFAULT NULL COMMENT '用户id',
  `priseNum` int NULL DEFAULT NULL COMMENT '获赞数',
  `excellent` int NULL DEFAULT 0 COMMENT '精华帖标志',
  `top` int NOT NULL DEFAULT 0 COMMENT '置顶标志',
  PRIMARY KEY (`newsId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  CONSTRAINT `tb_news_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `tb_news` VALUES (1, '崩坏', '崩坏。', 'houkai.jpg', '2024-05-03 15:10:37', 1, 1, 1, 1);
INSERT INTO `tb_news` VALUES (2, '鸭鸭', '摩托车', 'bike.jpg', '2024-05-03 15:10:37', 2, NULL, 0, 1);
INSERT INTO `tb_news` VALUES (3, '琪亚娜', '白毛', 'kiana.jpg', '2024-05-03 15:10:37', 1, 2, 0, 0);
INSERT INTO `tb_news` VALUES (14, '鸭鸭之旅', '鸭鸭', 'yaya.jpg', '2024-05-03 15:10:56', 4, 0, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;

