SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `tb_discussion`;
CREATE TABLE `tb_discussion`  (
  `discussionId` int NOT NULL AUTO_INCREMENT,
  `newsId` int NULL DEFAULT NULL,
  `userId` int NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `beDisedUserNicename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `discussionTime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`discussionId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `newsId`(`newsId`) USING BTREE,
  CONSTRAINT `tb_discussion_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `tb_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_discussion_ibfk_3` FOREIGN KEY (`newsId`) REFERENCES `tb_news` (`newsId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


INSERT INTO `tb_discussion` VALUES (1, 1, 1, '碧落瑠琴', '', '啦啦啦', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (2, 1, 2, '琪亚娜.卡斯兰娜','碧落瑠琴', '我一定会战胜崩坏', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (3, 2, 3, '姬子', NULL, '调皮', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (4, 5, 4, '雷电芽衣	', NULL, '雷霆降临', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (9, 1, 1, '碧落瑠琴', '', '啦啦啦', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (10, 2, 1, '碧落瑠琴', '姬子', '唯独互相喜欢全凭运气', '2024-05-03 15:03:31');
INSERT INTO `tb_discussion` VALUES (13, 9, 4, '雷电芽衣', '', '雷电芽衣', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (14, 8, 1, '碧落瑠琴', '雷电芽衣', '666', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (15, 5, 1, '碧落瑠琴', '雷电芽衣', '你怎么什么都知道', '2024-05-03 14:39:36');
INSERT INTO `tb_discussion` VALUES (17, 5, 1, '碧落瑠琴', '', '收拾收拾', '2024-05-03 14:39:36');

SET FOREIGN_KEY_CHECKS = 1;

