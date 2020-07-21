package com.mini.base.constant;

/**
 * 权限code
 *
 * @author huqianbo
 * @date 2019/6/18 18:05
 */
public class AuthCodeConstant {

    /**
     * 无需验证权限
     */
    public static final String AUTH_NOT_CHECK = "AUTH_NOT_CHECK";
    /**
     * 无需验证是否设置过权限
     */
    public static final String AUTH_NOT_NO_SET_AUTH = "AUTH_NOT_NO_SET_AUTH";

    /**
     * h5 C端接口权限
     */
    //会员登录权限
    public static final String H5_AUTH_LOGIN = "h5_auth_login";

    /**
     * 首页
     */
    public static final String HOME_VIEW = "home_view"; //查看
    //预约入住
    public static final String HOME_RES_LOOK = "home_res_look"; //待看房
    //租客服务
    public static final String HOME_RENTER_PROMOTION_VIEW = "home_renter_promotion_view"; //待催租-查看
    public static final String HOME_RENTER_PROMOTION = "home_renter_promotion"; //催租
    public static final String HOME_RENTER_EXPIRE = "home_renter_expire"; //将到期
    public static final String HOME_RENTER_CONFIRM = "home_renter_confirm"; //待确认
    //公寓事宜
    public static final String HOME_DEVICE_ABNORMAL = "home_device_abnormal"; //设备异常
    public static final String HOME_NOTICE_ADD = "home_notice_add"; //新建通知

    /*******************************************************************************************************/

    /**
     * 租控图
     */
    public static final String CONTROL_VIEW = "control_view"; //查看
    public static final String CONTROL_DOORLOCK = "control_doorlock"; //门锁
    public static final String CONTROL_ORDER = "control_order"; //预订
    public static final String CONTROL_DIRTY = "control_dirty"; //置脏房，净房
    public static final String CONTROL_LOCK = "control_lock"; //锁房
    public static final String CONTROL_REPAIR = "control_repair"; //维修

    /*******************************************************************************************************/

    /**
     * 公寓配置
     */
    //公寓管理
    public static final String APARTMENT_VIEW = "apartment_view"; //查看
    public static final String APARTMENT_ADD = "apartment_add"; //新增
    public static final String APARTMENT_EDIT = "apartment_edit"; //编辑
    //规格管理
    public static final String APARTMENT_SPEC_VIEW = "apartment_spec_view"; //查看
    public static final String APARTMENT_SPEC_ADD = "apartment_spec_add"; //新增（房型，物品，床型）
    public static final String APARTMENT_SPEC_EDIT = "apartment_spec_edit"; //编辑（房型，物品，床型）
    //物品管理
    public static final String APARTMENT_ARTICLE_VIEW = "apartment_article_view"; //查看
    public static final String APARTMENT_ARTICLE_ADD = "apartment_article_add"; //新增（资产登记）
    public static final String APARTMENT_ARTICLE_EDIT = "apartment_article_edit"; //编辑（资产调控）
    //床位设置
    public static final String APARTMENT_BED_VIEW = "apartment_bed_view"; //查看
    public static final String APARTMENT_BED_EDIT = "apartment_bed_edit"; //编辑（编辑床型）
    //字典管理
    public static final String COMMON_DICT_VIEW = "common_dict_view"; //查看（查看页面，词条详情）
    public static final String COMMON_DICT_ADD = "common_dict_add"; //新增（新增词条）
    public static final String COMMON_DICT_EDIT = "common_dict_edit"; //编辑（编辑词条）
    //fdd模板
    /**
     * 法大大模板参数查看
     */
    public static final String FDD_TEMPLATEPARAMETER_VIEW = "fdd_templaterParameter_view";


    /*******************************************************************************************************/

