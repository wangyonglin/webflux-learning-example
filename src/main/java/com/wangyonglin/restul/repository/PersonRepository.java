package com.wangyonglin.restul.repository;

import com.wangyonglin.restul.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import org.springframework.context.annotation.Primary;
@Repository
@Primary
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

}
