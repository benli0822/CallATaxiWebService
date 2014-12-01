package callataxi.service;

import callataxi.exception.CommandHasBeenDeleteException;
import callataxi.objects.Command;
import callataxi.objects.Driver;
import callataxi.objects.Request;
import callataxi.objects.Status;
import callataxi.repository.CommandRepository;
import callataxi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by JIN Benli on 21/11/14.
 */
@Component(value = "commandService")
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public Command createCommand(Request request, Driver driver) {
        if (request.getStatus() == Status.RUUNING) {
            List<Command> commandList = (List<Command>) commandRepository.findAll();
            for(Command c : commandList) {
                if(c.getRequest().equals(request)) {
                    return c;
                }
            }
            return null;
        } else {
            Command command = new Command(request, driver, request.getDate(), Status.RUUNING);
            commandRepository.save(command);
            request.setStatus(Status.RUUNING);
            requestRepository.save(request);
            return command;
        }
    }

    @Override
    public boolean deleteCommand(Command command) throws CommandHasBeenDeleteException {
        try {
            commandRepository.delete(command);
            return true;
        } catch (Exception e) {
            throw new CommandHasBeenDeleteException("[CommandHasBeenDelete]: " + command.toString());
        }
    }
}
