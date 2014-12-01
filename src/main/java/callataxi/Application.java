package callataxi;

import callataxi.objects.Client;
import callataxi.objects.Driver;
import callataxi.repository.ClientRepository;
import callataxi.repository.DriverRepository;
import callataxi.repository.RequestRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by JIN Benli on 19/11/14.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        DriverRepository driverRepository = context.getBean(DriverRepository.class);
        RequestRepository requestRepository = context.getBean(RequestRepository.class);

        // save somme client
        clientRepository.save(new Client("alice", "alice", "0", "0", "alice", "alice", "lille", "alice@lille.fr"));
        clientRepository.save(new Client("bob", "bob", "0", "0", "bob", "bob", "lille", "bob@lille.fr"));
        clientRepository.save(new Client("catelina", "catelina", "0", "0", "catelina", "catelina", "lille", "catelina@lille.fr"));

        //save some driver
        driverRepository.save(new Driver("devina","devina", "devina", "devina","lille", "devina@lille.fr", "Renault", "123"));
        driverRepository.save(new Driver("elina","elina", "elina", "elina","lille", "elina@lille.fr", "Renault", "123"));
        driverRepository.save(new Driver("fabine","fabine", "fabine", "fabine","lille", "fabine@lille.fr", "Renault", "123"));

    }

}