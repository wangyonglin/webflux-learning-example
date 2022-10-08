package com.wangyonglin.restful.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.wangyonglin.restful.handler.PersonHandler;

@Configuration
public class PersonRoutes{
    @Bean
    @Autowired
    public RouterFunction<ServerResponse>  PersonRoutesFunction(PersonHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/hello/create")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        handler::create)
                .andRoute(RequestPredicates.GET("/hello/all")
                               .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                       handler::all);


    }
}