    /**
     * 订单管理
     */
    //订单管理-长租订单
    public static final String ORDER_LONG_VIEW = "order_long_view"; //查看
    public static final String ORDER_LONG_EDIT = "order_long_edit"; //订单修改
    public static final String ORDER_LONG_CANCELCHECKIN = "order_long_cancelcheckin"; //取消入住
    public static final String ORDER_LONG_CHECKIN = "order_long_checkin"; //签约入住
    public static final String ORDER_LONG_CHANGE = "order_long_change"; //办理换房
    public static final String ORDER_LONG_RELET = "order_long_relet"; //办理续租
    public static final String ORDER_LONG_RETURN = "order_long_return"; //办理退租
    public static final String ORDER_LONG_BILL_ADD = "order_long_bill_add"; //新建账单
    public static final String ORDER_LONG_BILL_GATHERING = "order_long_bill_gathering"; //账单收款
    public static final String ORDER_LONG_BILL_REVOKE = "order_long_bill_revoke"; //账单撤销收款
    public static final String ORDER_LONG_BILL_DEL = "order_long_bill_del"; //账单删除
    public static final String ORDER_LONG_ACCOUNT_OFFSET = "order_long_account_offset"; //账务冲抵
    public static final String ORDER_LONG_ACCOUNT_ADJUSTMENT = "order_long_account_adjustment"; //账务调整
    public static final String ORDER_LONG_ADD = "order_long_add"; //新建订单
    public static final String ORDER_LONG_BILL_BALANCE_QUERY = "bill_balance_query"; // 查询余额
    public static final String ORDER_LONG_BILL_DISCARD = "bill_Discard"; // 账单作废
    //预约看房
    public static final String ORDER_RESERVATION_VIEW = "order_reservation_view"; // 查看

    //坏账收款
    public static final String ORDER_BAD_DEBT = "order_bad_debt";


    //企业合约
    public static final String ORDER_ETP_VIEW = "order_etp_view"; //查看
    public static final String ORDER_ETP_RELET = "order_etp_relet"; //续签
    public static final String ORDER_ETP_TERMINATE = "order_etp_terminate"; //终止
    public static final String ORDER_ETP_CHECKIN = "order_etp2_checkin"; //企业用户入住
    public static final String ORDER_ETP_RETURN = "order_etp_return"; //企业用户退租
    public static final String ORDER_ETP_ADD = "order_etp_add"; //新建企业合约

    /*******************************************************************************************************/

    /**
     * 销售管理(长租)
     */
    //公约管理
    public static final String APARTMENT_TREATY_VIEW = "apartment_treaty_view"; //查看
    public static final String APARTMENT_TREATY_ADD = "apartment_treaty_add"; //新增
    public static final String APARTMENT_TREATY_ENABLE = "apartment_treaty_enable"; //启用/禁用
    public static final String APARTMENT_TREATY_DEL = "apartment_treaty_del"; //删除
    public static final String APARTMENT_TREATY_EDIT = "apartment_treaty_edit"; //编辑
    // 房价管理
    public static final String APARTMENT_PRICE_VIEW = "apartment_price_view"; //查看
    public static final String APARTMENT_PRICE_EDIT = "apartment_price_edit"; //编辑
    public static final String APARTMENT_PRICE_UPDATE = "apartment_price_update"; //修改底价
    //交租管理
    public static final String APARTMENT_RENT_VIEW = "apartment_rent_view"; //查看
    public static final String APARTMENT_RENT_ADD = "apartment_rent_add"; //新增
    public static final String APARTMENT_RENT_EDIT = "apartment_rent_edit"; //编辑
    public static final String APARTMENT_RENT_DEL = "apartment_rent_del"; //删除
    public static final String APARTMENT_RENT_ENABLE = "apartment_rent_enable"; //启用/禁用
    //租期管理
    public static final String APARTMENT_PERIOD_VIEW = "apartment_period_view"; //查看
    public static final String APARTMENT_PERIOD_ADD = "apartment_period_add"; //新增
    public static final String APARTMENT_PERIOD_EDIT = "apartment_period_edit"; //编辑
    public static final String APARTMENT_PERIOD_DEL = "apartment_period_del"; //删除
    public static final String APARTMENT_PERIOD_ENABLE = "apartment_period_enable"; //启用/禁用
    //房源管理
    public static final String APARTMENT_ROOM_VIEW = "apartment_room_view"; //查看
    public static final String APARTMENT_ROOM_UPPER = "apartment_room_upper"; //上架，下架权限

