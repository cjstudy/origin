package com.mini.mybatisplus.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.mini.base.constant.PmsConstant;
import com.mini.base.utils.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体属性类
 *
 * @author root
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -4342642249391616456L;
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
//    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 0:生效,1:失效
     */
//    @ApiModelProperty(value = "业务状态")
    @TableField(fill = FieldFill.INSERT)
    private String status = PmsConstant.STATUS_ENABLE;

//    @ApiModelProperty(value = "是否已删除")
    @TableField(value = "is_delete", fill = FieldFill.INSERT)
    private int isDelete = 0;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
//    @ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.INSERT)
//    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
//    @ApiModelProperty(value = "更新人")
    private String updateUser;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @TableField(fill = FieldFill.INSERT_UPDATE)
//    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime = LocalDateTime.now();

}
