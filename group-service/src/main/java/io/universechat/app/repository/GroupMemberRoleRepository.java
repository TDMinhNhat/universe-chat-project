package io.universechat.app.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.GroupMemberRole;
import io.universechat.app.model.dto.GroupMemberRoleDto;
import reactor.core.publisher.Mono;

@Repository
public interface GroupMemberRoleRepository extends ReactorCrudRepository<GroupMemberRole, Long>, ReactorPageableRepository<GroupMemberRole, Long> {

    @Query("""
        select gmr from GroupMemberRole gmr
        where (:id is null or gmr.id = :id)
        and (:deleted is null or gmr.deleted = :deleted)
        and (:name is null or gmr.name like %:name%)
        and (:colorCode is null or gmr.colorCode like %:colorCode%)
        """)
    Mono<Page<GroupMemberRole>> getAllGroupMemberRolesByFilter(
            Long id,
            Boolean deleted,
            String name,
            String colorCode,
            Pageable pageable);

    default Mono<GroupMemberRole> findAndUpdate(Long id, GroupMemberRoleDto entity) {
        return this.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Member Role Not Found")))
                .flatMap(item -> {
                    item.setName(entity.getName());
                    item.setColorCode(entity.getColorCode());
                    item.setNote(entity.getNote());
                    return this.update(item);
                });
    }
}
