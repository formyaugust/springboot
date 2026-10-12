-- ============================================================================
--  smart_property_sys  数据库重建脚本
--  来源：完全依据 D:\Workspace\Idea\springboot 的实体类 + MyBatis 映射文件反推
--  生成日期：2026-10-06
--
--  ⚠️ 本脚本开头会 DROP 已有同名表（可重复执行 / 幂等）。
--     执行前请确认 smart_property_sys 里没有需要保留的数据。
--
--  连接信息（来自 application.yml）：
--     jdbc:mysql://localhost:3306/smart_property_sys
--     username: root   password: 000000
-- ============================================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE DATABASE IF NOT EXISTS `smart_property_sys`
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_0900_ai_ci;

USE `smart_property_sys`;

-- ---------------------------------------------------------------------------
-- 1. sys_user  系统用户 / 登录账号
--    来源：SysUserMapper.xml  resultMap BaseResultMap
--    注意：密码为明文比较（checkLogin 直接比对），故不做哈希
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id`   INT          NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username`  VARCHAR(50)  NOT NULL                COMMENT '登录账号',
  `password`  VARCHAR(100) NOT NULL                COMMENT '密码（明文）',
  `real_name` VARCHAR(50)  DEFAULT NULL            COMMENT '真实姓名',
  `phone`     VARCHAR(20)  DEFAULT NULL            COMMENT '联系电话',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_sys_user_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- ---------------------------------------------------------------------------
-- 2. owner  业主
--    注意：gender 在实体里是 char，前端取值固定为 男 / 女
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner` (
  `owner_id`   INT         NOT NULL AUTO_INCREMENT COMMENT '业主ID',
  `owner_name` VARCHAR(50) NOT NULL                COMMENT '业主姓名',
  `gender`     CHAR(1)     DEFAULT NULL            COMMENT '性别：男/女',
  `phone`      VARCHAR(20) DEFAULT NULL            COMMENT '联系电话',
  `id_card`    VARCHAR(18) DEFAULT NULL            COMMENT '身份证号',
  PRIMARY KEY (`owner_id`),
  KEY `idx_owner_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='业主表';

