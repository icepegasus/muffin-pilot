package com.sample.muffin.domain.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sample.muffin.domain.model.Member;

@RepositoryRestResource
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {

}
