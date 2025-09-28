package io.universechat.app.model.dto;

import io.micronaut.data.model.Sort;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Serdeable
public record SortRequestDto(

        @NotNull(message = "can not be null or empty")
        String property,

        @NotNull(message = "can not be null or empty")
        @Pattern(regexp = "(ASC|DESC)", message = "must be either 'ASC' or 'DESC'")
        Sort.Order.Direction direction,

        @NotNull(message = "can not be null or empty")
        Boolean ignoreCase
) {

    public Sort.Order getOrder() {
        return new Sort.Order(property, direction, ignoreCase);
    }
}
