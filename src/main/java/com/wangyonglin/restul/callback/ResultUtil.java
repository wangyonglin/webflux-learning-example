package com.wangyonglin.restul.callback;


import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.reactive.function.server.ServerRequest;

public class ResultUtil {

    public static Mono<ServerResponse> success(ServerRequest request, java.lang.Object producer,
            java.lang.Class<?> elementClass) {
        ResultObject resultObject = ResultObject.success(0, producer);
        return ServerResponse.ok().body(Mono.just(resultObject), ResultObject.class);
    }

    public static Mono<ServerResponse> success(ServerRequest request, Mono<ResultObject> resultObject) {
        return ServerResponse.ok().body(resultObject, ResultObject.class);
    }

    public static Mono<Void> failure(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse response = exchange.getResponse();
        ResultObject resultObject = ResultObject.failure(response.getStatusCode().value(), ex.getMessage());
        DataBuffer dataBuffer = response.bufferFactory()
                .allocateBuffer().write(JSONObject.toJSONString(resultObject).getBytes());
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeAndFlushWith(Mono.just(ByteBufMono.just(dataBuffer)));

    }
}