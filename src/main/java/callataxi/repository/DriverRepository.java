package callataxi.repository;

import callataxi.objects.Driver;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 19/11/14.
 */
public interface DriverRepository extends CrudRepository<Driver, Long> {
    List<Driver> findByUsernameAndPassword(String username, String password);
}
