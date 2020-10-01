package com.sample.muffin.domain.model;

import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent{

    private String stateMessage = "주유주문 발생함";

    private Long orderId;
    private Long memberId;
	private String memberName;
	private String memberCarNo;
	private Long StationId;
	private String StationName;
	private int price;
	private OilCdType oilCdType;
	private String orderState="OrderPlaced";

    public OrderPlaced(){
        super();
    }

}
