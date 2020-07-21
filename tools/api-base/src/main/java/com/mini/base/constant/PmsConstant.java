package com.mini.base.constant;

/**
 * @author root
 * 系统常量
 */
public interface PmsConstant {
    /**
     * 编码
     */
    String UTF_8 = "UTF-8";

    /**
     * contentType
     */
    String CONTENT_TYPE_NAME = "Content-type";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json;charset=utf-8";

    /**
     * 主键字段名
     */
    String DB_PRIMARY_KEY = "id";

    /**
     * 业务状态[1:正常]
     */
    int DB_STATUS_NORMAL = 1;


    /**
     * 删除状态[0:正常,1:删除]
     */
    int DB_NOT_DELETED = 0;
    int DB_IS_DELETED = 1;

    /**
     * 短租交班签到状态[0:已交班,1:已签到]
     */
    int SHANDOVER_NOT_CHECK_IN = 0;
    int SHANDOVER_IS_CHECK_IN = 1;

    /**
     * 用户锁定状态
     */
    int DB_ADMIN_NON_LOCKED = 0;
    int DB_ADMIN_LOCKED = 1;

    /**
     * 管理员对应的租户编号
     */
    String ADMIN_TENANT_CODE = "000000";

    /**
     * 日志默认状态
     */
    String LOG_NORMAL_TYPE = "1";

    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "暂无承载数据";
    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    String DEFAULT_FAILURE_MESSAGE = "操作失败";
    /**
     * 默认未授权消息
     */
    String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";

    /**
     * 生效状态
     */
    String STATUS_ENABLE = "0";

    /**
     * 无效状态
     */
    String STATUS_UNABLE = "1";

    //通用操作类型
    Integer OPERATIONTYPE_DELETE = -1; //删除
    Integer OPERATIONTYPE_INSERT = 1; //新增
    Integer OPERATIONTYPE_UPDATE = 2; //修改
    Integer OPERATIONTYPE_QUERY = 3; //查询

    //TRUE or False
    Integer FLAG_TRUE = 1;
    Integer FLAG_FALSE = 0;

    // 万能验证码
    String COMMON_VERIFICATION_CODE = "A696F7F4D88BE70E";

    // token过期时间 （30天）
    int H5_TOKEN_EXPIRE_SECOND = 30 * 24 * 60 * 60;

    // token过期时间 （30天）
    int APPID_EXPIRE_SECOND = 30 * 24 * 60 * 60;


    /**
     * 营业科目类目[1:大类,2:小类]
     */
    int SUJECT_CLASS_BIG = 1;//大类
    int SUJECT_CLASS_SMALL = 2;//小类

    /**
     * 渠道客户：渠道类型[1:个人，2:企业]
     */
    Integer CHANNEL_MEMBER_CONTACT = 1;//个人
    Integer CHANNEL_MEMBER_ENTERPRISE = 2;//企业

}
