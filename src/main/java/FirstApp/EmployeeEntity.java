package FirstApp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class EmployeeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Integer id;

    @NotNull
    @Column(name="employee_name")
    private String employeeName;

    @NotNull
    private String username;

    @NotNull
    private String password;

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

    @NotNull
    private String enabled;

    @OneToOne(mappedBy = "employee", fetch = FetchType.EAGER)
    private UserRoleEntity userRoleEntity;

    public EmployeeEntity(EmployeeEntity employeeEntity) {
        this(employeeEntity.getEmployeeName(),employeeEntity.getUsername(),employeeEntity.getPassword(),employeeEntity.getFatherName(),
                employeeEntity.getAddress(),employeeEntity.getEmail(),employeeEntity.getPhone(),
                employeeEntity.getGender(),employeeEntity.getEnabled());

//        this.username = employeeEntity.getusername;
//        this.password=employeeEntity.getpassword;
//        this.fatherName = employeeEntity.getfatherName;
//        this.address = employeeEntity.getaddress;
//        this.email = employeeEntity.getemail;
//        this.phone = employeeEntity.getphone;
//        this.gender = employeeEntity.getgender;
//        this.enabled=employeeEntity.getenabled;
    }
    public EmployeeEntity(){}

    public EmployeeEntity( String employeeName,String username,String password, String fatherName, String address, String email, String phone, String gender,String enabled)
{       this.employeeName=employeeName;
        this.username = username;
        this.password=password;
        this.fatherName = fatherName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.enabled=enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRoleEntity getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
