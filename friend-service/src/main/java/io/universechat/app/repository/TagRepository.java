package io.universechat.app.repository;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.Tag;
import io.universechat.app.model.dto.TagDto;
import io.universechat.app.model.qo.TagQo;
import reactor.core.publisher.Mono;

@Repository
public interface TagRepository extends ReactorCrudRepository<Tag, Long> {

    @Query(value = """
            select t from Tag t
            where (:#{#filter.id} is null or t.id = :#{#filter.id})
            and (:#{#filter.deleted} is null or t.deleted = :#{#filter.deleted})
            and (:#{#filter.createdAt} is null or t.createdAt >= :#{#filter.createdAt})
            and (:#{#filter.updatedAt} is null or t.updatedAt <= :#{#filter.updatedAt})
            and (:#{#filter.code} is null or t.code like %:#{#filter.code}%)
            and (:#{#filter.name} is null or t.name like %:#{#filter.name}%)
            order by t.name asc
        """)
    Mono<Page<Tag>> getAllTagsByFilter(@Parameter(value = "filter") TagQo filter, Pageable pageable);

    default Mono<Tag> updateTag(Long tagId, TagDto tag) {
        return this.findById(tagId).switchIfEmpty(Mono.error(new QueryNotFoundException("Tag not found"))).flatMap(existingTag -> {
            existingTag.setCode(tag.getCode());
            existingTag.setName(tag.getName());
            existingTag.setNote(tag.getNote());
            return Mono.from(this.update(existingTag));
        });
    }
}
