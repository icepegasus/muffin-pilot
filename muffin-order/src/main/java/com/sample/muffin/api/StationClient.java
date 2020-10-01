package com.sample.muffin.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.muffin.api.dto.Station;

@FeignClient(name = "station-service" , url = "http://localhost:8082")
public interface StationClient {
	@RequestMapping(method = RequestMethod.GET, value = "/stations")
	Page<Station> getStations(@RequestParam("page") Integer page, @RequestParam("size") Integer size);

	@RequestMapping(method = RequestMethod.GET, value = "/stations/{id}")
	Station findStation(@PathVariable("id") Long id);
}
