package com.wangyonglin.restul.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

import lombok.ToString;

@Data
@ToString

public class Person {

	@Id
	private String id;
	private String name;
	private String document;
	private Integer age;

}