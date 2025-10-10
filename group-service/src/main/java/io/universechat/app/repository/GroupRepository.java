package io.universechat.app.repository;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.Group;
import io.universechat.app.model.dto.GroupDto;
import reactor.core.publisher.Mono;

@Repository
public interface GroupRepository extends ReactorCrudRepository<Group, Long>, ReactorPageableRepository<Group, Long> {

    @Query("""
        select g from Group g
        where (:id is null or g.id = :id)
        and (:title is null or g.title like %:title%)
        and (:ownerId is null or g.ownerId = :ownerId)
        and (:deleted is null or g.deleted = :deleted)
        """)
    Mono<Page<Group>> getAllGroupsByFilter(@Parameter("title") String title,
                                           @Parameter("ownerId") Long ownerId,
                                           @Parameter("id") Long id,
                                           @Parameter("deleted") Boolean deleted,
                                           Pageable pageable);

    default Mono<Group> findAndUpdate(Long id, GroupDto group) {
        return findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group not found")))
                .mapNotNull(target -> {
                    target.setTitle(group.getTitle());
                    target.setDescription(group.getDescription());
                    target.setOwnerId(group.getOwnerId());
                    return target;
                }).flatMap(this::save);
    }
}
