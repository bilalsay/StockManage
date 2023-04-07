package org.sample.ytech.common.usecase;

import org.sample.ytech.common.model.UseCase;

public class ObservableUseCasePublisher {

    public <R, T extends UseCase> void register(Class<T> useCaseClass, UseCaseHandler<R, T> useCaseHandler) {
        UseCaseHandlerRegistry.INSTANCE.register(useCaseClass, useCaseHandler);
    }

    public <T extends UseCase> void register(Class<T> useCaseClass, VoidUseCaseHandler<T> voidUseCaseHandler) {
        UseCaseHandlerRegistry.INSTANCE.register(useCaseClass, voidUseCaseHandler);
    }
}
