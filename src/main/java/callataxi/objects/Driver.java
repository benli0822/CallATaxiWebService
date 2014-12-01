package callataxi.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by JIN Benli on 19/11/14.
 */
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String taximodel;
    private String taxinumber;

    protected Driver() {
    }

    public Driver(String username, String password, String firstname, String lastname, String address, String email, String taximodel, String taxinumber) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.taximodel = taximodel;
        this.taxinumber = taxinumber;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getTaximodel() {
        return taximodel;
    }

    public String getTaxinumber() {
        return taxinumber;
    }
}
