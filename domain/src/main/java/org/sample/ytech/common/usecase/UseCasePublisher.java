package org.sample.ytech.common.usecase;

import org.sample.ytech.common.model.UseCase;

public interface UseCasePublisher {

    <R, T extends UseCase> R publish(Class<R> returnClass, T useCase);

    <T extends UseCase> void publish(T useCase);
}
