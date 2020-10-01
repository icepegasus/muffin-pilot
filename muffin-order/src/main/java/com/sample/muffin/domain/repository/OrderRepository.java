package com.sample.muffin.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sample.muffin.domain.model.Order;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}