    //佣金规则
    public static final String COMMISSION_VIEW = "commission_view"; //查看
    public static final String COMMISSION_ADD = "commission_add"; //新增
    public static final String COMMISSION_EDIT = "commission_edit"; //编辑

    /*******************************************************************************************************/

    /**
     * 客户管理
     */
    //会员管理
    public static final String MEMBER_VIEW = "member_view"; //查看（页面查看，会员详情查看）
    public static final String MEMBER_ADD = "member_add"; //新增会员
    public static final String MEMBER_EDIT = "member_edit"; //编辑会员
    //企业客户
    public static final String MEMBER_ETP_VIEW = "member_etp_view"; //查看（页面查看，企业信息详情）
    public static final String MEMBER_ETP_ADD = "member_etp_add"; //新增企业用户
    public static final String MEMBER_ETP_EDIT = "member_etp_edit"; //编辑企业信息

    /*******************************************************************************************************/

    /**
     * 系统配置
     */
    //组织管理
    public static final String COMMON_ORG_VIEW = "common_org_view"; //查看
    public static final String COMMON_ORG_ADD = "common_org_add"; //新增
    public static final String COMMON_ORG_EDIT = "common_org_edit"; //启用/禁用
    //用户组织权限管理
    public static final String USER_ORGAUTH_VIEW = "user_orgAuth_view"; //查看
    public static final String USER_ORGAUTH_ASSIGN = "user_orgAuth_assign"; //权限分配
    //城市管理
    public static final String COMMON_CITY_VIEW = "common_city_view"; //查看
    //账号管理
    public static final String USER_VIEW = "user_view"; //查看
    public static final String USER_ADD = "user_add"; //新建账号
    public static final String USER_EDIT = "user_edit"; //编辑账号
    //角色管理
    public static final String USER_ROLE_VIEW = "user_role_view"; //查看
    public static final String USER_ROLE_ADD = "user_role_add"; //新建角色
    public static final String USER_ROLE_EDIT = "user_role_edit"; //编辑角色
    public static final String USER_ROLE_AUTH = "user_role_auth"; //角色权限分配

    /*******************************************************************************************************/

    /**
     * 财务管理
     */
    //财务公司
    public static final String FINANCE_COMPANY_VIEW = "finance_company_view"; //查看
    public static final String FINANCE_COMPANY_ADD = "finance_company_add"; //新增
    public static final String FINANCE_COMPANY_EDIT = "finance_company_edit"; //编辑
    public static final String FINANCE_COMPANY_DEL = "finance_company_del"; //删除
    //营业科目
    public static final String FINANCE_SUBJECT_VIEW = "finance_subject_view"; //查看
    public static final String FINANCE_SUBJECT_ADD = "finance_subject_add"; //新增
    public static final String FINANCE_SUBJECT_EDIT = "finance_subject_edit"; //编辑
    public static final String FINANCE_SUBJECT_ENABLE = "finance_subject_enable"; //启用，禁用
    //公寓营业科目
    public static final String FINANCE_APTSUBJECT_VIEW = "finance_aptSubject_view"; //查看
    public static final String FINANCE_APTSUBJECT_EDIT = "finance_aptSubject_edit"; //新增
    public static final String FINANCE_APTSUBJECT_ENABLE = "finance_aptSubject_enable"; //启用，禁用
    public static final String FINANCE_APTSUBJECT_SYNC = "finance_aptSubject_sync"; //同步
    //津贴科目
    public static final String FINANCE_ALLOWANCE_VIEW = "finance_allowance_view"; //查看
    public static final String FINANCE_ALLOWANCE_ADD = "finance_allowance_add"; //新增
    public static final String FINANCE_ALLOWANCE_EDIT = "finance_allowance_edit"; //编辑
    public static final String FINANCE_ALLOWANCE_ENABLE = "finance_allowance_enable"; //启用，禁用
    //税率科目
    public static final String FINANCE_TAX_VIEW = "finance_tax_view"; //查看
    public static final String FINANCE_TAX_ADD = "finance_tax_add"; //新增
    public static final String FINANCE_TAX_EDIT = "finance_tax_edit"; //编辑
    public static final String FINANCE_TAX_ENABLE = "finance_tax_enable"; //启用，禁用
    //退款
    public static final String ORDER_REFUND_VIEW = "order_refund_view"; //查看
    public static final String ORDER_REFUND_FINISH = "order_refund_finish"; //退款完成
    //合同管理
    public static final String ORDER_CONTRACT_VIEW = "order_contract_view"; //查看
    // 现付账
    public static final String FINANCE_CASHACCOUNT_VIEW = "finance_cashAccount_view"; //查看
    public static final String FINANCE_CASHACCOUNT_ADD = "finance_cashAccount_add"; //新建
    public static final String FINANCE_CASHACCOUNT_REVOKE = "finance_cashAccount_revoke"; //撤销账单
    public static final String FINANCE_CASHACCOUNT_CANANDFINISH = "finance_cashAccount_canAndFinish"; //取消撤销,撤销完成
    // 应收账管理
    public static final String FINANCE_AR_VIEW = "finance_ar_view"; //查看
    public static final String FINANCE_AR_ADD = "finance_ar_add"; //新增
    // 应收账核销
    public static final String FINANCE_AR_VERIFY_VIEW = "finance_ar_verify_view"; //查看
    public static final String FINANCE_AR_VERIFY = "finance_ar_verify"; //核销
    public static final String FINANCE_AR_VERIFY_BAD = "finance_ar_verify_bad"; //标记坏账
    public static final String FINANCE_AR_VERIFY_ACCOUNT = "finance_ar_verify_account"; //入账/退款


