/*
 Navicat Premium Data Transfer

 Source Server         : 本机-测试服务
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 11/06/2021 09:47:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '参数id',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数键名',
  `config_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '系统内置',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES ('1377930337229471746', '测试配置', 'test_config_key', 'userinfo', '0', '1170896100656156674', '2021-04-02 18:26:07.764', '1170896100656156674', '2021-04-03 08:39:08.729', '0', NULL);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门id',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `dept_sort` decimal(20, 0) NULL DEFAULT 0 COMMENT '显示顺序',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `dept_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0、正常；1、停用）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '0', '总公司', 0, NULL, NULL, '0', NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('1371702174283571201', '3', '0,1,3', '财务部门', 5, NULL, NULL, '0', '1170896100656156674', '2021-03-16 13:57:38', '1170896100656156674', '2021-04-02 18:49:25', '0', NULL);
INSERT INTO `sys_dept` VALUES ('1377935436483919873', '2', '0,1,2', '研发部门', 1, NULL, NULL, '0', '1170896100656156674', '2021-04-02 18:46:24', NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('1377935480696078337', '2', '0,1,2', '测试部门', 3, NULL, NULL, '0', '1170896100656156674', '2021-04-02 18:46:34', NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('1377935517522067457', '2', '0,1,2', '产品部门', 5, NULL, NULL, '0', '1170896100656156674', '2021-04-02 18:46:43', NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('1377935562556309505', '2', '0,1,2', '运维部门', 7, NULL, NULL, '0', '1170896100656156674', '2021-04-02 18:46:54', NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('1377935601739497474', '2', '0,1,2', '市场部门', 8, NULL, NULL, '0', '1170896100656156674', '2021-04-02 18:47:03', NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('1377936163021258753', '3', '0,1,3', '市场部门', 3, NULL, NULL, '0', '1170896100656156674', '2021-04-02 18:49:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('2', '1', '0,1', '深圳总公司', 1, NULL, NULL, '0', NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_dept` VALUES ('3', '1', '0,1', '长沙分公司', 2, '22323', '11111', '0', NULL, NULL, '1170896100656156674', '2021-03-16 13:57:27', '0', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典id',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级id',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `dict_sort` int(11) NULL DEFAULT 0 COMMENT '字典排序',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `dict_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES ('1372709863595810818', NULL, '男', '1', 'sex', 1, NULL, 'primary', '0', '1170896100656156674', '2021-03-19 08:41:50', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372709863595810819', NULL, '女', '2', 'sex', 2, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:41:50', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372709863595810820', NULL, '未知', '3', 'sex', 3, NULL, 'info', '0', '1170896100656156674', '2021-03-19 08:41:50', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710732080979960', NULL, '正常', '0', 'dict_status', 1, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:45:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710732080979962', NULL, '正常', '0', 'role_status', 1, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:45:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710732080979966', NULL, '正常', '0', 'dept_status', 1, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:45:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710732080979967', NULL, '正常', '0', 'post_status', 1, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:45:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710732080979969', NULL, '正常', '0', 'user_status', 1, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:45:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710732080979980', NULL, '正常', '0', 'res_status', 1, NULL, 'success', '0', '1170896100656156674', '2021-03-19 08:45:17', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710783326986241', NULL, '禁用', '1', 'user_status', 2, NULL, 'danger', '0', '1170896100656156674', '2021-03-19 08:45:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710783326986242', NULL, '禁用', '1', 'dict_status', 2, NULL, 'danger', '0', '1170896100656156674', '2021-03-19 08:45:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710783326986243', NULL, '禁用', '1', 'role_status', 2, NULL, 'danger', '0', '1170896100656156674', '2021-03-19 08:45:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710783326986245', NULL, '禁用', '1', 'dept_status', 2, NULL, 'danger', '0', '1170896100656156674', '2021-03-19 08:45:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710783326986248', NULL, '禁用', '1', 'post_status', 2, NULL, 'danger', '0', '1170896100656156674', '2021-03-19 08:45:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372710783326986281', NULL, '禁用', '1', 'res_status', 2, NULL, 'danger', '0', '1170896100656156674', '2021-03-19 08:45:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711039930310657', NULL, '管理员', '0', 'user_type', 1, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:30', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711039930310670', NULL, '模块权限', '0', 'menu_type', 1, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:30', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711039930310673', NULL, '模块', '0', 'module_type', 1, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:30', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711039930310678', NULL, '模块', '0', 'power_type', 1, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:30', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711076852768769', NULL, '普通用户', '1', 'user_type', 2, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:39', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711076852768771', NULL, '菜单权限', '1', 'menu_type', 2, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:39', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711076852768774', NULL, '操作', '1', 'module_type', 2, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:39', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711076852768776', NULL, 'GET', 'GET', 'http_method', 2, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:39', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711076852768777', NULL, 'POST', 'POST', 'http_method', 3, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:39', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1372711076852768779', NULL, '菜单', '1', 'power_type', 2, NULL, NULL, '0', '1170896100656156674', '2021-03-19 08:46:39', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1376409914658590721', NULL, '全部数据权限', '1', 'data_scope', 1, NULL, 'primary', '0', '1170896100656156674', '2021-03-29 13:44:31', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1376409951539105794', NULL, '自定数据权限', '2', 'data_scope', 2, NULL, 'success', '0', '1170896100656156674', '2021-03-29 13:44:40', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1376409996724342786', NULL, '本部门数据权限', '3', 'data_scope', 3, NULL, 'danger', '0', '1170896100656156674', '2021-03-29 13:44:50', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1376410032313012226', NULL, '本部门及以下数据权限', '4', 'data_scope', 4, NULL, 'error', '0', '1170896100656156674', '2021-03-29 13:44:59', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1378139151967047682', NULL, '是', '0', 'config_type', 0, NULL, 'success', '0', '1170896100656156674', '2021-04-03 08:15:53', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1378139197374582785', NULL, '否', '1', 'config_type', 1, NULL, 'danger', '0', '1170896100656156674', '2021-04-03 08:16:04', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234283315372034', NULL, '立即执行', '1', 'misfire_policy_type', 1, NULL, 'primary', '0', '1170896100656156674', '2021-04-06 08:47:33', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234361887268865', NULL, '执行一次', '2', 'misfire_policy_type', 2, NULL, 'success', '0', '1170896100656156674', '2021-04-06 08:47:51', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234431768567809', NULL, '放弃执行', '3', 'misfire_policy_type', 3, NULL, 'danger', '0', '1170896100656156674', '2021-04-06 08:48:08', '1170896100656156674', '2021-04-06 08:48:15', '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234652439289857', NULL, '允许', '0', 'concurrent_type', 0, NULL, 'primary', '0', '1170896100656156674', '2021-04-06 08:49:01', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234729853558786', NULL, '禁止', '1', 'concurrent_type', 1, NULL, 'error', '0', '1170896100656156674', '2021-04-06 08:49:19', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234884933754882', NULL, '正常', '0', 'job_status', 0, NULL, 'primary', '0', '1170896100656156674', '2021-04-06 08:49:56', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379234956018819074', NULL, '暂停', '1', 'job_status', 1, NULL, 'danger', '0', '1170896100656156674', '2021-04-06 08:50:13', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379240904900845569', NULL, '默认', 'DEFAULT', 'job_group', 1, NULL, 'primary', '0', '1170896100656156674', '2021-04-06 09:13:51', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_data` VALUES ('1379240969895780354', NULL, '系统', 'SYSTEM', 'job_group', 2, NULL, 'info', '0', '1170896100656156674', '2021-04-06 09:14:07', NULL, NULL, '0', NULL);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '字典类型',
  `dict_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('1372709749485576194', '性别', 'sex', '0', '1170896100656156674', '2021-03-19 08:41:23', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372710292954128385', '用户类型', 'user_type', '0', '1170896100656156674', '2021-03-19 08:43:32', '1170896100656156674', '2021-03-19 08:45:56', '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372710383374934017', '用户状态', 'user_status', '0', '1170896100656156674', '2021-03-19 08:43:54', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372710383374934018', '字典状态', 'dict_status', '0', '1170896100656156674', '2021-03-19 08:43:54', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372714386955558914', '角色状态', 'role_status', '0', '1170896100656156674', '2021-03-19 08:59:48', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372714386955558915', '部门状态', 'dept_status', '0', '1170896100656156674', '2021-03-19 08:59:48', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372714386955558916', '岗位状态', 'post_status', '0', '1170896100656156674', '2021-03-19 08:59:48', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372720345916502017', '权限类型', 'menu_type', '0', '1170896100656156674', '2021-03-19 09:23:29', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372720409946746881', '模块类型', 'module_type', '0', '1170896100656156674', '2021-03-19 09:23:44', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372720457925390338', '请求方式', 'http_method', '0', '1170896100656156674', '2021-03-19 09:23:56', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372720504272449538', '菜单类型', 'power_type', '0', '1170896100656156674', '2021-03-19 09:24:07', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1372742181504978945', '资源状态', 'res_status', '0', '1170896100656156674', '2021-03-19 10:50:15', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1376409832819331073', '数据范围', 'data_scope', '0', '1170896100656156674', '2021-03-29 13:44:11', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1378139043670118402', '参数配置系统内置选项', 'config_type', '0', '1170896100656156674', '2021-04-03 08:15:27', '1170896100656156674', '2021-04-03 08:16:51', '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1379234181460893697', '任务计划执行错误策略', 'misfire_policy_type', '0', '1170896100656156674', '2021-04-06 08:47:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1379234566711910401', '任务是否并发执行', 'concurrent_type', '0', '1170896100656156674', '2021-04-06 08:48:40', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1379234800548552706', '任务状态', 'job_status', '0', '1170896100656156674', '2021-04-06 08:49:36', NULL, NULL, '0', NULL);
INSERT INTO `sys_dict_type` VALUES ('1379240777616302082', '任务分组', 'job_group', '0', '1170896100656156674', '2021-04-06 09:13:21', NULL, NULL, '0', NULL);

-- ----------------------------
-- Table structure for sys_file_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_file_info`;
CREATE TABLE `sys_file_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件md5',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件名称',
  `content_type` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '文件类型',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '物理路径',
  `url` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'url地址',
  `source` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '来源',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_file_info
-- ----------------------------
INSERT INTO `sys_file_info` VALUES ('d9c81d9c4a45fc58520f14602b5c1687', '旭旭宝宝头像.jpg', 'image/jpeg', 33072, 'group1/M00/00/00/wKgDLF-skuuAEEWsAACBMET2Odo216.jpg', 'http://192.168.3.44:8888/group1/M00/00/00/wKgDLF-skuuAEEWsAACBMET2Odo216.jpg', 'fastdfs', NULL);

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `job_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', NULL, NULL, '1170896100656156674', '2021-04-06 13:13:48', '0', NULL);
INSERT INTO `sys_job` VALUES ('100', 'test', 'DEFAULT', 'parsingXMLTask.parsingXml', '0/10 * * * * ?', '1', '1', '1', NULL, NULL, '1170896100656156674', '2021-04-06 09:26:00', '1', NULL);
INSERT INTO `sys_job` VALUES ('2', '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', NULL, NULL, '1170896100656156674', '2021-04-06 13:13:06', '0', NULL);
INSERT INTO `sys_job` VALUES ('3', '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', NULL, NULL, NULL, NULL, '0', NULL);

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志信息',
  `job_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
INSERT INTO `sys_job_log` VALUES ('1379316292951748609', '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '系统默认（无参） 总共耗时：-16毫秒', '0', '', '2021-04-06 14:13:25');

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `oper_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '操作人员',
  `oper_param` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求参数',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `business_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业务模块名称',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '返回结果',
  `log_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '错误信息',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('1379233804678176770', 'admin', '{}', '/monitor/job/page', '127.0.0.1', '调度任务信息操作接口:调度任务分页查询', 'com.dcy.modules.quartz.controller.JobController.pageList', '{\"code\":1,\"data\":{\"current\":1,\"pages\":1,\"records\":[{\"concurrent\":\"1\",\"cronExpression\":\"0/10 * * * * ?\",\"id\":\"1\",\"invokeTarget\":\"ryTask.ryNoParams\",\"jobGroup\":\"DEFAULT\",\"jobName\":\"系统默认（无参）\",\"jobStatus\":\"1\",\"misfirePolicy\":\"3\"},{\"concurrent\":\"1\",\"cronExpression\":\"0/10 * * * * ?\",\"id\":\"100\",\"invokeTarget\":\"parsingXMLTask.parsingXml\",\"jobGroup\":\"DEFAULT\",\"jobName\":\"test\",\"jobStatus\":\"1\",\"misfirePolicy\":\"1\"},{\"concurrent\":\"1\",\"cronExpression\":\"0/15 * * * * ?\",\"id\":\"2\",\"invokeTarget\":\"ryTask.ryParams(\'ry\')\",\"jobGroup\":\"DEFAULT\",\"jobName\":\"系统默认（有参）\",\"jobStatus\":\"1\",\"misfirePolicy\":\"3\"},{\"concurrent\":\"1\",\"cronExpression\":\"0/20 * * * * ?\",\"id\":\"3\",\"invokeTarget\":\"ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)\",\"jobGroup\":\"DEFAULT\",\"jobName\":\"系统默认（多参）\",\"jobStatus\":\"1\",\"misfirePolicy\":\"3\"}],\"size\":30,\"total\":4},\"msg\":\"操作成功\"}', '0', NULL, '2021-04-06 08:45:39');
INSERT INTO `sys_log` VALUES ('1379234036056956930', 'admin', '{\"current\":1,\"order\":\"desc\",\"size\":10}', '/system/dict-type/page', '127.0.0.1', '字典类型操作接口:字典类型分页查询', 'com.dcy.modules.system.controller.DictTypeController.pageList', '{\"code\":1,\"data\":{\"current\":1,\"pages\":2,\"records\":[{\"dictName\":\"性别\",\"dictStatus\":\"0\",\"dictType\":\"sex\",\"id\":\"1372709749485576194\"},{\"dictName\":\"用户类型\",\"dictStatus\":\"0\",\"dictType\":\"user_type\",\"id\":\"1372710292954128385\"},{\"dictName\":\"用户状态\",\"dictStatus\":\"0\",\"dictType\":\"user_status\",\"id\":\"1372710383374934017\"},{\"dictName\":\"字典状态\",\"dictStatus\":\"0\",\"dictType\":\"dict_status\",\"id\":\"1372710383374934018\"},{\"dictName\":\"角色状态\",\"dictStatus\":\"0\",\"dictType\":\"role_status\",\"id\":\"1372714386955558914\"},{\"dictName\":\"部门状态\",\"dictStatus\":\"0\",\"dictType\":\"dept_status\",\"id\":\"1372714386955558915\"},{\"dictName\":\"岗位状态\",\"dictStatus\":\"0\",\"dictType\":\"post_status\",\"id\":\"1372714386955558916\"},{\"dictName\":\"权限类型\",\"dictStatus\":\"0\",\"dictType\":\"menu_type\",\"id\":\"1372720345916502017\"},{\"dictName\":\"模块类型\",\"dictStatus\":\"0\",\"dictType\":\"module_type\",\"id\":\"1372720409946746881\"},{\"dictName\":\"请求方式\",\"dictStatus\":\"0\",\"dictType\":\"http_method\",\"id\":\"1372720457925390338\"}],\"size\":10,\"total\":14},\"msg\":\"操作成功\"}', '0', NULL, '2021-04-06 08:46:34');
INSERT INTO `sys_log` VALUES ('1379234181494448129', 'admin', '{\"dictName\":\"任务计划执行错误策略\",\"dictStatus\":\"0\",\"dictType\":\"misfire_policy_type\"}', '/system/dict-type/save', '127.0.0.1', '字典类型操作接口:添加', 'com.dcy.modules.system.controller.DictTypeController.save', '{\"code\":1,\"data\":true,\"msg\":\"操作成功\"}', '0', NULL, '2021-04-06 08:47:08');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '公告ID',
  `notice_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `notice_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位名称',
  `post_sort` decimal(10, 2) NULL DEFAULT NULL COMMENT '显示顺序',
  `post_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '岗位状态（0、正常；1、停用）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES ('1372012058585690114', 'ceo', '董事长', 1.00, '0', '1170896100656156674', '2021-03-17 10:29:00', '1170896100656156674', '2021-03-17 13:12:30', '0', NULL);
INSERT INTO `sys_post` VALUES ('1372053095446319106', 'xxx', '研发经理', 2.00, '0', '1170896100656156674', '2021-03-17 13:12:04', NULL, NULL, '0', NULL);
INSERT INTO `sys_post` VALUES ('1372053161728905217', 'test', '测试经理', 3.00, '0', '1170896100656156674', '2021-03-17 13:12:20', NULL, NULL, '0', NULL);
INSERT INTO `sys_post` VALUES ('1372053279836311554', 'hr', '人力资源', 4.00, '0', '1170896100656156674', '2021-03-17 13:12:48', NULL, NULL, '0', NULL);

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级id',
  `parent_ids` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '父级ids',
  `res_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `res_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源code',
  `res_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源path',
  `http_method` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式',
  `res_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态（0、正常；1、禁用）',
  `res_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型（0、模块；1、链接）',
  `res_sort` decimal(10, 2) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识（0：正常；1：已删除）',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------
INSERT INTO `sys_resources` VALUES ('1173417638056017922', '0', '0', '系统管理', NULL, NULL, NULL, '0', '0', 100.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173417760584220674', '1173417638056017922', '1173416959543459841,1173417638056017922', '用户管理', NULL, NULL, NULL, '0', '0', 10.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173494683788189698', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '用户添加', 'user:save', '/system/user/save', 'POST', '0', '1', 2.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:11:59', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173519815223037953', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '用户修改', 'user:update', '/system/user/update', 'POST', '0', '1', 5.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:12:03', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173519895434907649', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '用户删除', 'user:delete', '/system/user/delete', 'POST', '0', '1', 7.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:12:26', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173519984786165761', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '用户删除（批量）', 'user:batch:delete', '/system/user/deleteBatch', 'POST', '0', '1', 12.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:13:18', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173520061013446658', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '重置密码', 'user:reset:pass', '/system/user/resetPassword', 'POST', '0', '1', 13.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173520251158024193', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '授权角色', 'user:auth:role', '/system/user/saveAuthRole', 'POST', '0', '1', 15.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:14:08', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173521725967654914', '1173417760584220674', '1173416959543459841,1173417638056017922,1173417760584220674', '用户查询', 'user:list', '/system/user/page', 'GET', '0', '1', 1.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:11:51', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173786240433037313', '1173417638056017922', '1173416959543459841,1173417638056017922', '角色管理', NULL, NULL, NULL, '0', '0', 20.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173786896229244930', '1173786240433037313', '1173416959543459841,1173417638056017922,1173786240433037313', '角色查询', 'role:list', '/system/role/page', 'GET', '0', '1', 3.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:15:56', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173787141281456130', '1173786240433037313', '1173416959543459841,1173417638056017922,1173786240433037313', '角色添加', 'role:save', '/system/role/save', 'POST', '0', '1', 7.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:16:33', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173787273578192898', '1173786240433037313', '1173416959543459841,1173417638056017922,1173786240433037313', '角色修改', 'role:update', '/system/role/update', 'POST', '0', '1', 10.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:16:38', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173787371326447617', '1173786240433037313', '1173416959543459841,1173417638056017922,1173786240433037313', '角色删除', 'role:delete', '/system/role/delete', 'POST', '0', '1', 15.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:16:44', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173787467954823170', '1173786240433037313', '1173416959543459841,1173417638056017922,1173786240433037313', '角色删除（批量）', 'role:batch:delete', '/system/role/deleteBatch', 'POST', '0', '1', 17.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:16:58', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173787686142517250', '1173786240433037313', '1173416959543459841,1173417638056017922,1173786240433037313', '保存授权权限', 'role:auth:resource', '/system/role/saveAuthResource', 'POST', '0', '1', 25.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173792738055856130', '1173417638056017922', '1173416959543459841,1173417638056017922', '资源管理', NULL, NULL, NULL, '0', '0', 30.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:02:36', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173793141136859137', '1173792738055856130', '1173416959543459841,1173417638056017922,1173792738055856130', '资源添加', 'module:add', '/system/resources/save', 'POST', '0', '1', 7.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:17:43', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173793218580488194', '1173792738055856130', '1173416959543459841,1173417638056017922,1173792738055856130', '资源修改', 'module:update', '/system/resources/update', 'POST', '0', '1', 9.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:17:48', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173793287136387073', '1173792738055856130', '1173416959543459841,1173417638056017922,1173792738055856130', '资源删除', 'module:delete', '/system/resources/delete', 'POST', '0', '1', 11.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:17:53', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1173793449908936705', '1173792738055856130', '1173416959543459841,1173417638056017922,1173792738055856130', '资源查询', 'module:list', '/system/resources/getResourceTreeTableList', 'GET', '0', '1', 2.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:17:35', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1208938290946772993', '1173417638056017922', '1173416959543459841,1173417638056017922', '字典管理', NULL, NULL, NULL, '0', '0', 60.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:04:18', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1208938414578077698', '1208938290946772993', '1173416959543459841,1173417638056017922,1208938290946772993', '字典查询', 'dict:list', '/system/dict/getDictTreeTableList', 'GET', '0', '1', 5.00, NULL, NULL, '1170896100656156674', '2021-04-02 18:24:23', '0', NULL);
INSERT INTO `sys_resources` VALUES ('1208938659106000810', '1208938290946772993', '1173416959543459841,1173417638056017922,1208938290946772993', '字典修改', 'dict:update', '/system/dict/update', 'POST', '0', '1', 15.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1208938659106000811', '1208938290946772993', '1173416959543459841,1173417638056017922,1208938290946772993', '字典删除', 'dict:delete', '/system/dict/delete', 'POST', '0', '1', 20.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1208938659106000898', '1208938290946772993', '1173416959543459841,1173417638056017922,1208938290946772993', '字典添加', 'dict:save', '/system/dict/save', 'POST', '0', '1', 10.00, NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377924533432627201', '1173417638056017922', '1173416959543459841,1173417638056017922', '部门管理', NULL, NULL, NULL, '0', '0', 40.00, '1170896100656156674', '2021-04-02 18:03:04', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377924655306518530', '1173417638056017922', '1173416959543459841,1173417638056017922', '岗位管理', NULL, NULL, NULL, '0', '0', 50.00, '1170896100656156674', '2021-04-02 18:03:33', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377924913415598081', '1173417638056017922', '1173416959543459841,1173417638056017922', '配置管理', NULL, NULL, NULL, '0', '0', 70.00, '1170896100656156674', '2021-04-02 18:04:35', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377924955010510850', '1173417638056017922', '1173416959543459841,1173417638056017922', '日志管理', NULL, NULL, NULL, '0', '0', 80.00, '1170896100656156674', '2021-04-02 18:04:45', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377928656441847810', '1377924533432627201', '1173416959543459841,1173417638056017922,1377924533432627201', '部门查询', 'dept:list', '/system/dept/getDeptTreeTableList', 'GET', '0', '1', 2.00, '1170896100656156674', '2021-04-02 18:19:27', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377928808594419714', '1377924533432627201', '1173416959543459841,1173417638056017922,1377924533432627201', '部门添加', 'dept:save', '/system/dept/save', 'POST', '0', '1', 4.00, '1170896100656156674', '2021-04-02 18:20:03', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377928808594419715', '1377924533432627201', '1173416959543459841,1173417638056017922,1377924533432627201', '部门修改', 'dept:update', '/system/dept/update', 'POST', '0', '1', 5.00, '1170896100656156674', '2021-04-02 18:20:03', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377928808594419716', '1377924533432627201', '1173416959543459841,1173417638056017922,1377924533432627201', '部门删除', 'dept:delete', '/system/dept/delete', 'POST', '0', '1', 6.00, '1170896100656156674', '2021-04-02 18:20:03', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377929323734642690', '1377924655306518530', '1173416959543459841,1173417638056017922,1377924655306518530', '岗位查询', 'post:list', '/system/post/page', 'GET', '0', '1', 2.00, '1170896100656156674', '2021-04-02 18:22:06', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377929323734642691', '1377924655306518530', '1173416959543459841,1173417638056017922,1377924655306518530', '岗位添加', 'post:save', '/system/post/save', 'GET', '0', '1', 4.00, '1170896100656156674', '2021-04-02 18:22:06', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377929323734642692', '1377924655306518530', '1173416959543459841,1173417638056017922,1377924655306518530', '岗位修改', 'post:update', '/system/post/update', 'GET', '0', '1', 6.00, '1170896100656156674', '2021-04-02 18:22:06', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377929323734642693', '1377924655306518530', '1173416959543459841,1173417638056017922,1377924655306518530', '岗位删除', 'post:delete', '/system/post/delete', 'GET', '0', '1', 8.00, '1170896100656156674', '2021-04-02 18:22:06', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377929323734642694', '1377924655306518530', '1173416959543459841,1173417638056017922,1377924655306518530', '岗位删除（批量）', 'post:batch:delete', '/system/post/deleteBatch', 'GET', '0', '1', 10.00, '1170896100656156674', '2021-04-02 18:22:06', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377930633724821505', '1377924913415598081', '1173416959543459841,1173417638056017922,1377924913415598081', '配置查询', 'config:list', '/system/config/page', 'GET', '0', '1', 2.00, '1170896100656156674', '2021-04-02 18:27:18', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377930633724821506', '1377924913415598081', '1173416959543459841,1173417638056017922,1377924913415598081', '配置添加', 'config:save', '/system/config/save', 'POST', '0', '1', 4.00, '1170896100656156674', '2021-04-02 18:27:18', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377930633724821507', '1377924913415598081', '1173416959543459841,1173417638056017922,1377924913415598081', '配置修改', 'config:update', '/system/config/update', 'POST', '0', '1', 5.00, '1170896100656156674', '2021-04-02 18:27:18', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377930633724821508', '1377924913415598081', '1173416959543459841,1173417638056017922,1377924913415598081', '配置删除', 'config:delete', '/system/config/delete', 'POST', '0', '1', 7.00, '1170896100656156674', '2021-04-02 18:27:18', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377930633724821509', '1377924913415598081', '1173416959543459841,1173417638056017922,1377924913415598081', '配置删除（批量）', 'config:batch:delete', '/system/config/deleteBatch', 'POST', '0', '1', 9.00, '1170896100656156674', '2021-04-02 18:27:18', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1377931926581280770', '1377924955010510850', '1173416959543459841,1173417638056017922,1377924955010510850', '日志查询', 'log:list', '/system/log/page', 'GET', '0', '1', 2.00, '1170896100656156674', '2021-04-02 18:32:27', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379319785074839553', '1173417638056017922', '0,1173417638056017922', '任务管理', NULL, NULL, NULL, '0', '0', 90.00, '1170896100656156674', '2021-04-06 14:27:18', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734722', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '任务查询', 'job:list', '/monitor/job/page', 'GET', '0', '1', 1.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734723', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '任务添加', 'job:save', '/monitor/job/save', 'POST', '0', '1', 3.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734724', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '任务修改', 'job:update', '/monitor/job/update', 'POST', '0', '1', 5.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734725', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '任务删除', 'job:delete', '/monitor/job/delete', 'POST', '0', '1', 7.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734726', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '任务删除（批量）', 'job:batch:delete', '/monitor/job/deleteBatch', 'POST', '0', '1', 9.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734727', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '切换状态', 'job:change:status', '/monitor/job/changeStatus', 'POST', '0', '1', 11.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734728', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '执行一次', 'job:run', '/monitor/job/run', 'POST', '0', '1', 14.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);
INSERT INTO `sys_resources` VALUES ('1379320248616734729', '1379319785074839553', '0,1173417638056017922,1379319785074839553', '调度日志', 'job:task:log', '/monitor/jobLog/page', 'GET', '0', '1', 16.00, '1170896100656156674', '2021-04-06 14:29:08', NULL, NULL, '0', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色id',
  `role_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色权限字符串',
  `role_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色状态（0、正常；1、禁用）',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1、全部数据权限；2、自定数据权限；3、本部门数据权限；4、本部门及以下数据权限）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1171709223680184321', '管理员', 'ROLE_ADMIN', '0', '1', NULL, NULL, '1170896100656156674', '2021-03-29 16:36:53', '0', '备注');
INSERT INTO `sys_role` VALUES ('1171953892250918913', '开发组长', 'ROLE_DEVELOP', '0', '4', NULL, NULL, '1170896100656156674', '2021-03-31 08:02:34', '0', NULL);
INSERT INTO `sys_role` VALUES ('1171953965877731330', '测试组长', 'ROLE_TEST', '0', '4', NULL, NULL, '1170896100656156674', '2021-03-29 15:40:37', '0', NULL);
INSERT INTO `sys_role` VALUES ('1171954063797952514', '项目经理', 'ROLE_MANAGE', '1', '1', NULL, NULL, NULL, NULL, '0', NULL);
INSERT INTO `sys_role` VALUES ('1339373635128303617', 'test2', 'ROLE_AAD', '1', '2', NULL, NULL, '1170896100656156674', '2021-03-29 14:35:16', '0', NULL);

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色id',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '部门id',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES ('1339373635128303617', '2');

-- ----------------------------
-- Table structure for sys_role_res
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_res`;
CREATE TABLE `sys_role_res`  (
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色id',
  `res_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源id',
  PRIMARY KEY (`role_id`, `res_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和资源关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_res
-- ----------------------------
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173417638056017922');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173417760584220674');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173494683788189698');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173519815223037953');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173519895434907649');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173519984786165761');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173520061013446658');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173520251158024193');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173521725967654914');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173786240433037313');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173786896229244930');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173787141281456130');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173787273578192898');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173787371326447617');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173787467954823170');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173787686142517250');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173792738055856130');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173793141136859137');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173793218580488194');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173793287136387073');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1173793449908936705');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1208938290946772993');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1208938414578077698');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1208938659106000810');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1208938659106000811');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1208938659106000898');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377924533432627201');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377924655306518530');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377924913415598081');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377924955010510850');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377928656441847810');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377928808594419714');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377928808594419715');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377928808594419716');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377929323734642690');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377929323734642691');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377929323734642692');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377929323734642693');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377929323734642694');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377930633724821505');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377930633724821506');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377930633724821507');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377930633724821508');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377930633724821509');
INSERT INTO `sys_role_res` VALUES ('1171709223680184321', '1377931926581280770');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '部门id',
  `username` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_type` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '用户类型（0、管理员；1、普通用户）',
  `email` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `phone_number` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别（0、男；1、女）',
  `avatar_path` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `user_status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0、正常；1、禁用）',
  `create_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新者',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标识',
  `remark` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('1170896100656156674', '1', 'admin', '{bcrypt}$2a$10$I3nz8bGJfgpKcZbUSJnc8.PQxAYXdJP6r.eLHzdsfBLsCOx8JSB76', '管理员', '0', '13223423@qq.com', '15988888885', '1', NULL, '0', NULL, '2021-04-03 09:19:01', '1170896100656156674', '2021-04-03 09:25:21', '0', '管理员');
INSERT INTO `sys_user_info` VALUES ('1171948965562806274', '2', '1234567', '{bcrypt}$2a$10$O2YavjwTheFjryKJSrZGv.aixXnZ1K6GgtCAxEMg5KXSC6gvCDKSy', 'dd', '1', 'dsfa', '112312', '1', NULL, '0', '1170896100656156674', NULL, '1170896100656156674', NULL, '0', 'dd');
INSERT INTO `sys_user_info` VALUES ('1298494547157360642', '3', '121212121', '{bcrypt}$2a$10$XryvgFQCGnLn88wV13lm.ezWYcxlPd8VsRWdYa98lqCLwLCya4Aaa', '千千万万1', '1', 'ddasfsda@qq', '154123123213', '1', NULL, '0', NULL, '2020-08-25 13:36:40', '1170896100656156674', '2021-03-17 13:49:10', '0', 'ddd');
INSERT INTO `sys_user_info` VALUES ('1339368705646702593', '3', '12345676', '{bcrypt}$2a$10$U1GwFyVo1.xXknTYIbU72OlHox2S8OCkzSd0pAmIZV.MYLtuMhzwe', '1116', '1', '11116', '123123412346', '2', NULL, '1', NULL, NULL, '1170896100656156674', '2021-03-17 13:49:05', '0', NULL);

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `post_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '岗位id',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES ('1298494547157360642', '1372012058585690114');
INSERT INTO `sys_user_post` VALUES ('1298494547157360642', '1372053095446319106');
INSERT INTO `sys_user_post` VALUES ('1298494547157360642', '1372053161728905217');
INSERT INTO `sys_user_post` VALUES ('1298494547157360642', '1372053279836311554');
INSERT INTO `sys_user_post` VALUES ('1339368705646702593', '1372012058585690114');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户id',
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1170896100656156674', '1171709223680184321');
INSERT INTO `sys_user_role` VALUES ('1171948965562806274', '1171953965877731330');

SET FOREIGN_KEY_CHECKS = 1;
