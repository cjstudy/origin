package com.mini.base.constant;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.*;

/**
 * 新建租户初始化相关常量类
 *
 * @author hqb
 * @date 2019/5/6 19:47
 */
public class TenantInitConstant {

    //用户
    public enum User {
        ADMIN("admin", "admin", "apms@123"),
        ;

        public String account;
        public String name;
        public String password;

        User(String account, String name, String password) {
            this.account = account;
            this.name = name;
            this.password = password;
        }
    }

    //角色
    public enum Role {
        ADMIN("超级管理员"),
        ;

        public String name;

        Role(String name) {
            this.name = name;
        }
    }

    //角色权限
    public static List<RoleActionDemo> getRoleActionDemoList() {

        Map<Long, Long[]> dataMap = new LinkedHashMap<>();
        dataMap.put(101L, new Long[]{11L, 109L, 110L, 111L, 112L, 113L, 114L, 115L});
        dataMap.put(102L, new Long[]{116L, 117L, 118L, 119L, 120L, 121L});
        dataMap.put(201L, new Long[]{67L, 68L, 69L, 70L, 71L, 72L, 73L, 74L, 75L, 76L, 223L, 225L, 226L, 227L, 228L});
        dataMap.put(202L, new Long[]{77L, 78L, 79L, 80L, 81L, 82L});
        dataMap.put(301L, new Long[]{15L});
        dataMap.put(401L, new Long[]{64L, 65L, 66L});
        dataMap.put(402L, new Long[]{61L, 62L, 63L});
        dataMap.put(501L, new Long[]{83L, 84L, 85L, 86L, 87L});
        dataMap.put(502L, new Long[]{88L, 89L, 90L});
        dataMap.put(503L, new Long[]{91L, 92L, 93L, 94L, 95L});
        dataMap.put(504L, new Long[]{96L, 97L, 98L, 99L, 100L});
        dataMap.put(505L, new Long[]{101L, 102L});
        dataMap.put(701L, new Long[]{131L, 132L, 133L, 134L});
        dataMap.put(702L, new Long[]{135L, 136L, 137L, 138L});
        dataMap.put(703L, new Long[]{139L, 140L, 141L, 224L});
        dataMap.put(704L, new Long[]{142L, 143L, 144L, 145L});
        dataMap.put(705L, new Long[]{146L, 147L, 148L, 149L});
        dataMap.put(706L, new Long[]{129L, 130L});
        dataMap.put(707L, new Long[]{182L, 183L, 184L, 185L});
        dataMap.put(708L, new Long[]{186L, 187L});
        dataMap.put(709L, new Long[]{188L, 189L, 190L, 191L});
        dataMap.put(801L, new Long[]{47L, 48L, 49L});
        dataMap.put(802L, new Long[]{50L, 51L, 52L});
        dataMap.put(803L, new Long[]{53L, 54L, 55L});
        dataMap.put(804L, new Long[]{58L, 59L, 60L});
        dataMap.put(805L, new Long[]{56L, 57L});
        dataMap.put(806L, new Long[]{234L});
        dataMap.put(901L, new Long[]{150L, 151L, 152L});
        dataMap.put(902L, new Long[]{153L, 154L, 155L});
        dataMap.put(903L, new Long[]{156L, 157L, 158L});
        dataMap.put(904L, new Long[]{159L, 160L, 161L, 162L});
        dataMap.put(1001L, new Long[]{103L, 104L, 105L});
        dataMap.put(1002L, new Long[]{106L, 107L});
        dataMap.put(1003L, new Long[]{108L});
        dataMap.put(1004L, new Long[]{122L, 123L, 124L});
        dataMap.put(1005L, new Long[]{125L, 126L, 127L, 128L});
        dataMap.put(1101L, new Long[]{196L, 197L, 198L, 199L, 200L, 201L, 202L, 203L, 204L, 229L, 230L, 231L, 232L, 233L});
        dataMap.put(1102L, new Long[]{205L, 206L, 207L, 208L, 209L, 210L, 211L, 212L, 213L, 214L});
        dataMap.put(1103L, new Long[]{215L, 216L, 217L, 218L, 219L, 220L, 221L, 222L});
        dataMap.put(1201L, new Long[]{170L, 171L, 172L, 173L, 174L});
        dataMap.put(1202L, new Long[]{166L, 167L, 168L, 169L});
        dataMap.put(1203L, new Long[]{163L, 164L, 165L});
        dataMap.put(1301L, new Long[]{235L});
        dataMap.put(1302L, new Long[]{236L, 237L});
        dataMap.put(1303L, new Long[]{238L});
        dataMap.put(1304L, new Long[]{239L});
        /*短租**/
        dataMap.put(1401L, new Long[]{240L,255L,256L,257L,258L,259L});
        dataMap.put(1402L, new Long[]{241L,250L,251L,252L,253L,254L});
        dataMap.put(1501L, new Long[]{242L,260L,261L,268L,269L,270L,271L,272L,273L,274L,275L,287L});
        dataMap.put(1502L, new Long[]{243L,262L,263L,264L,265L,266L,267L});
        dataMap.put(1601L, new Long[]{244L,276L});
        dataMap.put(1701L, new Long[]{245L,277L,278L,279L});
        dataMap.put(1702L, new Long[]{246L,280L,281L,282L,283L,284L});
        /*dataMap.put(1703L, new Long[]{247L});*/
        dataMap.put(1704L, new Long[]{248L,285L});
        dataMap.put(1705L, new Long[]{249L,286L});


        List<RoleActionDemo> roleActionList = new ArrayList<>();
        RoleActionDemo model = null;
        for (Map.Entry<Long, Long[]> entry : dataMap.entrySet()) {
            Long menuId = entry.getKey();
            Long[] actionIds = entry.getValue();

            for (Long actionId : actionIds) {
                model = new RoleActionDemo();
                model.setMenuId(menuId);
                model.setActionId(actionId);

                roleActionList.add(model);
            }

        }


        return roleActionList;

    }

