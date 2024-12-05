package VTTPday18.inclass.Models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {
    
    private int id;

    //required, between 5-150 char
    @NotNull(message="name cannot be null")
    @NotEmpty
    @Size(min=2, max=150, message="Name must be between 2 and 150 characters")
    private String fullName;

    //required and must be email
    @NotNull(message="email cannot be null")
    @NotEmpty
    @Email(message="must be valid email")
    private String email;

    //between 111111 and 888888
    @Min(value=111111, message="postal code must be at least 111111")
    @Max(value=888888, message="postal code must be less than 888888")
    private String postalCode;

    //7 digits only - use REGEX
    @Pattern(regexp = "^\\d{7}$", message = "Phone number must be exactly 7 digits")
    private String phoneNumber;

    // @Past(message="please choose a future date")
    // @DateTimeFormat(pattern="yyyy-MM-dd")
    // private Date DOB;

    // public Date getDOB() {return DOB;}
    // public void setDOB(Date dOB) {DOB = dOB;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    @Override
    public String toString() {
        return id + "," + fullName + "," + email + "," + postalCode
                + "," + phoneNumber;
    }
    public Person(int id,
            @NotNull(message = "name cannot be null") @NotEmpty @Size(min = 2, max = 150, message = "Name must be between 2 and 150 characters") String fullName,
            @NotNull(message = "email cannot be null") @NotEmpty @Email(message = "must be valid email") String email,
            @Min(value = 111111, message = "postal code must be at least 111111") @Max(value = 888888, message = "postal code must be less than 888888") String postalCode,
            @Pattern(regexp = "^\\d{7}$", message = "Phone number must be exactly 7 digits") String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        // this.DOB = DOB;
    }



    
    

}
