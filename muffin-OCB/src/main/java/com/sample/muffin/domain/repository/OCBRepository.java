package com.sample.muffin.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sample.muffin.domain.model.OCB;

public interface OCBRepository extends PagingAndSortingRepository<OCB, Long> {

}
