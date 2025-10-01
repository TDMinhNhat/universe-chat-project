package io.universechat.app.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.universechat.app.core.controller.IController;
import io.universechat.app.model.dto.TagDto;
import io.universechat.app.model.qo.TagQo;
import io.universechat.app.service.ITagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/api/v1/tags")
@RequiredArgsConstructor
public class TagRepository implements IController<TagDto, Long, TagQo> {

    private final ITagService tagService;

    @Post(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> add(@Valid @Body TagDto entity) throws Exception {
        return tagService.add(entity);
    }

    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> update(@PathVariable("id") Long id, @Body TagDto entity) throws Exception {
        return tagService.update(id, entity);
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> delete(@PathVariable("id") Long id) throws Exception {
        return tagService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> getById(@PathVariable("id") Long id) throws Exception {
        return tagService.getById(id);
    }

    @Post(value = "/get-list", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<?> getAll(@Valid @Body TagQo filter) throws Exception {
        return tagService.getAll(filter);
    }
}
