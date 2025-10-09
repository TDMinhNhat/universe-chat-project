package io.universechat.app.core.model.qo;

import io.micronaut.data.model.Sort;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Serdeable
@Data
public abstract class PageRequestQo {

    @NotNull(message = "can not be null or empty")
    @PositiveOrZero(message = "must be positive or zero")
    private Integer page;

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be positive")
    private Integer size;

    @NotNull(message = "can not be null or empty")
    private String property;

    @NotNull(message = "can not be null or empty")
    @Pattern(regexp = "(ASC|DESC)", message = "must be either 'ASC' or 'DESC'")
    private String direction;

    private Boolean ignoreCase;

    public Sort.Order getOrder() {
        return new Sort.Order(property, Sort.Order.Direction.valueOf(direction), ignoreCase);
    }
}
