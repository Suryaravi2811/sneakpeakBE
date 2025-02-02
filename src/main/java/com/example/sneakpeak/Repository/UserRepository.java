package com.example.sneakpeak.Repository;

import com.example.sneakpeak.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findOneByEmailIgnoreCaseAndPassword(String email, String password);
}
