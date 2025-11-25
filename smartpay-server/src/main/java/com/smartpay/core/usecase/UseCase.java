package com.smartpay.core.usecase;

import reactor.core.publisher.Mono;

public interface UseCase<I extends UseCase.Request, O extends UseCase.Response> {

    interface Request{

    }
    interface Response{

    }

    Mono<O> execute(I request);
}
