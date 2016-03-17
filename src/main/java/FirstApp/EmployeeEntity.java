package FirstApp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class EmployeeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "father_name")
    private String fatherName;

    @NotNull
    private String address;

    @NotNull
    private String email;

    @NotNull
    @Column(name = "phone_no")
    private String phone;

    @NotNull
    private String gender;

    public EmployeeEntity() {
    }

    public EmployeeEntity( String name, String fatherName, String address, String email, String phone, String gender) {
        this.name = name;
        this.fatherName = fatherName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
