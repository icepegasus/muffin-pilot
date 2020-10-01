package com.sample.muffin.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sample.muffin.domain.model.Station;

public interface StationRepository extends PagingAndSortingRepository<Station, Long> {

}
