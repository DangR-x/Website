package xiongjunmiao.top.Website.server;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by J on 2020/5/15 14:53
 */
@Service
public class MongoDBService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User save(User user){
        User save = mongoTemplate.save(user);
        return save;
    }

    public void removeByname(String name){
        mongoTemplate.remove(name);

    }

    public User findByName(String name){
        Query username = new Query(Criteria.where("username").is(name));
        User one = mongoTemplate.findOne(username, User.class);
        return one;
    }

    public List<User> getPage(int age,String name){

        return null;
    }


}
