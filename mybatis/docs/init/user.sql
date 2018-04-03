--数据库名称： user

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `loginName` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户账号',
  `loginPass` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码'
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户表';

INSERT INTO T_USER(loginName, loginPass) VALUES("zzw","123");
INSERT INTO T_USER(loginName, loginPass) VALUES("ztr","321");
INSERT INTO T_USER(loginName, loginPass) VALUES("gupao","666");