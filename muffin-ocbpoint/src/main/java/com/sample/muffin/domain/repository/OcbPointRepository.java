package com.sample.muffin.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sample.muffin.domain.model.OcbPoint;

public interface OcbPointRepository extends PagingAndSortingRepository<OcbPoint, Long> {

}
