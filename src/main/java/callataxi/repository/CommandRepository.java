package callataxi.repository;

import callataxi.objects.Command;
import callataxi.objects.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JIN Benli on 21/11/14.
 */
public interface CommandRepository extends CrudRepository<Command, Long> {
    List<Command> findByStatus(Status status);
}
