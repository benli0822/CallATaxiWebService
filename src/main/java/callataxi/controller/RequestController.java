package callataxi.controller;

import callataxi.Application;
import callataxi.objects.Client;
import callataxi.objects.Request;
import callataxi.repository.ClientRepository;
import callataxi.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by JIN Benli on 23/11/14.
 */
@Controller
@Import(Application.class)
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(value = "/request/getLatest", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Request> getLatest() {
        return requestService.getLatestRequest();
    }

    @RequestMapping(value = "/request/getReservation", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Request> getReservation() {
        return requestService.getReservationRequest();
    }

    @RequestMapping(value = "/request/getAll", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Request> getAll() {
        return requestService.getAllRequest();
    }

    @RequestMapping(value = "/request/createRequest", method = RequestMethod.GET)
    public
    @ResponseBody
    Request createRequest(@RequestParam(value = "cid", required = true) int cid, @RequestParam(value = "lon", required = true)String lon, @RequestParam(value = "lat", required = true)String lat) {
        Client client = clientRepository.findOne(Long.valueOf(cid));
        client.setLongitude(lon);
        client.setLatitude(lat);
        Date nowTime = new Date();
        return requestService.createRequest(client, nowTime);
    }

    @RequestMapping(value = "/request/createReservationRequest", method = RequestMethod.GET)
    public
    @ResponseBody
    Request createReservationRequest(@RequestParam(value = "cid", required = true) int cid, @RequestParam(value = "time", required = true) String time , @RequestParam(value = "lon", required = true)String lon, @RequestParam(value = "lat", required = true)String lat) {
        Client client = clientRepository.findOne(Long.valueOf(cid));
        client.setLongitude(lon);
        client.setLatitude(lat);
        String[] info = time.split(" ");
        String[] time1 = info[0].split(":");
        String[] date1 = info[1].split("/");

        Date reservationTime = new Date(Integer.valueOf(date1[2]), Integer.valueOf(date1[1]), Integer.valueOf(date1[0]), Integer.valueOf(time1[0]), Integer.valueOf(time1[1]));

        return requestService.createReservationRequest(client, reservationTime);
    }
}
