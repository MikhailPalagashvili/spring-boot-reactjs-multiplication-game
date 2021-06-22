package com.grantcs.springbootreactjsmultiplicationgame.repository;

import java.util.List;
import java.util.Optional;

import com.grantcs.springbootreactjsmultiplicationgame.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByAlias(final String alias);

    List<User> findAllByIdIn(final List<Long> ids);

}