    //组织
    public enum Organization {
        HEAD("总部"),
        ;

        public String name;

        Organization(String name) {
            this.name = name;
        }
    }

    //字典
    public enum Dictionary {
        ROOMTYPE_TAG("ROOMTYPE_TAG", "房型标签", null),
        APARTMENT_TAG("APARTMENT_TAG", "公寓标签", null),
        APARTMENT_FACILITIY("APARTMENT_FACILITIY", "公寓设施", null),
        APARTMENT_SERVICE("APARTMENT_SERVICE", "公寓服务", null),
        CONTACT_RELATIONSHIP("CONTACT_RELATIONSHIP", "紧急联系人关系", null),
        //FURNITURE_TAG("FURNITURE_TAG", "家具",null),
        //ELECTRIC_TAG("ELECTRIC_TAG", "电器",null),
        //OTHER_TYPE_TAG("OTHER_TYPE_TAG", "其他物品",null),
        ROOM_FACE("ROOM_FACE", "房屋朝向", null),
        BEDTYPE_TAG("BEDTYPE_TAG", "床型标签", null),
        CARD_TYPES("CARD_TYPES", "证件类型", DictionaryItem.getItemListByType("CARD_TYPES")),
        CHANNEL_TAG("CHANNEL_TAG", "渠道标签", null),
        ENTERPRISE_LEVEL_TAG("ENTERPRISE_LEVEL_TAG", "企业级别标签", null),
        PAYMENT_TYPES("PAYMENT_TYPES", "支付方式", DictionaryItem.getItemListByType("PAYMENT_TYPES")),
        CANCEL_REASON("CANCEL_REASON", "取消原因", null),
        ARTICLETYPE_TAG("ARTICLETYPE_TAG", "物品标签", null),
        ORDER_CHANNEL("ORDER_CHANNEL", "订单渠道来源", DictionaryItem.getItemListByType("ORDER_CHANNEL")),
        ESSAY_TAG("ESSAY_TAG", "文章标签", null),
        AD_TAG("AD_TAG", "城市化广告类型", DictionaryItem.getItemListByType("AD_TAG")),

        ;

