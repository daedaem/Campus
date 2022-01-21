# show databases; 로 DB가 있는지 확인
# CREATE DATABASE
#CREATE DATABASE ssafy;
USE ssafy;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userNo` INT NOT NULL AUTO_INCREMENT,
  `userEmail` VARCHAR(128) NOT NULL,
  `userPassword` VARCHAR(20) NOT NULL,
  `userName` VARCHAR(20),
  `userProfileImage` VARCHAR(128) DEFAULT NULL,
  `userLocation` VARCHAR(20),
  `userAge` INT,
  `userGender` ENUM('남', '여'),
  `userNickname` VARCHAR(20),
  `userMBTI` VARCHAR(4) DEFAULT NULL,
  PRIMARY KEY (`userNo`),
  UNIQUE KEY `user_idx_unique_email` (`userEmail`),
  UNIQUE KEY `user_idx_unique_nickname` (`userNickname`)
);

# SELECT * FROM user;

CREATE TABLE `campStyle` (
	`userNo` INT NOT NULL,
	`campStyle1` ENUM('Y', 'N') DEFAULT 'N',
	`campStyle2` ENUM('Y', 'N') DEFAULT 'N',
	`campStyle3` ENUM('Y', 'N') DEFAULT 'N',
	`campStyle4` ENUM('Y', 'N') DEFAULT 'N',
	`campStyle5` ENUM('Y', 'N') DEFAULT 'N',
	`campStyle6` ENUM('Y', 'N') DEFAULT 'N',
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	PRIMARY KEY (`userNo`)
	# ON DELETE CASCADE : user가 탈퇴하면 해당하는 정보 같이 삭제
);

CREATE TABLE `campEquip` (
	`userNo` INT NOT NULL,
	`campEquipTent` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipSleepingbag` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipBurner` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipTableChair` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipPot` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipLantern` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipReel` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipIcebox` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipTarp` ENUM('Y', 'N') DEFAULT 'N',
	`campEquipEtc1` VARCHAR(128) DEFAULT NULL,
	`campEquipEtc2` VARCHAR(128) DEFAULT NULL,
	`campEquipEtc3` VARCHAR(128) DEFAULT NULL,
	`campEquipEtc4` VARCHAR(128) DEFAULT NULL,
	`campEquipEtc5` VARCHAR(128) DEFAULT NULL,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	PRIMARY KEY (`userNo`)
);

CREATE TABLE `follow` (
	`userNo` INT NOT NULL,
	`followUserNo` INT NOT NULL,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	FOREIGN KEY (`followUserNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	PRIMARY KEY (`userNo`, `followUserNo`)
);

CREATE TABLE `campSite` (
	`contentId` VARCHAR(12),
	`addr1` VARCHAR(128),
	`facltNm` VARCHAR(128),
	`sigunguNm` VARCHAR(128),
	`doNm` VARCHAR(128),
	`lineIntro` VARCHAR(128),
	`intro` TEXT,
	`allar` INT,
	`lctCl` VARCHAR(128),
	`mapY` DOUBLE,
	`mapX` DOUBLE,
	`tel` VARCHAR(128),
	`resveUrl` VARCHAR(128),
	`resveCl` VARCHAR(128),
	`gnrlSiteCo` INT,
	`autoSiteCo` INT,
	`glampSiteCo` INT,
	`caravSiteCo` INT,
	`indvdlCaravSiteCo` INT,
	`siteBottomCl1` INT,
	`siteBottomCl2` INT,
	`siteBottomCl3` INT,
	`siteBottomCl4` INT,
	`siteBottomCl5` INT,
	`tooltip` TEXT,
	`glampInnerFclty` VARCHAR(200),
	`caravInnerFclty` VARCHAR(200),
	`operPdCl` VARCHAR(50),
	`operDeCl` VARCHAR(30),
	`trlerAcmpnyAt` ENUM('Y', 'N'),
	`caravAcmpnyAt` ENUM('Y', 'N'),
	`toiletCo` INT,
	`swrmCo` INT,
	`wtrplCo` INT,
	`brazierCl` INT,
	`sbrsCl` VARCHAR(100),
	`sbrsEtc` VARCHAR(200),
	`posblFcltyCl` VARCHAR(300),
	`posblFcltyEtc` VARCHAR(300),
	`clturEventAt` ENUM('Y', 'N'),
	`clturEvent` VARCHAR(200),
	`exprnProgrmAt` ENUM('Y', 'N'),
	`exprnProgrm` VARCHAR(300),
	`extshrCo` INT,
	`frprvWrppCo` INT,
	`frprvSandCo` INT,
	`fireSensorCo` INT,
	`themaEnvrmCl` VARCHAR(295),
	`eqpmnLendCl` VARCHAR(100),
	`animalCmgCl` VARCHAR(100),
	`tourEraCl` VARCHAR(200),
	`firstImageUrl` VARCHAR(300),
	`createdtime` TIMESTAMP,
	`modifiedtime` TIMESTAMP,
	`sitedStnc` INT,
	`siteMg1Width` INT,
	`siteMg2Width` INT,
	`siteMg3Width` INT,
	`siteMg1Vrticl` INT,
	`siteMg2Vrticl` INT,
	`siteMg3Vrticl` INT,
	`siteMg1Co` INT,
	`siteMg2Co` INT,
	`siteMg3Co` INT,
	PRIMARY KEY (`contentId`)
);

