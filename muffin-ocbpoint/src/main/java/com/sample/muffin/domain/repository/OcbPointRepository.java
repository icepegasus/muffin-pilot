package com.sample.muffin.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sample.muffin.domain.model.OcbPoint;

public interface OcbPointRepository extends PagingAndSortingRepository<OcbPoint, Long> {
	
	Optional<OcbPoint> findByMemberId(@Param("memberId") Long memberId);

}
