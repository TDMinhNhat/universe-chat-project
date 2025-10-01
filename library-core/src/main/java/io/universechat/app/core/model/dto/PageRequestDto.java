package io.universechat.app.core.model.dto;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Sort;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Serdeable
public record PageRequestDto(

        @NotNull(message = "can not be null or empty")
        @PositiveOrZero(message = "must be positive or zero")
        Integer page,

        @NotNull(message = "can not be null or empty")
        @Positive(message = "must be positive")
        Integer size,

        List<SortRequestDto> sorts
) {

    public Sort getSort() {
        return Sort.of(this.sorts == null || this.sorts.isEmpty() ? null : sorts.stream().map(SortRequestDto::getOrder).toList());
    }

    public Pageable getPageable() {
        return Pageable.from(page, size, getSort());
    }

}
