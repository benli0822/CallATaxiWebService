package callataxi.repository;

import callataxi.objects.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 19/11/14.
 */
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByUsernameAndPassword(String username, String password);
}
