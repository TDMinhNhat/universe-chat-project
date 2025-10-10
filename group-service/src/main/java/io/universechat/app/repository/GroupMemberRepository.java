package io.universechat.app.repository;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.entity.GroupMember;
import io.universechat.app.entity.GroupMemberRole;
import io.universechat.app.enums.GroupMemberStatus;
import reactor.core.publisher.Mono;

@Repository
public interface GroupMemberRepository extends ReactorCrudRepository<GroupMember, Long>, ReactorPageableRepository<GroupMember, Long> {

    @Query("""
            select gm from GroupMember gm
            where (:groupId is null or gm.group.id =: groupId)
               and (:userId is null or gm.userId =: userId)
                 and (:role is null or gm.role =: role)
                 and (:status is null or gm.status =: status)
                 and (:id is null or gm.id =: id)
                 and (:deleted is null or gm.deleted =: deleted)
            """)
    Mono<Page<GroupMember>> getAllGroupMembersByFilter(
            @Parameter("groupId") Long groupId,
            @Parameter("userId") Long userId,
            @Parameter("role") GroupMemberRole role,
            @Parameter("status")GroupMemberStatus status,
            @Parameter("id") Long id,
            @Parameter("deleted") Boolean deleted,
            Pageable pageable);
}
