package callataxi.repository;

import callataxi.objects.Request;
import callataxi.objects.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 21/11/14.
 */
public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findByStatus(Status status);
}
