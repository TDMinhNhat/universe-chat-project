package io.universechat.app.service.impl;

import io.micronaut.data.model.Slice;
import io.universechat.app.entity.Tag;
import io.universechat.app.mapper.TagMapper;
import io.universechat.app.model.dto.TagDto;
import io.universechat.app.model.qo.TagQo;
import io.universechat.app.repository.TagRepository;
import io.universechat.app.service.ITagService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class TagServiceImpl implements ITagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public Mono<?> add(TagDto entity) throws Exception {
        return tagRepository.save(tagMapper.toTag(entity));
    }

    @Override
    public Mono<?> update(Long id, TagDto entity) throws Exception {
        return tagRepository.updateTag(id, entity);
    }

    @Override
    public Mono<?> delete(Long id) throws Exception {
        return tagRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Tag not found")))
                .flatMap(existingTag -> tagRepository.deleteById(existingTag.getId()).thenReturn(existingTag));
    }

    @Override
    public Mono<?> getById(Long id) throws Exception {
        return tagRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Tag not found")));
    }

    @Override
    public Flux<?> getAll(TagQo filter) throws Exception {
        return tagRepository.getAllTagsByFilter(filter, filter.getPageRequest().getPageable())
                .map(Slice::getContent).flux();
    }
}
