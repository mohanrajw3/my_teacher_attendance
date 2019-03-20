package app.mongo;


import app.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMongoRep extends MongoRepository<UserModel, Integer> {

    String getAllByEmail(String name);

}