-- ---------------------------------------------------------------------------
-- 3. house  房屋
--    room_status 前端枚举：已售出 / 待售出
--    owner_id 可为 NULL —— 实体注释「可能为 null，代表空置」
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `house_id`    INT         NOT NULL AUTO_INCREMENT COMMENT '房屋ID',
  `building_no` VARCHAR(20) DEFAULT NULL            COMMENT '楼栋',
  `unit_no`     VARCHAR(20) DEFAULT NULL            COMMENT '单元',
  `room_no`     VARCHAR(20) DEFAULT NULL            COMMENT '房号',
  `room_status` VARCHAR(10) DEFAULT NULL            COMMENT '售出状态：已售出/待售出',
  `owner_id`    INT         DEFAULT NULL            COMMENT '业主ID（NULL=空置）',
  PRIMARY KEY (`house_id`),
  KEY `idx_house_owner` (`owner_id`),
  KEY `idx_house_room` (`building_no`, `unit_no`, `room_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='房屋表';

-- ---------------------------------------------------------------------------
-- 4. fee  缴费
--    fee_type   前端枚举：物业费 / 水费 / 电费 / 停车费
--    pay_status 前端枚举：已缴 / 未缴
--    bill_month 前端 el-date-picker value-format="YYYY-MM"  → VARCHAR(7)
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `fee`;
CREATE TABLE `fee` (
  `fee_id`     INT            NOT NULL AUTO_INCREMENT COMMENT '缴费ID',
  `house_id`   INT            DEFAULT NULL            COMMENT '房屋ID',
  `owner_id`   INT            DEFAULT NULL            COMMENT '业主ID',
  `fee_type`   VARCHAR(20)    DEFAULT NULL            COMMENT '费用类型：物业费/水费/电费/停车费',
  `amount`     DECIMAL(10, 2) DEFAULT NULL            COMMENT '金额',
  `bill_month` VARCHAR(7)     DEFAULT NULL            COMMENT '账单月份 YYYY-MM',
  `pay_status` VARCHAR(10)    DEFAULT NULL            COMMENT '缴费状态：已缴/未缴',
  PRIMARY KEY (`fee_id`),
  KEY `idx_fee_house` (`house_id`),
  KEY `idx_fee_owner` (`owner_id`),
  KEY `idx_fee_month` (`bill_month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='缴费表';

-- ---------------------------------------------------------------------------
-- 5. parking  车位
--    status 前端枚举：空闲 / 已占用
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `parking`;
CREATE TABLE `parking` (
  `parking_id` INT         NOT NULL AUTO_INCREMENT COMMENT '车位ID',
  `parking_no` VARCHAR(20) DEFAULT NULL            COMMENT '车位编号',
  `status`     VARCHAR(10) DEFAULT NULL            COMMENT '状态：空闲/已占用',
  `owner_id`   INT         DEFAULT NULL            COMMENT '业主ID',
  `car_plate`  VARCHAR(20) DEFAULT NULL            COMMENT '车牌号',
  PRIMARY KEY (`parking_id`),
  KEY `idx_parking_owner` (`owner_id`),
  KEY `idx_parking_no` (`parking_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='车位表';

-- ---------------------------------------------------------------------------
-- 6. repair  报修
--    status 前端枚举：待处理 / 处理中 / 已完成
--    （RepairMapper.xml 里 order by field(status,'待处理','处理中','已完成') 可佐证）
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `repair_id` INT          NOT NULL AUTO_INCREMENT COMMENT '报修ID',
  `house_id`  INT          DEFAULT NULL            COMMENT '房屋ID',
  `owner_id`  INT          DEFAULT NULL            COMMENT '业主ID',
  `content`   VARCHAR(500) DEFAULT NULL            COMMENT '报修内容',
  `status`    VARCHAR(10)  DEFAULT NULL            COMMENT '状态：待处理/处理中/已完成',
  PRIMARY KEY (`repair_id`),
  KEY `idx_repair_house` (`house_id`),
  KEY `idx_repair_owner` (`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报修表';

-- ---------------------------------------------------------------------------
-- 7. announcement  公告
--    实体字段 createTime 声明为 String，前端 value-format="YYYY-MM-DD"
--    → 用 VARCHAR 保持原样往返，避免类型转换
-- ---------------------------------------------------------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement` (
  `announcement_id` INT          NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `title`           VARCHAR(100) DEFAULT NULL            COMMENT '标题',
  `content`         TEXT                                 COMMENT '内容',
  `publisher_id`    INT          DEFAULT NULL            COMMENT '发布人ID（sys_user.user_id）',
  `create_time`     VARCHAR(20)  DEFAULT NULL            COMMENT '发布日期 YYYY-MM-DD',
  PRIMARY KEY (`announcement_id`),
  KEY `idx_ann_publisher` (`publisher_id`),
  KEY `idx_ann_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公告表';


-- ============================================================================
--  种子数据
-- ============================================================================

-- --- sys_user：登录账号，密码统一 123456（明文） ---------------------------
INSERT INTO `sys_user` (`user_id`, `username`, `password`, `real_name`, `phone`) VALUES
  (1, 'admin',    '123456', '系统管理员', '13800000001'),
  (2, 'zhangwei', '123456', '张伟',       '13800000002'),
  (3, 'liuyang',  '123456', '刘洋',       '13800000003');

-- --- owner：业主（身份证号为演示用虚构号码） -------------------------------
INSERT INTO `owner` (`owner_id`, `owner_name`, `gender`, `phone`, `id_card`) VALUES
  (1, '张伟', '男', '13805180001', '320102199003074512'),
  (2, '李娜', '女', '13805180002', '320102199205163028'),
  (3, '王强', '男', '13805180003', '320102198811240917'),
  (4, '刘敏', '女', '13805180004', '320102199408119245'),
  (5, '陈杰', '男', '13805180005', '320102199112303651'),
  (6, '赵丽', '女', '13805180006', '320102199607228134'),
  (7, '孙浩', '男', '13805180007', '320102198902145327'),
  (8, '周静', '女', '13805180008', '320102199504067802');

-- --- house：房屋（待售出的 owner_id 为 NULL） -------------------------------
INSERT INTO `house` (`house_id`, `building_no`, `unit_no`, `room_no`, `room_status`, `owner_id`) VALUES
  ( 1, '1栋', '1单元', '101', '已售出', 1),
  ( 2, '1栋', '1单元', '102', '已售出', 2),
  ( 3, '1栋', '1单元', '201', '待售出', NULL),
  ( 4, '1栋', '2单元', '101', '已售出', 3),
  ( 5, '1栋', '2单元', '102', '待售出', NULL),
  ( 6, '2栋', '1单元', '101', '已售出', 4),
  ( 7, '2栋', '1单元', '102', '已售出', 5),
  ( 8, '2栋', '1单元', '201', '待售出', NULL),
  ( 9, '2栋', '2单元', '101', '已售出', 6),
  (10, '3栋', '1单元', '101', '已售出', 7),
  (11, '3栋', '1单元', '102', '已售出', 8),
  (12, '3栋', '1单元', '201', '待售出', NULL);

-- --- fee：缴费记录（2026-09 / 2026-10 两个账期） ---------------------------
INSERT INTO `fee` (`fee_id`, `house_id`, `owner_id`, `fee_type`, `amount`, `bill_month`, `pay_status`) VALUES
  ( 1,  1, 1, '物业费', 320.00, '2026-09', '已缴'),
  ( 2,  1, 1, '水费',    42.50, '2026-09', '已缴'),
  ( 3,  1, 1, '电费',   186.30, '2026-09', '已缴'),
  ( 4,  1, 1, '物业费', 320.00, '2026-10', '未缴'),
  ( 5,  2, 2, '物业费', 298.00, '2026-09', '已缴'),
  ( 6,  2, 2, '电费',   142.80, '2026-09', '未缴'),
  ( 7,  2, 2, '物业费', 298.00, '2026-10', '未缴'),
  ( 8,  4, 3, '物业费', 315.00, '2026-09', '已缴'),
  ( 9,  4, 3, '停车费', 150.00, '2026-09', '已缴'),
  (10,  6, 4, '物业费', 276.00, '2026-09', '已缴'),
  (11,  6, 4, '水费',    35.20, '2026-09', '未缴'),
  (12,  7, 5, '物业费', 268.00, '2026-09', '已缴'),
  (13,  7, 5, '电费',   203.60, '2026-09', '已缴'),
  (14,  7, 5, '物业费', 268.00, '2026-10', '未缴'),
  (15,  9, 6, '物业费', 288.00, '2026-09', '已缴'),
  (16,  9, 6, '水费',    51.40, '2026-09', '未缴'),
  (17, 10, 7, '物业费', 305.00, '2026-09', '已缴'),
  (18, 10, 7, '停车费', 150.00, '2026-09', '未缴'),
  (19, 11, 8, '物业费', 295.00, '2026-09', '已缴'),
  (20, 11, 8, '电费',   167.90, '2026-09', '已缴');

-- --- parking：车位 --------------------------------------------------------
INSERT INTO `parking` (`parking_id`, `parking_no`, `status`, `owner_id`, `car_plate`) VALUES
  (1, 'A-001', '已占用', 1,    '苏A88K21'),
  (2, 'A-002', '已占用', 2,    '苏A5T6M8'),
  (3, 'A-003', '空闲',   NULL, NULL),
  (4, 'A-004', '已占用', 3,    '苏A9Q3W7'),
  (5, 'B-001', '已占用', 4,    '苏A2E4R6'),
  (6, 'B-002', '空闲',   NULL, NULL),
  (7, 'B-003', '已占用', 5,    '苏A7Y1U9'),
  (8, 'B-004', '空闲',   NULL, NULL);

-- --- repair：报修工单 -----------------------------------------------------
INSERT INTO `repair` (`repair_id`, `house_id`, `owner_id`, `content`, `status`) VALUES
  (1,  1, 1, '厨房水管接口渗水，橱柜下面已经积水，麻烦尽快来看一下。', '已完成'),
  (2,  2, 2, '主卧空调制冷效果很差，开一小时还是不凉，怀疑缺氟。',   '处理中'),
  (3,  4, 3, '入户门门锁卡顿，钥匙转动费力，有时要拧好几次。',       '待处理'),
  (4,  6, 4, '阳台地漏返味，阴雨天特别明显。',                       '已完成'),
  (5,  7, 5, '客厅吊灯有一半灯珠不亮，开关正常。',                   '处理中'),
  (6,  9, 6, '卫生间花洒出水忽冷忽热，水压也不稳定。',               '待处理');

-- --- announcement：公告 ---------------------------------------------------
INSERT INTO `announcement` (`announcement_id`, `title`, `content`, `publisher_id`, `create_time`) VALUES
  (1, '关于小区停水的通知',
      '因市政管网检修，定于 10 月 12 日 08:00—18:00 对全小区停止供水，请各位业主提前做好储水准备。给您带来不便，敬请谅解。',
      1, '2026-10-05'),
  (2, '电梯年度检修安排',
      '2 栋 1 单元电梯将于 10 月 8 日进行年度安全检修，当天暂停使用，请合理安排出行时间。',
      1, '2026-10-03'),
  (3, '2026 年 10 月物业费缴纳提醒',
      '本月物业费已开始收取，请各位业主于 10 月 31 日前通过物业服务中心或线上渠道完成缴纳。',
      1, '2026-10-01'),
  (4, '国庆假期值班安排',
      '假期期间物业服务中心安排专人值班，紧急报修请拨打值班电话 13800000001。',
      1, '2026-09-28');

SET FOREIGN_KEY_CHECKS = 1;

-- ============================================================================
--  完成。校验：
--    SELECT 'sys_user' t, COUNT(*) n FROM sys_user
--    UNION ALL SELECT 'owner', COUNT(*) FROM owner
--    UNION ALL SELECT 'house', COUNT(*) FROM house
--    UNION ALL SELECT 'fee', COUNT(*) FROM fee
--    UNION ALL SELECT 'parking', COUNT(*) FROM parking
--    UNION ALL SELECT 'repair', COUNT(*) FROM repair
--    UNION ALL SELECT 'announcement', COUNT(*) FROM announcement;
-- ============================================================================
