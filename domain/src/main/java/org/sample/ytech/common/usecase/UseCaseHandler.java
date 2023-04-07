package org.sample.ytech.common.usecase;

import org.sample.ytech.common.model.UseCase;

public interface UseCaseHandler <R, T extends UseCase> {
    R handle(T useCase);
}
