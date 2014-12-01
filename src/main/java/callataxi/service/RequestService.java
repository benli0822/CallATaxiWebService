package callataxi.service;

import callataxi.objects.Client;
import callataxi.objects.Request;

import java.util.Date;
import java.util.List;

/**
 * Created by JIN Benli on 23/11/14.
 */
public interface RequestService {

    public List<Request> getReservationRequest();

    public List<Request> getLatestRequest();

    public List<Request> getAllRequest();

    public Request createRequest(Client c, Date date);

    public Request createReservationRequest(Client c, Date date);
}