        public String code;
        public String name;
        public List<DictionaryItem> itemList;

        Dictionary(String code, String name, List<DictionaryItem> itemList) {
            this.code = code;
            this.name = name;
            this.itemList = itemList;
        }

        public static List<Dictionary> getDictionaryDemoList() {
            return Arrays.asList(Dictionary.values());
        }
    }

    /**
     * 字典
     */
    public enum DictionaryItem {
        ALIPAY("ALIPAY", "支付宝", "PAYMENT_TYPES"),
        WECHAT("WECHAT", "微信", "PAYMENT_TYPES"),
        BANK("BANK", "银行转账", "PAYMENT_TYPES"),
        AR_CREDIT("AR_CREDIT", "AR信用", "PAYMENT_TYPES"),
        BALANCE("BALANCE", "余额", "PAYMENT_TYPES"),
        AR_PREPAY("AR_PREPAY", "AR预付", "PAYMENT_TYPES"),
        // 现金
        CASH("CASH", "现金", "PAYMENT_TYPES"),

        APMS("APMS", "APMS", "ORDER_CHANNEL"),
        H5("H5", "H5", "ORDER_CHANNEL"),

        CITY_AD_HOME("CITY_AD_HOME", "城市首页-顶部轮播图", "AD_TAG"),
        //CITY_AD_SERVICE("CITY_AD_SERVICE", "城市广告-服务页","AD_TAG"),
        //CITY_AD_APRTMENT("CITY_AD_APARTMENT", "城市广告-公寓列表页","AD_TAG"),

        //证件类型
        ID_CARD("0", "身份证", "CARD_TYPES"),
        PASSPORT("1", "护照", "CARD_TYPES"),
        ID_CARD_SOLDIER("2", "军人身份证", "CARD_TYPES"),
        SOCIAL_SECURITY_CARD("6", "社会保障卡", "CARD_TYPES"),
        ARMED_POLICE_ID_CARD("A", "武警身份证件", "CARD_TYPES"),
        HK_MACAO_PASSPORT("B", "港澳通行证", "CARD_TYPES"),
        TAIWAN_PASSPORT("C", "台湾居民来往大陆通行证", "CARD_TYPES"),
        HOUSEHOLD_REGISTER("E", "户口簿", "CARD_TYPES"),
        TEMPORARY_ID_CARD("F", "临时居民身份证", "CARD_TYPES"),
        POLICE_CARD("G", "警察(警官)证", "CARD_TYPES"),
        FOREIGN_CARD("P", "外国人永久居留证", "CARD_TYPES"),
        BUSINESS_CARD("3", "工商登记证", "CARD_TYPES"),
        TXT_CARD("4", "税务登记证", "CARD_TYPES"),
        ORGANIZATION_CARD("7", "组织机构代码证", "CARD_TYPES"),
        ENTERPRISE_LICENSE("8", "企业营业执照", "CARD_TYPES"),
        SOCIAL_TEAM_CARD("J", "社会团体登记证书", "CARD_TYPES"),
        NON_ENTERPRISE_CARD("K", "民办非企业登记证书", "CARD_TYPES"),
        FOREIGN_ENTERPRISE_CARD("L", "外国(地区)企业常驻代表机构登记证", "CARD_TYPES"),
        OTHERS("Z", "其他", "CARD_TYPES"),

        ;

        public String code;
        public String name;
        public String typeCode;

        DictionaryItem(String code, String name, String typeCode) {
            this.code = code;
            this.name = name;
            this.typeCode = typeCode;
        }

        public static List<DictionaryItem> getItemListByType(String typeCode) {
            List<DictionaryItem> list = new ArrayList<>();
            for (DictionaryItem dictionaryItem : DictionaryItem.values()) {
                if (typeCode.equals(dictionaryItem.typeCode)) {
                    list.add(dictionaryItem);
                }
            }

            return list;
        }
    }

