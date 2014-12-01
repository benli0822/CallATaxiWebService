package callataxi.controller;

import callataxi.Application;
import callataxi.exception.CommandHasBeenDeleteException;
import callataxi.objects.Command;
import callataxi.objects.Driver;
import callataxi.objects.Request;
import callataxi.objects.Status;
import callataxi.repository.CommandRepository;
import callataxi.repository.DriverRepository;
import callataxi.repository.RequestRepository;
import callataxi.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by JIN Benli on 23/11/14.
 */
@Controller
@Import(Application.class)
public class CommandController {

    @Autowired
    CommandService commandService;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    CommandRepository commandRepository;

    @RequestMapping(value = "/command/postCommand", method = RequestMethod.GET)
    public @ResponseBody
    Command postCommand(@RequestParam(value = "did", required = true)int did, @RequestParam(value = "rid", required = true)int rid) {
        Driver driver = driverRepository.findOne(Long.valueOf(did));
        Request request = requestRepository.findOne(Long.valueOf(rid));
        return commandService.createCommand(request, driver);
    }

    @RequestMapping(value = "/command/deleteCommand", method = RequestMethod.GET)
    public @ResponseBody boolean deleteCommand(@RequestParam(value = "cid", required = true)long cid) throws CommandHasBeenDeleteException {
        Command command = commandRepository.findOne(cid);

        return commandService.deleteCommand(command);
    }

    @RequestMapping(value = "/command/searchCommand", method = RequestMethod.GET)
    public @ResponseBody Command searchCommand(@RequestParam(value = "rid", required = true)int rid) {
        List<Command> list = (List<Command>) commandRepository.findAll();
        for(Command c : list) {
            if(c.getRequest().getId() == Long.valueOf(rid)) {
                if(c.getRequest().getStatus() == Status.RUUNING) {
                    return c;
                }
            }
        }
        return null;
    }

}
