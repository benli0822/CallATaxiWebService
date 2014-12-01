package callataxi.objects;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JIN Benli on 21/11/14.
 */
@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = false)
    @NaturalId
    private Request request;

    @ManyToOne(optional = false)
    @NaturalId
    private Driver driver;

    private Date date;

    private Status status;

    protected Command() {
    }

    public Command(Request request, Driver driver, Date date, Status status) {
        this.request = request;
        this.driver = driver;
        this.date = date;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
