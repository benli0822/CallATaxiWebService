package callataxi.controller;

import callataxi.Application;
import callataxi.objects.Driver;
import callataxi.repository.ClientRepository;
import callataxi.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by JIN Benli on 19/11/14.
 */
@Controller
@Import(Application.class)
public class LoginController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DriverRepository driverRepository;

    @RequestMapping(value = "/driver/login", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Driver> driverLogin(@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) {
        return driverRepository.findByUsernameAndPassword(username, password);
    }
}
