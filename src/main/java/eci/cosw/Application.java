package eci.cosw;

import eci.cosw.data.CustomerRepository;
import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        System.out.println("First Querry");
        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date(System.currentTimeMillis())));
        List<Todo> todo = mongoOperation.find(query, Todo.class);
        query.addCriteria(Criteria.where("dueDate").lt(new Date(System.currentTimeMillis())));
        System.out.println("--------------------------------------------------------------------------");

        System.out.println("Second Querry");
        Query secondQuery = new Query();
        secondQuery.addCriteria(Criteria.where("priority").gt(4));
        List<Todo> todo = mongoOperation.find(secondQuery, Todo.class);
        System.out.println("--------------------------------------------------------------------------");




    }

}