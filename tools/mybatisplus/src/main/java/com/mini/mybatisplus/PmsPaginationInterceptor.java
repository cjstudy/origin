package com.mini.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shixinfeng
 * @version 1.0
 * @date 2019/6/21 11:19
 */
@Configuration
public class PmsPaginationInterceptor {

//    @Autowired
//    private ApiContext apiContext;

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

//        List<ISqlParser> sqlParserList = new ArrayList<>();
//        TenantSqlParser tenantSqlParser = new TenantSqlParser();
//        tenantSqlParser.setTenantHandler(new TenantHandler() {
//
////            @Override
////            public Expression getTenantId() {
////                return new LongValue(apiContext.getLoginUserInfo().getTenantId());
////            }
//
//            @Override
//            public Expression getTenantId(boolean where) {
//                return null;
//            }
//
//            @Override
//            public String getTenantIdColumn() {
//                return "tenant_id";
//            }
//
//            @Override
//            public boolean doTableFilter(String tableName) {
//                String name = MyBatisConstant.FilterTenantIdTable.AREA.name;
//                // 这里可以判断是否过滤表
//                if (Objects.isNull(apiContext) || Objects.isNull(apiContext.getLoginUserInfo()) ||  MyBatisConstant.FilterTenantIdTable.getTableNames().contains(tableName)) {
//                    return true;
//                }
//                LoginUserDto userInfo = apiContext.getLoginUserInfo();
//                if (Objects.isNull(userInfo.getTenantId())) {
//                    return true;
//                }
//                return false;
//            }
//        });
//
//        sqlParserList.add(tenantSqlParser);
//        paginationInterceptor.setSqlParserList(sqlParserList);

        return paginationInterceptor;
    }
}
