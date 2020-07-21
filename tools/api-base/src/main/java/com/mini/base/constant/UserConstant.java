package com.mini.base.constant;

import com.mini.base.api.IResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LIUDONGFANG002
 * @version 1.0
 * @date 2019/5/12
 */
public class UserConstant {
    /**************权限相关**********************/

    //权限类型
    public enum UserOrganizationApartmentType {
        ORGANIZATION_TYPE(1, "组织"),
        APARTMENT_TYPE(2, "公寓");

        public Integer type;
        public String name;

        UserOrganizationApartmentType(Integer type, String name) {
            this.type = type;
            this.name = name;
        }

        public Integer type() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }
    }

    //权限类型
    public enum UserStatus {
        INCUMBENT(0, "在职"),
        DIMISSION(1, "离职");

        public Integer status;
        public String name;

        UserStatus(Integer status, String name) {
            this.status = status;
            this.name = name;
        }

        public Integer getStatus() {
            return this.status;
        }

        public String getName() {
            return this.name;
        }
    }


    /**
     * 字典响应码（15开头）
     */
    @Getter
    @AllArgsConstructor
    public enum ResultCode implements IResultCode {
        USER_ACCOUNT_EXISTS(1501, "账号已存在"),
        ROLE_NAME_EXISTS(1511, "角色名称已存在");

        private int code;

        private String message;
    }

}