    /*******************************************************************************************************/

    /**
     * 设备管理
     */
    //公寓设备
    public static final String DEVICE_APT_VIEW = "device_apt_view"; //查看
    public static final String DEVICE_APT_ADD = "device_apt_add"; //新增
    public static final String DEVICE_APT_ENABLE = "device_apt_enable"; //启用，禁用
    //设备录入
    public static final String DEVICE_INPUT_VIEW = "device_input_view"; //查看
    public static final String DEVICE_INPUT_IMPORT = "device_input_import"; //导入
    public static final String DEVICE_INPUT_EDIT = "device_input_edit"; //编辑
    //水电结算
    public static final String DEVICE_SETTLE_VIEW = "device_settle_view"; //查看
    public static final String DEVICE_SETTLE_READING = "device_settle_reading"; //抄表
    public static final String DEVICE_SETTLE_PUSH = "device_settle_push"; //推送账单
    //厂商管理
    public static final String DEVICE_VENDOR_VIEW = "device_vendor_view"; //查看
    public static final String DEVICE_VENDOR_ADD = "device_vendor_add"; //新增
    public static final String DEVICE_VENDOR_EDIT = "device_vendor_edit"; //编辑
    public static final String DEVICE_VENDOR_DEL = "device_vendor_del"; //删除

    /*******************************************************************************************************/

    /**
     * 销售管理
     */
    //文章管理
    public static final String SALES_ESSAY_VIEW = "sales_essay_view"; //查看
    public static final String SALES_ESSAY_EDIT = "sales_essay_edit"; //编辑
    public static final String SALES_ESSAY_ADD = "sales_essay_add"; //新建文章
    public static final String SALES_ESSAY_PUB = "sales_essay_pub"; //发布，取消发布
    public static final String SALES_ESSAY_DEL = "sales_essay_del"; //删除
    //广告管理
    public static final String SALES_AD_VIEW = "sales_ad_view"; //查看
    public static final String SALES_AD_EDIT = "sales_ad_edit"; //编辑
    public static final String SALES_AD_ADD = "sales_ad_add"; //新建
    public static final String SALES_AD_DEL = "sales_ad_del"; //删除
    //推荐位
    public static final String SALES_RECMD_VIEW = "sales_recmd_view"; //查看
    public static final String SALES_RECMD_EDIT = "sales_recmd_edit"; //编辑
    public static final String SALES_RECMD_ADD = "sales_recmd_add"; //新建


