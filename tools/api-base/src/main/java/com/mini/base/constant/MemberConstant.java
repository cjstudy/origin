package com.mini.base.constant;

import com.mini.base.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 会员常量
 *
 * @author Caesar Liu
 * @date 2019/5/6 19:47
 */
public interface MemberConstant {

    /**
     * 会员响应码（11开头）
     *
     * @author Caesar Liu
     * @date 2019/5/10 15:13
     */
    @Getter
    @AllArgsConstructor
    enum ResultCode implements IResultCode {
        MEMBER_NAME_EXISTS(1101, "会员名称已存在"),
        MEMBER_PHONE_EXISTS(1102, "会员手机号已被使用"),
        ;

        private int code;

        private String message;
    }


    //会员性别
    enum MemberSex {
        MALE(0, "女"),
        FEMALE(1, "男"),
        SECRECY(2, "保密");

        public Integer type;
        public String name;

        MemberSex(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public static String getMemberSexByType(Integer type) {
            if (type == null) {
                return null;
            }
            for (MemberSex memberSex : MemberSex.values()) {
                if (memberSex.type.equals(type)) {
                    return memberSex.name;
                }
            }
            return null;
        }
    }

    @Getter
    enum IsAr {
        //是否支持ar
        YES(0, "支持"),
        NO(1, "不支持");

        private Integer val;

        private String name;

        IsAr(Integer val, String name) {
            this.val = val;
            this.name = name;
        }
    }

    @Getter
    enum OpenType {
        MG_SAAS(1, "盟广saas"),
        WECHAT(2, "微信");

        private Integer type;

        private String name;

        OpenType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

    // 法大大证件类型
    public enum FDDIDTypes{
        ID_CARD("0", "身份证"),
        PASSPORT("1", "护照"),
        ID_CARD_SOLDIER("2", "军人身份证"),
        SOCIAL_SECURITY_CARD("6", "社会保障卡"),
        ARMED_POLICE_ID_CARD("A", "武警身份证件"),
        HK_MACAO_PASSPORT("B", "港澳通行证"),
        TAIWAN_PASSPORT("C", "台湾居民来往大陆通行证"),
        HOUSEHOLD_REGISTER("E", "户口簿"),
        TEMPORARY_ID_CARD("F", "临时居民身份证"),
        POLICE_CARD("G", "警察(警官)证"),
        FOREIGN_CARD("P", "外国人永久居留证"),
        BUSINESS_CARD("3", "工商登记证"),
        TXT_CARD("4", "税务登记证"),
        ORGANIZATION_CARD("7", "组织机构代码证"),
        ENTERPRISE_LICENSE("8", "企业营业执照"),
        SOCIAL_TEAM_CARD("J", "社会团体登记证书"),
        NON_ENTERPRISE_CARD("K", "民办非企业登记证书"),
        FOREIGN_ENTERPRISE_CARD("L", "外国(地区)企业常驻代表机构登记证"),
        OTHERS("Z", "其他"),
        ;

        private String code;

        private String name;

        FDDIDTypes(String code, String name){
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static String getNameByCode(String code) {
            if (code == null) {
                return null;
            }
            for (FDDIDTypes fddidTypes : FDDIDTypes.values()) {
                if (fddidTypes.code.equals(code)) {
                    return fddidTypes.name;
                }
            }
            return null;
        }
    }


    public enum authentication_status{ //验证状态
        PASSMOBILE("1"),//号码通过，法大大视为手机验证通过(验证手机号后更新为此状态)
        PASSSIGN("2"),//电子签名通过，法大大视为身份认证通过(合同模板填充后更新为此状态)
        PASSSEAL("3");//添加印章通过，法大大视为合同归档完成(归档后更新为此状态)

        public String bizType;

        authentication_status(String bizType){
            this.bizType = bizType;
        }
        public String status(){
            return this.bizType;
        }
    }

    @Getter
    enum AccountType {
        //是否支持ar
        person(1, "个人"),
        business(2, "企业");

        private Integer type;

        private String name;

        AccountType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }
    }

}
