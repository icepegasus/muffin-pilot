package com.sample.muffin.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode
public abstract class AbstractEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;

	public Long getId() {
		return id;
	}
}