    /*******************************************************************************************************/

    /**
     * 服务管理
     */
    //保洁工单
    public static final String WORKORDER_CLEANING_VIEW = "workOrder_cleaning_view"; //查看
    public static final String WORKORDER_CLEANING_ADD = "workOrder_cleaning_add"; //新增
    public static final String WORKORDER_CLEANING_UPDATE = "workOrder_cleaning_update"; //修改
    public static final String WORKORDER_CLEANING_STOP = "workOrder_cleaning_stop"; //终止
    public static final String WORKORDER_CLEANING_STEP_DELEGATE = "workOrder_cleaning_step_delegate"; //委派
    public static final String WORKORDER_CLEANING_STEP_ACCEPT = "workOrder_cleaning_step_accept"; //受理
    public static final String WORKORDER_CLEANING_STEP_ADDLOG = "workOrder_cleaning_step_addLog"; //添加记录
    public static final String WORKORDER_CLEANING_STEP_FINISH = "workOrder_cleaning_step_finish"; //完成服务
    public static final String WORKORDER_CLEANING_STEP_CHECK = "workOrder_cleaning_step_check"; //检查验收
    //维修工单
    public static final String WORKORDER_REPAIR_VIEW = "workOrder_repair_view"; //查看
    public static final String WORKORDER_REPAIR_ADD = "workOrder_repair_add"; //新增
    public static final String WORKORDER_REPAIR_UPDATE = "workOrder_repair_update"; //修改
    public static final String WORKORDER_REPAIR_STOP = "workOrder_repair_stop"; //终止
    public static final String WORKORDER_REPAIR_STEP_DELEGATE = "workOrder_repair_step_delegate"; //委派
    public static final String WORKORDER_REPAIR_STEP_ACCEPT = "workOrder_repair_step_accept"; //受理
    public static final String WORKORDER_REPAIR_STEP_ADDLOG = "workOrder_repair_step_addLog"; //添加记录
    public static final String WORKORDER_REPAIR_STEP_BILL = "workOrder_repair_step_bill"; //账单权限
    public static final String WORKORDER_REPAIR_STEP_FINISH = "workOrder_repair_step_finish"; //完成服务
    public static final String WORKORDER_REPAIR_STEP_CHECK = "workOrder_repair_step_check"; //检查验收
    //问题投诉工单
    public static final String WORKORDER_QUESTION_VIEW = "workOrder_question_view"; //查看
    public static final String WORKORDER_QUESTION_ADD = "workOrder_question_add"; //新增
    public static final String WORKORDER_QUESTION_UPDATE = "workOrder_question_update"; //修改
    public static final String WORKORDER_QUESTION_STOP = "workOrder_question_stop"; //终止
    public static final String WORKORDER_QUESTION_STEP_DELEGATE = "workOrder_question_step_delegate"; //委派
    public static final String WORKORDER_QUESTION_STEP_ACCEPT = "workOrder_question_step_accept"; //受理
    public static final String WORKORDER_QUESTION_STEP_ADDLOG = "workOrder_question_step_addLog"; //添加记录
    public static final String WORKORDER_QUESTION_STEP_FINISH = "workOrder_question_step_finish"; //完成服务

    /**
     * 添加内部服务人员
     */
    public static final String WORKORDER_SERVER_INNER_QUERY = "workOrder_server_inner_query";
    /**
     * 添加外部服务人员
     */
    public static final String WORKORDER_SERVER_OUTER_ADD = "workOrder_server_outer_add";


    /********************************************** 保洁计划 **********************************************/
    /**
     * 保洁计划新增
     */
    public static final String WORKORDER_PLAN_ADD = "workOrder_plan_add";
    /**
     * 保洁计划终止
     */
    public static final String WORKORDER_PLAN_CANCEL = "workOrder_plan_cancel";
    /**
     * 保洁计划查看
     */
    public static final String WORKORDER_PLAN_VIEW = "workOrder_plan_view";

