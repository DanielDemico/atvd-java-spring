package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.model.UserModel;

public interface userRepo extends CrudRepository<UserModel, Long> {

    
}