CREATE TABLE `campRate` (
	`campRateNo` INT NOT NULL AUTO_INCREMENT,
	`contentId` VARCHAR(12) NOT NULL,
	`campRateCleanliness` INT,
	`campRatePrice` INT,
	`campRateFacility` INT,
	`userNo` INT NOT NULL,
	`campRateContent` TEXT,
	`campRateCreateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`campRateUpdateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`campRateTitle` TEXT,
	PRIMARY KEY (`campRateNo`),
	FOREIGN KEY (`contentId`) REFERENCES campSite(`contentId`) ON DELETE CASCADE,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE
);

CREATE TABLE `campRateReply` (
	`campRateReplyNo` INT NOT NULL AUTO_INCREMENT,
	`campRateNo` INT NOT NULL,
	`campRateReplyCreateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`campRateReplyUpdateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`campRateReplyContent` TEXT,
	`userNo` INT NOT NULL,
	FOREIGN KEY (`campRateNo`) REFERENCES campRate(`campRateNo`) ON DELETE CASCADE,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	PRIMARY KEY (`campRateReplyNo`)
);

CREATE TABLE `mate` (
	`mateNo` INT NOT NULL AUTO_INCREMENT,
	`mateCreateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`mateUpdateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`mateImageUrl` VARCHAR(200),
	`mateCampsite` VARCHAR(30),
	`mateAge` INT,
	`mateCampstyle` VARCHAR(20),
	`mateCamptype` VARCHAR(20),
	`mateCampstart` DATE,
	`mateCampend` DATE,
	`contentId` VARCHAR(12) NOT NULL,
	`mateStatus` VARCHAR(1),
	`userNo` INT NOT NULL,
	PRIMARY KEY (`mateNo`),
	FOREIGN KEY (`contentId`) REFERENCES campSite(`contentId`) ON DELETE CASCADE,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE
);

CREATE TABLE `mateReply` (
	`mateReplyNo` INT NOT NULL AUTO_INCREMENT,
	`mateNo` INT NOT NULL,
	`mateReplyCreateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`mateReplyUpdateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`mateReplyContent` TEXT,
	`userNo` INT NOT NULL,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	FOREIGN KEY (`mateNo`) REFERENCES mate(`mateNo`) ON DELETE CASCADE,
	PRIMARY KEY (`mateReplyNo`)
);

CREATE TABLE `mateList` (
	`mateListNo` INT NOT NULL AUTO_INCREMENT,
	`userNo` INT NOT NULL,
	`mateListNum` INT,
	`mateListAge` INT,
	`mateNo` INT NOT NULL,
	`mateGender` ENUM('남', '여'),
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	FOREIGN KEY (`mateNo`) REFERENCES mate(`mateNo`) ON DELETE CASCADE,
	PRIMARY KEY (`mateListNo`)
);

CREATE TABLE `sns` (
	`snsNo` INT NOT NULL AUTO_INCREMENT,
	`snsContent` TEXT,
	`snsUpdateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`snsCreateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`userNo` INT NOT NULL,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	PRIMARY KEY (`snsNo`)
);

CREATE TABLE `snsReply` (
	`snsReplyNo` INT NOT NULL AUTO_INCREMENT,
	`snsReplyCreateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`snsReplyUpdateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	`snsReplyContent` TEXT,
	`userNo` INT NOT NULL,
	`snsNo` INT NOT NULL,
	PRIMARY KEY (`snsReplyNo`),
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	FOREIGN KEY (`snsNo`) REFERENCES sns(`snsNo`) ON DELETE CASCADE
);

CREATE TABLE `snsImage` (
	`snsImageNo` INT NOT NULL AUTO_INCREMENT,
	`snsImageUrl` VARCHAR(128) NOT NULL,
	`snsNo` INT NOT NULL,
	`snsImageName` VARCHAR(128) NOT NULL,
	PRIMARY KEY (`snsImageNo`),
	FOREIGN KEY (`snsNo`) REFERENCES sns(`snsNo`) ON DELETE CASCADE
);

CREATE TABLE `snsLike` (
	`userNo` INT NOT NULL,
	`snsNo` INT NOT NULL,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	FOREIGN KEY (`snsNo`) REFERENCES sns(`snsNo`) ON DELETE CASCADE,
	PRIMARY KEY (`userNo`, `snsNo`)
);

CREATE TABLE `userRate` (
	`userRateNo` INT NOT NULL AUTO_INCREMENT,
	`userNo` INT NOT NULL,
	`userRatePoint` INT,
	FOREIGN KEY (`userNo`) REFERENCES user(`userNo`) ON DELETE CASCADE,
	PRIMARY KEY (`userRateNo`)
);