    //短信模板
    public enum SmsTemplate {
        RentPromotion("HWorld", "RentPromotion", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您本月的房租、服务费账单已经产生，请打开公寓微信平台查看账单详情。", "房租服务费账单缴费提醒"),

        LockTenantPassword("HWorld", "LockTenantPassword", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "欢迎入住{0}，您的房间号{1}，您的门锁密码{2}。", "入住人智能门锁密码"),

        LockTemporaryPassword("HWorld", "LockTemporaryPassword", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您房间号为{0}的临时门锁密码为{1}，密码{2}分钟内有效。如有疑问请拨打公寓联系电话{3}。", "临时智能门锁密码"),

        WorkOrderDelegate("HWorld", "WorkOrderDelegate", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您收到一个派单了，{0}工单的编号，{1}执行工单的地点或区域", "派单通知"),

        WorkOrderUnFinished("HWorld", "WorkOrderUnFinished", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "你还有工单未完成，{0}工单的编号，{1}执行工单的地点或区域，{2}工单中的备注信息", "工单未完成提醒"),

        Register("HWorld", "Register", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "本次注册验证码：{0}(10分钟内有效)", "注册"),

        ForgetPassword("HWorld", "ForgetPassword", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "本次找回密码验证码：{0}(10分钟内有效)", "忘记密码"),

        UpdatePhoneNumber("HWorld", "UpdatePhoneNumber", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您修改手机号的验证码：{0}(10分钟内有效)", "修改手机号"),

        BindingMobilePhone("HWorld", "BindingMobilePhone", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您绑定手机号的验证码：{0}(10分钟内有效)", "绑定手机号验证码"),

        LockDynamicPassword("HWorld", "LockDynamicPassword", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您房间号为{0}的临时门锁密码为{1}，密码60分钟内有效。如有疑问请拨打公寓联系电话{2}。", "动态门锁密码"),

        DynamicLogin("HWorld", "DynamicLogin", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您动态登录的验证码：{0}(10分钟内有效)", "动态登录的验证码"),

        ReservationLookRoom("HWorld", "ReservationLookRoom", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您已预约成功！ 公寓：{0}，房间：{1}，请于{2}期间前往，地址：{3} 联系电话：{4}", "预约看房成功的短信通知"),

        ReservationRoom("HWorld", "ReservationRoom", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您已经成功预订：{0}，{1}，入住日期{2}，地址：{3}，联系电话：{4}", "预定房间成功的短信通知"),

        ElectronicContract("HWorld", "ElectronicContract", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "电子合同的验证码为{0} 10分钟内有效", "电子合同验证模板"),

        OrderPersonRetreat("HWorld", "OrderPersonRetreat", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "尊敬的会员：您已经成功从{0}房间退住，您的电子门锁密码已经失效。如有疑问请拨打公寓联系电话{1}。", "同住人退住短信通知"),

        OrderPersonNotice("HWorld", "OrderPersonNotice", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "尊敬的会员：欢迎您入住{0}，您的房间号为{1}。", "同住人短信通知模板"),

        BillGeneration("HWorld", "BillGeneration", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您本月的生活账单已经产生，请打开公寓微信平台查看账单详情。", "账单通知缴费提醒"),

        BillPayment("HWorld", "BillPayment", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "您有账单未付款，为了不影响您的继续入住，请尽快缴清。", "账单缴费提醒"),

        BillPaymentBigClass("HWorld", "BillPaymentBigClass", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "尊敬的{0}先生/女士，截止至{1}日，您在{2}有累计{3}元的生活账单/房费账单尚未支付，请及时缴费，谢谢。", "大类账单缴费提醒"),

        BillPaymentSmallClass("HWorld", "BillPaymentSmallClass", "APMS_SMS", "daa32800e6aa4c63b2d1c7660ff9422c", "尊敬的{0}先生/女士，截止至{1}日，您在{2}的第一期水费{3}元尚未支付，该账单最晚缴费日为{4}，请及时缴费，谢谢。", "小类账单缴费提醒"),
        ;

        public String smsPlatform;
        public String smsType;
        public String smsCode;
        public String encryptKey;
        public String smsContent;
        public String description;

        SmsTemplate(String smsPlatform, String smsType, String smsCode, String encryptKey, String smsContent, String description) {
            this.smsPlatform = smsPlatform;
            this.smsType = smsType;
            this.smsCode = smsCode;
            this.encryptKey = encryptKey;
            this.smsContent = smsContent;
            this.description = description;
        }

        public static List<SmsTemplate> getSmstemplateDemoList() {
            return Arrays.asList(SmsTemplate.values());
        }
    }

    //系统配置
    @Getter
    public enum SystemConfig {
        RentPromotion("URGE", "RentPromotion", "待催租显示", "4"),

        Interval("URGE", "Interval", "待催租间隔", "1"),

        WillExpire("EXPIRE", "WillExpire", "将到期显示", "30"),

        ExchangeHouses("EXCHANGE", "ExchangeHouses", "待换房显示", "4"),

        InitialPassword("USER", "InitialPassword", "用户初始密码", "apms@123456"),

        LockPasswordTime("DEVICE", "LockPasswordTime", "门锁临时密码有效时间(分钟)", "15"),

        ReservationDay("ORDER", "ReservationDay", "定金预订可延后天数", "60"),

        MaxMonth("SALESMANAGEMENT", "MaxMonth", "可选最大月数", "36"),

        BalancePay("BALANCE", "BalancePay", "余额支付", "[{\"apartmentId\":-1}]"),

        BookingWay("ORDER", "BookingWay", "预订方式", "1,2"),

        RepeatBooking("ORDER", "RepeatBooking", "允许会员重复预订", "1"),

        CancelOrderMinute("ORDER", "CancelOrderMinute", "自动取消订单时间（分钟）", "60"),

        ReservationFlag("ORDER", "ReservationFlag", "是否能预订", "1"),

        MinSplitAmount("ORDER", "MinSplitAmount", "最小拆分金额", "500"),

        OrderStartDateRule("ORDER", "OrderStartDateRule", "订单开始时间规则", "0,0"),

        TenantName("TENANT", "TenantName", "租户名称(公众号显示名称)", "盟寓"),

        SmsSwitch("COMMON", "SmsSwitch", "短信开关", "0"),

        SNightStartTime("SNIGHT", "SNightStartTime", "短租夜审开始时间", "0"),

        SNightEndTime("SNIGHT", "SNightEndTime", "短租夜审结束时间", "6"),

        /*SForceNight("SNIGHT", "SForceNight", "短租强制夜审间隔", "1"),*/

        SForceNightStartTime("SNIGHT", "SForceNightStartTime", "短租强制夜审开始时间", "6"),

        ShortOrderDays("ORDER", "ShortOrderDays", "最大入离时间（天数）", "30"),

        ShortOrderRoomCount("ORDER", "ShortOrderRoomCount", "最大间数设置", "5"),

        ShortOrderReletDays("ORDER", "ShortOrderReletDays", "续住最大时间范围", "15"),

        SHouseDayPriceQueryDays("SHOUSEPRICEDAY", "SDayPriceQueryDays", "每日房价查询天数", "10"),

        SDAYVOLUMEQUERYDAYS("SVOLUMEDAY", "SDayVolumeQueryDays", "每日房量查询天数", "10"),

        ALLOWSTOPRENTOVERDUE("ORDER", "allowStopRentOverDue", "允许逾期退款标志", "0");
        ;
        public String type;
        public String code;
        public String name;
        public String svalue;

        SystemConfig(String type, String code, String name, String svalue) {
            this.type = type;
            this.code = code;
            this.name = name;
            this.svalue = svalue;
        }

        public static List<SystemConfig> getSystemConfigDemoList() {
            return Arrays.asList(SystemConfig.values());
        }
    }

    //资源文件
    public enum FileResource {
        /*DEVICE_INPUT("faa204f2908b4eef8f7dbdeebaed15b9", "xlsx", "TEMPLATE", "设备导入模板", "device_input.xlsx",
                    "http://mgtest-file.obs.cn-east-2.myhuaweicloud.com/", "template/faa204f2908b4eef8f7dbdeebaed15b9.xlsx",TemplateResource.DEVICE_INPUT),

        METER_READING_TEMPLATE("fdc743ef44f84f8391ddd1e5f5eb5136", "xlsx", "TEMPLATE", "设备抄表模板", "meter_reading_template.xlsx",
                            "http://mgtest-file.obs.cn-east-2.myhuaweicloud.com/", "template/fdc743ef44f84f8391ddd1e5f5eb5136.xlsx",TemplateResource.METER_READING_TEMPLATE),

        BUSINESS_SUBJECT("ced6e75194f44f29a1c7e03cd102541a", "xlsx", "TEMPLATE", "营业科目", "business_subject.xlsx",
                        "http://mgtest-file.obs.cn-east-2.myhuaweicloud.com/", "template/ced6e75194f44f29a1c7e03cd102541a.xlsx",TemplateResource.BUSINESS_SUBJECT),

        ALLOWANCE_TEMPLATE("eee6b5c46d644e3089f4a150d7404edd", "xlsx", "TEMPLATE", "津贴模板", "allowance_template.xlsx",
                                "http://mgtest-file.obs.cn-east-2.myhuaweicloud.com/", "template/eee6b5c46d644e3089f4a150d7404edd.xlsx",TemplateResource.ALLOWANCE_TEMPLATE),

        TAX_TEMPLATE("fcd5a26ecdbe4100aa81514302a7161c", "xlsx", "TEMPLATE", "税率模板", "tax_template.xlsx",
                        "http://mgtest-file.obs.cn-east-2.myhuaweicloud.com/", "template/fcd5a26ecdbe4100aa81514302a7161c.xlsx",TemplateResource.TAX_TEMPLATE),

        ROOM_TEMPLATE("fdd828a2c9f5427bbafd37bc4cf81030", "xlsx", "TEMPLATE", "房间模板", "room_template.xlsx",
                        "http://mgtest-file.obs.cn-east-2.myhuaweicloud.com/", "template/fdd828a2c9f5427bbafd37bc4cf81030.xlsx",TemplateResource.ROOM_TEMPLATE),*/

        DEVICE_INPUT("faa204f2908b4eef8f7dbdeebaed15b9", "xlsx", "TEMPLATE", "设备导入模板", "device_input.xlsx",
                "https://mgprd-file.obs.cn-east-2.myhuaweicloud.com/", "template/template_device_input.xlsx", TemplateResource.DEVICE_INPUT),

        METER_READING_TEMPLATE("fdc743ef44f84f8391ddd1e5f5eb5136", "xlsx", "TEMPLATE", "设备抄表模板", "meter_reading_template.xlsx",
                "https://mgprd-file.obs.cn-east-2.myhuaweicloud.com/", "template/template_meter_reading.xlsx", TemplateResource.METER_READING_TEMPLATE),

        BUSINESS_SUBJECT("ced6e75194f44f29a1c7e03cd102541a", "xlsx", "TEMPLATE", "营业科目", "business_subject.xlsx",
                "https://mgprd-file.obs.cn-east-2.myhuaweicloud.com/", "template/template_business_subject.xlsx", TemplateResource.BUSINESS_SUBJECT),

        ALLOWANCE_TEMPLATE("eee6b5c46d644e3089f4a150d7404edd", "xlsx", "TEMPLATE", "津贴模板", "allowance_template.xlsx",
                "https://mgprd-file.obs.cn-east-2.myhuaweicloud.com/", "template/template_allowance.xlsx", TemplateResource.ALLOWANCE_TEMPLATE),

        TAX_TEMPLATE("fcd5a26ecdbe4100aa81514302a7161c", "xlsx", "TEMPLATE", "税率模板", "tax_template.xlsx",
                "https://mgprd-file.obs.cn-east-2.myhuaweicloud.com/", "template/template_tax.xlsx", TemplateResource.TAX_TEMPLATE),

        ROOM_TEMPLATE("fdd828a2c9f5427bbafd37bc4cf81030", "xlsx", "TEMPLATE", "房间模板", "room_template.xlsx",
                "https://mgprd-file.obs.cn-east-2.myhuaweicloud.com/", "template/template_room.xlsx", TemplateResource.ROOM_TEMPLATE),

        ;

        public String uid;
        public String fileType;
        public String bizType;
        public String description;
        public String fileName;
        public String url;
        public String fileUrl;
        public TemplateResource templateResource;

        FileResource(String uid, String fileType, String bizType, String description, String fileName, String url, String fileUrl, TemplateResource templateResource) {
            this.uid = uid;
            this.fileType = fileType;
            this.bizType = bizType;
            this.description = description;
            this.fileName = fileName;
            this.url = url;
            this.fileUrl = fileUrl;
            this.templateResource = templateResource;
        }

        public static List<FileResource> getFileResourceDemoList() {
            return Arrays.asList(FileResource.values());
        }
    }

    //模板文件
    public enum TemplateResource {
        DEVICE_INPUT("设备导入模板", "device_input", "设备导入模板"),

        METER_READING_TEMPLATE("水电读数导入模板", "meter_reading_template", "设备抄表模板"),

        BUSINESS_SUBJECT("营业科目导入模板", "business_subject", "营业科目"),

        ALLOWANCE_TEMPLATE("津贴导入模板", "allowance_template", "津贴模板"),

        TAX_TEMPLATE("税率导入模板", "tax_template", "税率模板"),

        ROOM_TEMPLATE("房间导入模板", "room_template", "房间模板"),
        ;

        public String name;
        public String templateCode;
        public String description;

        TemplateResource(String name, String templateCode, String description) {
            this.name = name;
            this.templateCode = templateCode;
            this.description = description;
        }

        public static List<TemplateResource> getTemplateResourceDemoList() {
            return Arrays.asList(TemplateResource.values());
        }
    }


    //营业项目类型
    public enum BusinessSubjectType {
        LIVEFEE("liveFee", "生活费账单", BusinessSubject.getBusinessSubjectDemoListByTypeCode("liveFee")),
        ROOMFEE("roomFee", "房费账单", BusinessSubject.getBusinessSubjectDemoListByTypeCode("roomFee")),
        OTHERFEE("otherFee", "其他账单费账单", BusinessSubject.getBusinessSubjectDemoListByTypeCode("otherFee")),
        REPAIRFEE("repairFee", "维修账单", BusinessSubject.getBusinessSubjectDemoListByTypeCode("repairFee")),
        ;

        public String code;
        public String name;
        public List<BusinessSubject> businessSubjectList;

        BusinessSubjectType(String code, String name, List<BusinessSubject> businessSubjectList) {
            this.code = code;
            this.name = name;
            this.businessSubjectList = businessSubjectList;
        }

        public static List<BusinessSubjectType> getBusinessSubjectTypeDemoList() {
            return Arrays.asList(BusinessSubjectType.values());
        }
    }

    //营业项目
    public enum BusinessSubject {
        EARNEST("定金", "10001", "roomFee", 1),
        DEPOSI("长租押金", "10002", "roomFee", 1),
        LONGSERVE("长租服务费", "10003", "roomFee", 1),
        LONGROOMRATE("长租房租", "10004", "roomFee", 1),
        SHORTSERVE("短租服务费", "10005", "roomFee", 2),
        SHORTLONGROOMRATE("短租房租", "10006", "roomFee", 2),
        LONGSERVE_INCOME("长租服务费收入", "10007", "roomFee", 1),
        LONGROOMRATE_INCOME("长租房租收入", "10008", "roomFee", 1),
        SHORTSERVE_INCOME("短租服务费收入", "10009", "roomFee", 2),
        SHORTLONGROOMRATE_INCOME("短租房租收入", "10010", "roomFee", 2),

        COLD_WATER("冷水费", "20001", "liveFee", 1),
        RECYCLED_WATER("中水费", "20002", "liveFee", 1),
        HOT_WATER("热水费", "20003", "liveFee", 1),
        ELECTRIC("电费", "20004", "liveFee", 1),
        GAS("天然气费", "20005", "liveFee", 1),
        HEATING_FEE("供暖费", "20006", "liveFee", 1),

        ARTICLESCOMPENSATION("物品赔偿费", "30001", "otherFee", 0),
        RENEGE("违约金", "30002", "otherFee", 0),
        TRANSFER("中转", "30003", "otherFee", 0),
        MAINTENANCE_COSTS("维修费用", "30004", "otherFee", 0),

        GOODS_REPAIR_FEE("物品维修费", "40001", "repairFee", 0),
        GOODS_REPLACE_FEE("物品更换费", "40002", "repairFee", 0),

        ;

        public String name;
        public String code;
        public String typeCode;
        public Integer rentType;

        BusinessSubject(String name, String code, String typeCode, Integer rentType) {
            this.name = name;
            this.code = code;
            this.typeCode = typeCode;
            this.rentType = rentType;
        }

        public static List<BusinessSubject> getBusinessSubjectDemoListByTypeCode(String typeCode) {
            List<BusinessSubject> list = new ArrayList<>();
            for (BusinessSubject businessSubject : BusinessSubject.values()) {
                if (typeCode.equals(businessSubject.typeCode)) {
                    list.add(businessSubject);
                }
            }

            return list;
        }


        public static List<BusinessSubject> getBusinessSubjectDemoList() {
            return Arrays.asList(BusinessSubject.values());
        }
    }

    //税率科目
    public enum TaxSubject {
        INITIAL("0000", "房费初始税率0", BigDecimal.ZERO, "房费初始税率0");;

        public String code;
        public String name;
        public BigDecimal tax;
        public String description;

        TaxSubject(String code, String name, BigDecimal tax, String description) {
            this.code = code;
            this.name = name;
            this.tax = tax;
            this.description = description;
        }

        public static List<TaxSubject> getTaxSubjectDemoList() {
            return Arrays.asList(TaxSubject.values());
        }
    }

    // 设备供应商
    public enum Vendor {
        JOYMETER("joymeter", "超仪", DeviceType.getDeviceTypeDemoListByVendorCode("joymeter")),
        DDING("dding", "云丁", DeviceType.getDeviceTypeDemoListByVendorCode("dding"));

        public String code;
        public String name;
        public List<DeviceType> deviceTypeList;

        Vendor(String code, String name, List<DeviceType> deviceTypeList) {
            this.code = code;
            this.name = name;
            this.deviceTypeList = deviceTypeList;
        }

        public static List<Vendor> getVendorDemoList() {
            return Arrays.asList(Vendor.values());
        }
    }


    // 设备类型
    public enum DeviceType {
        ELECTRIC("10", "电表", "20004", "电费 ", "joymeter"),
        COLD_WATER("20", "冷水表", "20001", "冷水费", "joymeter"),
        HOT_WATER("30", "热水表", "20003", "热水费", "joymeter"),
        RECLAIMED_WATER("40", "中水表", "20002", "中水费", "joymeter"),
        COAL_GAS("50", "煤气表", "20005", "天然气费", "joymeter"),
        DOOR_LOCK("60", "门锁", "", "", "dding"),
        ;

        public String code;
        public String name;
        public String bussnissSubjectCode;
        public String description;
        public String vendorCode;

        DeviceType(String code, String name, String bussnissSubjectCode, String description, String vendorCode) {
            this.code = code;
            this.name = name;
            this.bussnissSubjectCode = bussnissSubjectCode;
            this.description = description;
            this.vendorCode = vendorCode;
        }

        public static List<DeviceType> getDeviceTypeDemoListByVendorCode(String vendorCode) {
            List<DeviceType> list = new ArrayList<>();
            for (DeviceType deviceType : DeviceType.values()) {
                if (vendorCode.equals(deviceType.vendorCode)) {
                    list.add(deviceType);
                }
            }
            return list;
        }

        public static List<DeviceType> getDeviceTypeDemoList() {
            return Arrays.asList(DeviceType.values());
        }
    }


    /*public static void main(String[] args) {
        List<Vendor> aa = TenantInitConstant.Vendor.getVendorDemoList();

        List<Dictionary> bb = TenantInitConstant.Dictionary.getDictionaryDemoList();

        System.out.println(aa);
    }*/


    //角色权限对象
    @Data
    public static class RoleActionDemo {

        private Long menuId;

        private Long actionId;
    }


}
