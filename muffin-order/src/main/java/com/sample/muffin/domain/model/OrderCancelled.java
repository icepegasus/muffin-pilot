package com.sample.muffin.domain.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Data
public class OrderCancelled extends AbstractEvent{

    private String stateMessage = "주유주문 취소함";

    private Long orderId;
    private Long memberId;
	private String memberName;
	private String memberCarNo;
	private Long StationId;
	private String StationName;
	private int price;
	private OilCdType oilCdType;
	private String orderState="OrderPlaced";

    public OrderCancelled(){
        super();
    }

    public OrderCancelled(Order order){
        this();
        this.setOrderId(order.getId());
        this.setMemberId(order.getMemberId());
        this.setMemberCarNo(order.getMemberCarNo());
        this.setMemberName(order.getMemberName());
        this.setOilCdType(order.getOilCdType());
        this.setStationId(order.getStationId());
        this.setStationName(order.getStationName());
        this.setPrice(order.getPrice());
    }


}
