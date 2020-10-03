package com.sample.muffin.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.muffin.api.dto.Member;

@FeignClient(name = "member-service", url="http://member-svc:8080")
public interface MemberClient {
	@RequestMapping(method = RequestMethod.GET, value = "/members")
	Page<Member> getMembers(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

	@RequestMapping(method = RequestMethod.GET, value = "/members/{id}")
	Member findMember(@PathVariable("id") Long id);
}
