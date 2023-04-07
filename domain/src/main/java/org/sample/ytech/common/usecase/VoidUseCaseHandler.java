package org.sample.ytech.common.usecase;

import org.sample.ytech.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase>{
    void handle(T useCase);
}
