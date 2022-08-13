package xfxpositions.LogoLibrary.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import xfxpositions.LogoLibrary.model.User;

public interface UserRepository extends MongoRepository<User,Integer> {

}
