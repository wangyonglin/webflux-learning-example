package com.wangyonglin.restful.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.wangyonglin.restful.entity.Person;
import org.springframework.context.annotation.Primary;
@Repository
@Primary
public interface PersonRepository extends ReactiveMongoRepository<Person, String> {

}
