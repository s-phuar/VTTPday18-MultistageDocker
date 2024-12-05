package VTTPday18.exercise.model;

import java.util.Date;

public class User {

    //add date validation later
    private String name;
    private String dob;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDob() {return dob;}
    public void setDob(String dob) {this.dob = dob;}


    @Override
    public String toString() {
        return "User [name=" + name + ", dob=" + dob + "]";
    }


        


}
