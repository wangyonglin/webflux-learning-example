package com.wangyonglin.restul.error;




import com.wangyonglin.restul.callback.ResultUtil;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(-1)
public class GlobalExceptionConfiguration implements ErrorWebExceptionHandler {
  
  @Override
  public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
      return ResultUtil.failure(exchange, ex);
  }
}