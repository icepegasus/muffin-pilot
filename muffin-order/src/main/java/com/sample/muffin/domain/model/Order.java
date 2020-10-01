package com.sample.muffin.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Data;

@Data
@Entity
@Table(name = "order_table")
public class Order extends AbstractEntity{
	
	private Long memberId;
	private String memberName;
	private String memberCarNo;
	private Long StationId;
	private String StationName;
	private int price;
	@Enumerated(EnumType.STRING)
	private OilCdType oilCdType;
	private String orderState="OrderPlaced";
	
	
	/**
     * 주유예약주문 들어옴
     */
    @PostPersist
    @ExceptionHandler(OrderException.class)
    private void publishOrderPlaced(){
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publish();
    }
	
	
	
}
