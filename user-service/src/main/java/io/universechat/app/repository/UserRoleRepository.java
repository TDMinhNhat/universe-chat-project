package io.universechat.app.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.UserRole;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.dto.CreateUserRoleDto;
import io.universechat.app.model.qo.UserRoleQo;
import reactor.core.publisher.Mono;

@Repository
public interface UserRoleRepository extends ReactorCrudRepository<UserRole, Long>, ReactorPageableRepository<UserRole, Long> {

    @Query(value = """
            select ur from UserRole ur
            where (:#{#filter.id} is null or ur.id = :#{#filter.id})
            and (:#{#filter.code} is null or ur.code = :#{#filter.code})
            and (:#{#filter.name} is null or ur.name like %:#{#filter.name}%)
            and (:#{#filter.deleted} is null or ur.deleted = :#{#filter.deleted})
            and (:#{#filter.createdAt} is null or ur.createdAt >= :#{#filter.createdAt})
            and (:#{#filter.updatedAt} is null or ur.updatedAt >= :#{#filter.updatedAt})
        """)
    Mono<Page<UserRole>> getALlUserRoles(UserRoleQo filter, Pageable pageable);

    default Mono<UserRole> findByIdAndUpdate(Long id, CreateUserRoleDto dto) {
        return findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("UserRole not found"))).flatMap(userRole -> {;
            userRole.setCode(dto.getCode());
            userRole.setName(dto.getName());
            userRole.setNote(dto.getNote());
            return update(userRole);
        });
    }
}
