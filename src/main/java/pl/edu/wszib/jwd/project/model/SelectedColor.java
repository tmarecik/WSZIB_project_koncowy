package pl.edu.wszib.jwd.project.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "selected_colors")  //hibernate utworzy taką tabele
public class SelectedColor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    //id autogenerowane
    private Integer id;
    private String color;
    private Date ctime;   //creation time

    public SelectedColor() {
    }

    //ten konstruktor bedzie potrzebny do Unit-test
    public SelectedColor(String color, Date ctime) {
        this.color = color;
        this.ctime = ctime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }
}
