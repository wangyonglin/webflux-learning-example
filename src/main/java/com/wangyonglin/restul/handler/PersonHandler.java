package com.wangyonglin.restul.handler;

import com.wangyonglin.restul.entity.Person;
import com.wangyonglin.restul.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Component

public class PersonHandler {
    // private static final Logger log =
    // LoggerFactory.getLogger(HelloHandler.class);
    // private static Sort DatetimeDesc= new Sort(Sort.Order.desc("Datetime"));
    //  return productRepository.findById(id).switchIfEmpty(Mono.error(new ProductNotFoundException(id)));
    @Autowired
    private  PersonRepository repository;

    public PersonHandler(PersonRepository repository){
        this.repository=repository;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Person> personMono = request.bodyToMono(Person.class);
        Flux<Person> personMono1 = repository.insert(personMono);
        return ServerResponse.ok().contentType(APPLICATION_JSON)
                .body(personMono1,Person.class);


    }




    public Mono<ServerResponse> all(ServerRequest request) {
        Flux<Person> persons = repository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(persons, Person.class);
    }

}
