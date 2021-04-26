package com.enjoy.springcloud.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author hk417
 * @date Created in 2021/4/16 11:43
 * @description
 */
@Alias("PaymentInfo")
@ApiModel("支付信息")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentInfo implements Serializable {

    @ApiModelProperty("订单编号")
    private Long id;

    @ApiModelProperty("交易流水")
    private String tradeNo;

}
