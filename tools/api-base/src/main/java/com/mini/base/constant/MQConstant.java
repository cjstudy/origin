package com.mini.base.constant;

public interface MQConstant {
    // 夜审
    //String MQ_MONTH_APPROVE = "apms.month.approve";
    String SAAS_MONTH_QUEUE = "saas.month.queue";
    String SAAS_MONTH_EXCHANGE = "saas.month.exchange";
    String SAAS_MONTH_KEY = "saas.month.*";
    //物品物业结算
    //String MQ_CONFIRM_METERREADINGANDGOODS = "apms.confirm.meterReadingAndGoods";
    String SAAS_CONFIRM_QUEUE = "saas.confirm.queue";
    String SAAS_CONFIRM_EXCHANGE = "saas.confirm.exchange";
    String SAAS_CONFIRM_KEY = "saas.confirm.*";

    //测试消息队列
    String SAAS_TEST_QUEUE = "saas.test.queue";
    String SAAS_TEST_EXCHANGE = "saas.test.exchange";
    String SAAS_TEST_KEY = "saas.test.*";

    // 月审
    //String MQ_MONTH_APPROVE = "oms.month.approve";
    String OMS_MONTH_QUEUE = "oms.month.queue";
    String OMS_MONTH_EXCHANGE = "oms.month.exchange";
    String OMS_MONTH_KEY = "oms.month.*";
}
