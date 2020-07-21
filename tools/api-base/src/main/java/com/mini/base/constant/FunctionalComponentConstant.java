package com.mini.base.constant;

/**
 * 功能组件相关常量类
 *
 */
public class FunctionalComponentConstant {


    //功能组件
    public enum FunctionalComponent {
        Order_BillGenerationRules("BillGenerationRules", "账单生成规则"),
        ;

        public String code;
        public String name;

        FunctionalComponent(String code, String name) {
            this.code = code;
            this.name = name;
        }
    }

    //账单生成规则值
    public enum FunctionalComponentValue {

        NaturalMonth_Diff (1, "自然月-有差额"),
        NaturalMonth_NoDiff (2, "自然月-无差额"),
        ;

        public Integer type;
        public String value;

        FunctionalComponentValue(Integer type, String value) {
            this.type = type;
            this.value = value;
        }
    }


}
