package callataxi.service;

import callataxi.exception.CommandHasBeenDeleteException;
import callataxi.objects.Command;
import callataxi.objects.Driver;
import callataxi.objects.Request;

/**
 * Created by JIN Benli on 21/11/14.
 */
public interface CommandService {

    public Command createCommand(Request request, Driver driver);

    public boolean deleteCommand(Command command) throws CommandHasBeenDeleteException;

}
