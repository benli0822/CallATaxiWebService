package callataxi.service;

import callataxi.objects.Client;
import callataxi.objects.Request;
import callataxi.objects.Status;
import callataxi.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by JIN Benli on 23/11/14.
 */
@Component(value = "requestService")
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    /**
     * Get all unconfirmed reservations
     * @return
     */
    @Override
    public List<Request> getReservationRequest() {
        List<Request> reservations = requestRepository.findByStatus(Status.RESERVATION_WAITING);
        return reservations;
    }

    /**
     * Get all latest requests tried by time
     * @return
     */
    @Override
    public List<Request> getLatestRequest() {
        List<Request> requests = requestRepository.findByStatus(Status.WAITING);
        Collections.sort(requests, new Comparator<Request>() {

            @Override
            public int compare(Request o1, Request o2) {
                return o1.compareTo(o2);
            }
        });
        return requests;
    }

    @Override
    public List<Request> getAllRequest() {
        List<Request> requests = (List<Request>) requestRepository.findAll();
        Collections.sort(requests, new Comparator<Request>() {

            @Override
            public int compare(Request o1, Request o2) {
                return o1.compareTo(o2);
            }
        });
        return requests;
    }

    @Override
    public Request createRequest(Client c, Date date) {
        List<Request> list = (List<Request>) requestRepository.findAll();
        for(Request r : list) {
            if(r.getClient().getId() == c.getId() && r.getStatus() == Status.WAITING){
                return r;
            }
        }
        Request r = new Request(c, date, Status.WAITING);
        return requestRepository.save(r);
    }

    @Override
    public Request createReservationRequest(Client c, Date date) {
        List<Request> list = (List<Request>) requestRepository.findAll();
        for(Request r : list) {
            if(r.getClient().getId() == c.getId() && r.getStatus() == Status.WAITING){
                return r;
            }
        }
        Request r = new Request(c, date, Status.RESERVATION_WAITING);
        return requestRepository.save(r);
    }
}
