package xfxpositions.LogoLibrary.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import xfxpositions.LogoLibrary.model.Book;
import xfxpositions.LogoLibrary.model.User;
import xfxpositions.LogoLibrary.repository.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    public UserRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    private Map<String, String> users = new HashMap<>();
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        users.put("yusufkaraca", passwordEncoder.encode("123"));
    }

    public User getUser(String username){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(username));
        return mongoTemplate.findOne(query, xfxpositions.LogoLibrary.model.User.class);
    }




    public User DetailUser(String username){
        return getUser(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (users.containsKey(username)) {
            return new org.springframework.security.core.userdetails.User(username, getUser(username).getPassword(), new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);
    }
}