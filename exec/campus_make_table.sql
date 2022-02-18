CREATE TABLE `user` (
  `userNo` int NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(128) NOT NULL,
  `userPassword` varchar(20) DEFAULT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `userProfileImage` varchar(128) DEFAULT NULL,
  `userLocation` varchar(20) DEFAULT NULL,
  `userAge` varchar(10) DEFAULT NULL,
  `userGender` varchar(10) DEFAULT NULL,
  `userNickname` varchar(20) DEFAULT NULL,
  `userMBTI` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`userNo`),
  UNIQUE KEY `user_idx_unique_email` (`userEmail`),
  UNIQUE KEY `user_idx_unique_nickname` (`userNickname`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `camp_site` (
  `content_id` varchar(255) NOT NULL,
  `addr1` varchar(255) DEFAULT NULL,
  `allar` int NOT NULL,
  `animal_cmg_cl` varchar(255) DEFAULT NULL,
  `auto_site_co` int NOT NULL,
  `brazier_cl` varchar(255) DEFAULT NULL,
  `carav_acmpny_at` char(1) NOT NULL,
  `carav_inner_fclty` varchar(255) DEFAULT NULL,
  `carav_site_co` int NOT NULL,
  `cltur_event` varchar(255) DEFAULT NULL,
  `cltur_event_at` char(1) NOT NULL,
  `createdtime` varchar(255) DEFAULT NULL,
  `do_nm` varchar(255) DEFAULT NULL,
  `eqpmn_lend_cl` varchar(255) DEFAULT NULL,
  `exprn_progrm` varchar(255) DEFAULT NULL,
  `exprn_progrm_at` char(1) NOT NULL,
  `extshr_co` int NOT NULL,
  `faclt_nm` varchar(255) DEFAULT NULL,
  `fire_sensor_co` int NOT NULL,
  `first_image_url` varchar(255) DEFAULT NULL,
  `frprvt_sand_co` int NOT NULL,
  `frprvt_wrpp_co` int NOT NULL,
  `glamp_inner_fclty` varchar(255) DEFAULT NULL,
  `glamp_site_co` int NOT NULL,
  `gnrl_site_co` int NOT NULL,
  `indvdl_carav_site_co` int NOT NULL,
  `intro` text,
  `lct_cl` varchar(255) DEFAULT NULL,
  `line_intro` varchar(255) DEFAULT NULL,
  `mapx` double NOT NULL,
  `mapy` double NOT NULL,
  `modifiedtime` varchar(255) DEFAULT NULL,
  `oper_de_cl` varchar(255) DEFAULT NULL,
  `oper_pd_cl` varchar(255) DEFAULT NULL,
  `posbl_fclty_cl` varchar(255) DEFAULT NULL,
  `posbl_fclty_etc` varchar(255) DEFAULT NULL,
  `resve_cl` varchar(255) DEFAULT NULL,
  `resve_url` text,
  `sbrs_cl` varchar(255) DEFAULT NULL,
  `sbrs_etc` varchar(255) DEFAULT NULL,
  `sigungu_nm` varchar(255) DEFAULT NULL,
  `site_bottom_cl1` int NOT NULL,
  `site_bottom_cl2` int NOT NULL,
  `site_bottom_cl3` int NOT NULL,
  `site_bottom_cl4` int NOT NULL,
  `site_bottom_cl5` int NOT NULL,
  `site_mg1co` int NOT NULL,
  `site_mg1vrticl` int NOT NULL,
  `site_mg1width` int NOT NULL,
  `site_mg2co` int NOT NULL,
  `site_mg2vrticl` int NOT NULL,
  `site_mg2width` int NOT NULL,
  `site_mg3co` int NOT NULL,
  `site_mg3vrticl` int NOT NULL,
  `site_mg3width` int NOT NULL,
  `sited_stnc` int NOT NULL,
  `swrm_co` int NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `thema_envrn_cl` varchar(255) DEFAULT NULL,
  `toilet_co` int NOT NULL,
  `tooltip` text,
  `tour_era_cl` varchar(255) DEFAULT NULL,
  `trler_acmpny_at` char(1) NOT NULL,
  `wtrpl_co` int NOT NULL,
  PRIMARY KEY (`content_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mate` (
  `mateNo` int NOT NULL AUTO_INCREMENT,
  `mateCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mateUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mateImageUrl` varchar(200) DEFAULT NULL,
  `mateCampsite` varchar(255) DEFAULT NULL,
  `mateCampstyle` varchar(20) DEFAULT NULL,
  `mateCamptype` varchar(20) DEFAULT NULL,
  `mateCampstart` date DEFAULT NULL,
  `mateCampend` date DEFAULT NULL,
  `contentId` varchar(12) NOT NULL,
  `mateStatus` varchar(1) DEFAULT 'Y',
  `userNo` int NOT NULL,
  `lowestAge` int DEFAULT NULL,
  `highestAge` int DEFAULT NULL,
  `mateTitle` varchar(200) DEFAULT NULL,
  `mateContent` varchar(500) DEFAULT NULL,
  `friendlimit` int DEFAULT NULL,
  `memberlimit` int DEFAULT NULL,
  PRIMARY KEY (`mateNo`),
  KEY `contentId` (`contentId`),
  KEY `userNo` (`userNo`),
  CONSTRAINT `mate_ibfk_1` FOREIGN KEY (`contentId`) REFERENCES `campSite` (`contentId`) ON DELETE CASCADE,
  CONSTRAINT `mate_ibfk_2` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `sns` (
  `snsNo` int NOT NULL AUTO_INCREMENT,
  `snsContent` text,
  `snsUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `snsCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `userNo` int NOT NULL,
  `snsCheck` int DEFAULT NULL,
  PRIMARY KEY (`snsNo`),
  KEY `userNo` (`userNo`),
  CONSTRAINT `sns_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `campEquip` (
  `userNo` int NOT NULL,
  `campEquipTent` int DEFAULT NULL,
  `campEquipSleepingbag` int DEFAULT NULL,
  `campEquipBurner` int DEFAULT NULL,
  `campEquipBrazier` int DEFAULT NULL,
  `campEquipTableChair` int DEFAULT NULL,
  `campEquipPot` int DEFAULT NULL,
  `campEquipLantern` int DEFAULT NULL,
  `campEquipReel` int DEFAULT NULL,
  `campEquipIcebox` int DEFAULT NULL,
  `campEquipTarp` int DEFAULT NULL,
  `campEquipEtc1` varchar(128) DEFAULT NULL,
  `campEquipEtc2` varchar(128) DEFAULT NULL,
  `campEquipEtc3` varchar(128) DEFAULT NULL,
  `campEquipEtc4` varchar(128) DEFAULT NULL,
  `campEquipEtc5` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`userNo`),
  CONSTRAINT `campEquip_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `campLike` (
  `userNo` int NOT NULL,
  `contentId` varchar(255) NOT NULL,
  PRIMARY KEY (`userNo`,`contentId`),
  KEY `contentId` (`contentId`),
  CONSTRAINT `campLike_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE,
  CONSTRAINT `campLike_ibfk_2` FOREIGN KEY (`contentId`) REFERENCES `camp_site` (`content_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `campRate` (
  `campRateNo` int NOT NULL AUTO_INCREMENT,
  `contentId` varchar(12) NOT NULL,
  `campRateCleanliness` int DEFAULT NULL,
  `campRatePrice` int DEFAULT NULL,
  `campRateFacility` int DEFAULT NULL,
  `userNo` int NOT NULL,
  `campRateContent` text,
  `campRateCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campRateUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campRateTitle` text,
  PRIMARY KEY (`campRateNo`),
  KEY `userNo` (`userNo`),
  KEY `campRate_ibfk_1_idx` (`contentId`),
  CONSTRAINT `campRate_ibfk_1` FOREIGN KEY (`contentId`) REFERENCES `camp_site` (`content_id`) ON DELETE CASCADE,
  CONSTRAINT `campRate_ibfk_2` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `campRateReply` (
  `campRateReplyNo` int NOT NULL AUTO_INCREMENT,
  `campRateNo` int NOT NULL,
  `campRateReplyCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campRateReplyUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `campRateReplyContent` text,
  `userNo` int NOT NULL,
  PRIMARY KEY (`campRateReplyNo`),
  KEY `campRateNo` (`campRateNo`),
  KEY `userNo` (`userNo`),
  CONSTRAINT `campRateReply_ibfk_1` FOREIGN KEY (`campRateNo`) REFERENCES `campRate` (`campRateNo`) ON DELETE CASCADE,
  CONSTRAINT `campRateReply_ibfk_2` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `campStyle` (
  `userNo` int NOT NULL,
  `campStyle1` varchar(10) DEFAULT NULL,
  `campStyle2` varchar(10) DEFAULT NULL,
  `campStyle3` varchar(10) DEFAULT NULL,
  `campStyle4` varchar(10) DEFAULT NULL,
  `campStyle5` varchar(10) DEFAULT NULL,
  `campStyle6` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userNo`),
  CONSTRAINT `campStyle_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `chatroom` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `master_id` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `roomStyle` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `follow` (
  `userNo` int NOT NULL,
  `followUserNo` int NOT NULL,
  PRIMARY KEY (`userNo`,`followUserNo`),
  KEY `followUserNo` (`followUserNo`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`followUserNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mateCampEquipRequire` (
  `mateNo` int NOT NULL,
  `brazier` int DEFAULT '0',
  `burner` int DEFAULT '0',
  `chair` int DEFAULT '0',
  `icebox` int DEFAULT '0',
  `lantern` int DEFAULT '0',
  `powerstrip` int DEFAULT '0',
  `sleepingbag` int DEFAULT '0',
  `table1` int DEFAULT '0',
  `tarp` int DEFAULT '0',
  `tent` int DEFAULT '0',
  PRIMARY KEY (`mateNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mateCampStyle` (
  `mateNo` int NOT NULL,
  `style1` varchar(45) DEFAULT NULL,
  `style2` varchar(45) DEFAULT NULL,
  `style3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mateNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mateList` (
  `mateListNo` int NOT NULL AUTO_INCREMENT,
  `userNo` int NOT NULL,
  `mateListNum` int DEFAULT NULL,
  `userAge` int DEFAULT NULL,
  `mateNo` int NOT NULL,
  `userGender` varchar(10) DEFAULT NULL,
  `mateApplyCheck` int DEFAULT NULL,
  `mateListcol` varchar(45) DEFAULT '0',
  PRIMARY KEY (`mateListNo`),
  KEY `userNo` (`userNo`),
  KEY `mateNo` (`mateNo`),
  CONSTRAINT `mateList_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE,
  CONSTRAINT `mateList_ibfk_2` FOREIGN KEY (`mateNo`) REFERENCES `mate` (`mateNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mateReply` (
  `mateReplyNo` int NOT NULL AUTO_INCREMENT,
  `mateNo` int NOT NULL,
  `mateReplyCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mateReplyUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `mateReplyContent` text,
  `userNo` int NOT NULL,
  PRIMARY KEY (`mateReplyNo`),
  KEY `userNo` (`userNo`),
  KEY `mateNo` (`mateNo`),
  CONSTRAINT `mateReply_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE,
  CONSTRAINT `mateReply_ibfk_2` FOREIGN KEY (`mateNo`) REFERENCES `mate` (`mateNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mbti` (
  `mbtiNo` int NOT NULL AUTO_INCREMENT,
  `mbti1` varchar(45) DEFAULT NULL,
  `mbti2` varchar(45) DEFAULT NULL,
  `mbtiValue` int DEFAULT NULL,
  PRIMARY KEY (`mbtiNo`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `chatroom_id` bigint DEFAULT NULL,
  `sender_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `snsImage` (
  `snsImageNo` int NOT NULL AUTO_INCREMENT,
  `snsImageUrl` varchar(200) NOT NULL,
  `snsNo` int NOT NULL,
  PRIMARY KEY (`snsImageNo`),
  KEY `snsNo` (`snsNo`),
  CONSTRAINT `snsImage_ibfk_1` FOREIGN KEY (`snsNo`) REFERENCES `sns` (`snsNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `snsLike` (
  `userNo` int NOT NULL,
  `snsNo` int NOT NULL,
  PRIMARY KEY (`userNo`,`snsNo`),
  KEY `snsNo` (`snsNo`),
  CONSTRAINT `snsLike_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE,
  CONSTRAINT `snsLike_ibfk_2` FOREIGN KEY (`snsNo`) REFERENCES `sns` (`snsNo`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `snsReply` (
  `snsReplyNo` int NOT NULL AUTO_INCREMENT,
  `snsReplyCreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `snsReplyUpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `snsReplyContent` text,
  `userNo` int NOT NULL,
  `snsNo` int NOT NULL,
  PRIMARY KEY (`snsReplyNo`),
  KEY `userNo` (`userNo`),
  KEY `snsNo` (`snsNo`),
  CONSTRAINT `snsReply_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE,
  CONSTRAINT `snsReply_ibfk_2` FOREIGN KEY (`snsNo`) REFERENCES `sns` (`snsNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_c` (
  `id` bigint NOT NULL,
  `nickname` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `userRate` (
  `userRateNo` int NOT NULL AUTO_INCREMENT,
  `userNo` int NOT NULL,
  `userRatePoint` float DEFAULT NULL,
  PRIMARY KEY (`userRateNo`),
  KEY `userNo` (`userNo`),
  CONSTRAINT `userRate_ibfk_1` FOREIGN KEY (`userNo`) REFERENCES `user` (`userNo`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