    /* ********** 报表管理 ********** */
    /**
     * 账单明细查看
     */
    //public static final String REPORT_BILL_DETAIL_VIEW = "report_bill_detail_view";
    public static final String REPORT_BILL_VIEW = "report_bill_view"; //账单明细-查看
    public static final String REPORT_RECEIVABLES_VIEW = "report_receivables_view"; //收款明细-查看
    public static final String REPORT_RECEIVABLES_CONFIRM = "report_receivables_confirm"; //收款明细-确认收款
    public static final String REPORT_PAYABLE_VIEW = "report_payable_view"; //应缴明细-查看
    public static final String REPORT_BUSINESS_VIEW = "report_business_view"; //营业收入-查看



    /* ********** 日租 ********** */

    /**
     * 管家工作台
     */
    public static final String SHORT_WORKBENCH_VIEW = "short_workbench_view"; //查看
    public static final String SHORT_WORKBENCH_RES_VIEW = "short_workbench_res_view"; //今日预定
    public static final String SHORT_WORKBENCH_OUT_VIEW = "short_workbench_out_view"; //今日预离
    public static final String SHORT_WORKBENCH_ARREARS_VIEW = "short_workbench_arrears_view"; //欠费租客
    public static final String SHORT_ORDER_BILL_STAYS_VIEW = "short_order_bill_stays_view"; //挂账订单
    public static final String SHORT_NOTICE_ADD = "short_notice_add"; //公寓事宜-新建通知

    /**
     * 租控图
     */
    public static final String SHORT_CONTROL_VIEW = "short_control_view"; //查看
    public static final String SHORT_CONTROL_CHECKIN = "short_control_checkin"; //入住
    public static final String SHORT_CONTROL_CHECKOUT = "short_control_checkout"; //离店
    public static final String SHORT_CONTROL_DIRTY = "short_control_dirty"; //净房
    public static final String SHORT_CONTROL_SELF = "short_control_self"; //自用
    public static final String SHORT_CONTROL_REPAIR = "short_control_repair"; //维修

    /**
     * 订单管理
     */
    public static final String SHORT_ORDER_VIEW = "short_order_view"; //查看
    public static final String SHORT_ORDER_ADD = "short_order_add"; //新建
    public static final String SHORT_ORDER_CHECKIN = "short_order_checkin"; //登记入住
    public static final String SHORT_ORDER_REC_VIEW = "short_order_rec_view"; //接待单查看
    public static final String SHORT_ORDER_REC_STATUS = "short_order_rec_status"; //免打扰/保密
    public static final String SHORT_ORDER_CHECKOUT = "short_order_checkout"; //退房
    public static final String SHORT_ORDER_CHANGE = "short_order_change"; //换房
    public static final String SHORT_ORDER_RELET = "short_order_relet"; //续住
    public static final String SHORT_ORDER_PERSON_ADD = "short_order_person_add"; //添加入住人
    public static final String SHORT_ORDER_GUEST_VIEW = "short_order_guest_view"; //查看客历
    public static final String SHORT_ORDER_BILL_VIEW = "short_order_bill_view"; //账单查看
    public static final String SHORT_ORDER_BILL_ENTRY = "short_order_bill_entry"; //入账
    public static final String SHORT_ORDER_BILL_RUSH = "short_order_bill_rush"; //冲账
    public static final String SHORT_ORDER_BILL_TRANSFER = "short_order_bill_transfer"; //转账
    public static final String SHORT_ORDER_BILL_RECEIVABLE = "short_order_bill_receivable"; //挂应收
    public static final String SHORT_ORDER_BILL_REFUND = "short_order_bill_refund"; //退款
    public static final String SHORT_ORDER_BILL_STAYS = "short_order_bill_stays"; //挂账
    public static final String SHORT_ORDER_BILL_SETTLE = "short_order_bill_settle"; //结账

    /**
     * 交班管理
     */
    public static final String SHORT_HAND_VIEW = "short_hand_view"; //查看
    public static final String SHORT_HAND_OVER = "short_hand_over"; //上班/交班

