package xfxpositions.LogoLibrary.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xfxpositions.LogoLibrary.model.User;
import xfxpositions.LogoLibrary.repository.UserRepository;
import xfxpositions.LogoLibrary.utils.UserDetailsService;

@RestController
public class UserController {
    @Autowired
    public UserRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/api/user/register")
    public String registerResponse(@RequestBody User user){
        repository.save(user);
        return "User registered with " + user.getId();
    }
}
