package org.sample.ytech.common.usecase;

import org.sample.ytech.common.DomainComponent;
import org.sample.ytech.common.model.UseCase;

public class BeanAwareUseCasePublisher implements UseCasePublisher {

    @Override
    public <R, T extends UseCase> R publish(Class<R> returnClass, T useCase) {
        var useCaseHandler = (UseCaseHandler<R, T>) UseCaseHandlerRegistry.INSTANCE.detectUseCaseHandlerFrom(useCase.getClass());
        return useCaseHandler.handle(useCase);
    }

    @Override
    public <T extends UseCase> void publish(T useCase) {
        var voidUseCaseHandler = (VoidUseCaseHandler<T>) UseCaseHandlerRegistry.INSTANCE.detectVoidUseCaseHandlerFrom(useCase.getClass());
        voidUseCaseHandler.handle(useCase);
    }
}
