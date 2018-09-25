package eci.cosw.data;

import eci.cosw.data.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<Customer, String> {

}   