package com.dumbos.medmate.Repository;

import com.dumbos.medmate.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Custom query methods can be added here if needed
    // Example: findByEmail
    User findByEmail(String email);
}
