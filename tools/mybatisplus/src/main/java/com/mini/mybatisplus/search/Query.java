package com.mini.mybatisplus.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(description = "查询条件")
public class Query {
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private Integer size;

    /**
     * 排序的字段名
     */
    @ApiModelProperty(hidden = true)
    private String asc;

    /**
     * 排序方式
     */
    @ApiModelProperty(hidden = true)
    private String desc;
}
