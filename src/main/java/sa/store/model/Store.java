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
    private String description;
    private String type;
    private String owner;
    private String ubication;
    private String dates;
    private String img;


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

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUbication() {
        return ubication;
    }
    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getDates() {
        return dates;
    }
    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}