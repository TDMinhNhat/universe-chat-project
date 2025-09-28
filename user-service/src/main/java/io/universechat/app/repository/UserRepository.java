package io.universechat.app.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.entity.User;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactorCrudRepository<User, Long>, ReactorPageableRepository<User, Long> {

    @Query(value = """
            select u from User u
            where (:#{#filter.id} is null or u.id = :#{#filter.id})
            and (:#{#filter.deleted} is null or u.deleted = :#{#filter.deleted})
            and (:#{#filter.createdAt} is null or u.createdAt >= :#{#filter.createdAt})
            and (:#{#filter.updatedAt} is null or u.updatedAt >= :#{#filter.updatedAt})
            and (:#{#filter.createdBy} is null or u.createdBy = :#{#filter.createdBy})
            and (:#{#filter.updatedBy} is null or u.updatedBy = :#{#filter.updatedBy})
            and (:#{#filter.userId} is null or u.userId = :#{#filter.userId})
            and (:#{#filter.fullName} is null or u.fullName like %:#{#filter.fullName}%)
            and (:#{#filter.sex} is null or u.sex = :#{#filter.sex})
            and (:#{#filter.birthDate} is null or u.birthDate = :#{#filter.birthDate})
            and (:#{#filter.phone} is null or u.phone = :#{#filter.phone})
            and (:#{#filter.username} is null or u.username = :#{#filter.username})
            and (:#{#filter.email} is null or u.email = :#{#filter.email})
            and (:#{#filter.verified} is null or u.verified = :#{#filter.verified})
        """)
    Mono<Page<User>> getAllUsersByFilter(UserQo filter, Pageable pageable);

    default Mono<User> findByIdAndUpdate(Long id, CreateUserDto dto) {
        return findById(id).switchIfEmpty(Mono.error(new RuntimeException("User not found"))).flatMap(user -> {
            user.setFullName(dto.getFullName());
            user.setSex(dto.getSex());
            user.setBirthDate(dto.getBirthDate());
            user.setPhone(dto.getPhone());
            user.setAddress(dto.getAddress());
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            return update(user);
        });
    }
}
