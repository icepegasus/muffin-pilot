package com.sample.muffin.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sample.muffin.domain.model.Member;

public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

}