    /**
     * 销售管理
     */
    public static final String SHORT_SALE_BASE_VIEW = "short_sale_base_view"; //基础配置-查看
    public static final String SHORT_SALE_BASE_ADD = "short_sale_base_add"; //基础配置-新建
    public static final String SHORT_SALE_BASE_EDIT = "short_sale_base_edit"; //基础配置-编辑
    public static final String SHORT_SALE_BASE_ENABLE = "short_sale_base_enable"; //基础配置-启禁用
    public static final String SHORT_SALE_RATECODE_VIEW = "short_sale_rateCode_view"; //房价码-查看
    public static final String SHORT_SALE_RATECODE_ADD = "short_sale_rateCode_add"; //房价码-新建
    public static final String SHORT_SALE_RATECODE_EDIT = "short_sale_rateCode_edit"; //房价码-编辑
    public static final String SHORT_SALE_RATECODE_ENABLE = "short_sale_rateCode_enable"; //房价码-启禁用
    public static final String SHORT_SALE_RATECODE_ORG = "short_sale_rateCode_org"; //房价码-组织
    public static final String SHORT_SALE_RATECODE_DEL = "short_sale_rateCode_del"; //房价码-删除
    public static final String SHORT_SALE_VOLUME_VIEW = "short_sale_volume_view"; //每日房量-查看
    public static final String SHORT_SALE_VOLUME_EDIT = "short_sale_volume_edit"; //每日房量-编辑
    public static final String SHORT_SALE_DAYPRICE_VIEW = "short_sale_dayPrice_view"; //每日房价-查看
    public static final String SHORT_SALE_DAYPRICE_EDIT = "short_sale_dayPrice_edit"; //每日房价-编辑



    /* ********** 员工端 ********** */
    /**
     * 首页
     */
    public static final String STAFF_ROOMVOLUME_VIEW = "staff_roomVolume_view"; //房量统计-查看
    public static final String STAFF_ROOMSTATUS_VIEW = "staff_roomStatus_view"; //房态概览-查看
    public static final String STAFF_WORKSTATISTICS_VIEW = "staff_workStatistics_view"; //工作统计-查看
    public static final String staff_schedule_view = "staff_schedule_view"; //待办事项-查看
    public static final String STAFF_SCHEDULE_RES_VIEW = "staff_schedule_res_view"; //待办事项-待处理预约查看
    public static final String STAFF_SCHEDULE_ORDER_VIEW = "staff_schedule_order_view"; //待办事项-待处理预定查看
    public static final String STAFF_SCHEDULE_CALL_VIEW = "staff_schedule_call_view"; //待办事项-待催缴查看
    /**
     * 租控图
     */
    public static final String STAFF_CONTROL_VIEW = "staff_control_view"; //查看
    public static final String STAFF_CONTROL_RESETPWD = "staff_control_resetpwd"; //重置密码
    public static final String STAFF_CONTROL_ORDER_VIEW = "staff_control_order_view"; //查看订单
    public static final String STAFF_CONTROL_SENDPWD = "staff_control_sendpwd"; //修改密码
    /**
     * 租务
     */
    public static final String STAFF_OD_VIEW = "staff_od_view"; //查看
    public static final String STAFF_RES_VIEW = "staff_res_view"; //租客待看
    public static final String STAFF_ORDER_VIEW = "staff_order_view"; //租客签约
    public static final String STAFF_ORDER_GATHERING = "staff_order_gathering"; //收款
    public static final String STAFF_ORDER_CHECKIN = "staff_order_checkin"; //办理入住
    /**
     * 服务
     */
    public static final String STAFF_SERVICE_VIEW = "staff_service_view"; //查看
    public static final String STAFF_SERVICE_CLEANING = "staff_service_cleaning"; //上门保洁
    public static final String STAFF_SERVICE_REPAIR = "staff_service_repair"; //维修
    public static final String STAFF_SERVICE_QUESTION = "staff_service_question"; //投诉建议
    /**
     * 物业设备
     */
    public static final String STAFF_DEVICE_READING = "staff_device_reading"; //物业抄表





}
