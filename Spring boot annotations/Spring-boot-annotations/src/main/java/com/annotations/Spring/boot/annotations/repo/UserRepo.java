package com.annotations.Spring.boot.annotations.repo;

import com.annotations.Spring.boot.annotations.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

//@Repository
@Component
public interface UserRepo extends CrudRepository<Users,Integer> {
}
