package sa.store.model;

import javax.persistence.*;

@Entity
@Table(name = "stores")
@NamedQueries({@NamedQuery(name = Store.FIND_ALL, query = "SELECT u FROM Store u")})
public class Store {

    public static final String FIND_ALL = "Store.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int code;
    private String name;
    private String typee;
    private String owner;
    private String address;
    private String schedule;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getName(){
      return name;
    }
    public void setName(String name){
      this.name = name;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedule() {
        return schedule;
    }
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTypee() {
        return typee;
    }
    public void setTypee(String typee) {
        this.typee = typee;
    }
}