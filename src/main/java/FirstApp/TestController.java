package FirstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping(value = "/emp", produces = {"application/json"})
    @ResponseBody
    public List<EmployeeEntity> disp() {
        List<EmployeeEntity> employeeList;
        employeeList = empDao.findAll();
        return employeeList;
    }


    @RequestMapping("/addemp")
    @ResponseBody
    public EmployeeEntity create(String employeeName,String username, String password, String fatherName,
                                 String address, String email, String phone, String gender, String enabled,String role)
    {

        EmployeeEntity ee = new EmployeeEntity(employeeName,username, password, fatherName, address, email, phone, gender, enabled);
        ee = empDao.save(ee);


        UserRoleEntity uu=new UserRoleEntity();
        uu.setRole(role);
        uu.setEmployee(ee);
        userRoleDao.save(uu);
        ee.setUserRoleEntity(uu);

        return ee;


    }

    @RequestMapping("/addissue")
    @ResponseBody
    public IssueEntity add(String title, String description, String status, String created_date, Integer emp_id) {
        EmployeeEntity assignee = empDao.findOne(emp_id);
        IssueEntity i = new IssueEntity(title, description, status, created_date, assignee);
        IssueEntity aa = issueDao.save(i);
        return aa;
    }

    @RequestMapping("/allissues")
    @ResponseBody
    public List<IssueEntity> show() {
        List<IssueEntity> issueList;
        issueList = issueDao.findAll();
        return issueList;

    }

    @RequestMapping("/addcomments")
    @ResponseBody
    public commentEntity savecomments(Integer issue_id, String comment, Integer emp_id, String date) {
        commentEntity comm = new commentEntity(issue_id, comment, emp_id, date);
        return commentDao.save(comm);
    }


    @RequestMapping("/issuedetails")
    @ResponseBody
    public IssueEntity testcomment(Integer issue_id) {
        IssueEntity issueEntity = issueDao.getOne(issue_id);
        return issueEntity;

    }
//    @RequestMapping("/testcomment")
//    @ResponseBody
//    public commentEntity test1()
//    {
//     commentEntity com= commentDao.getOne(1);
//        com.getEmployee();
//        return com;
//
//    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public EmployeeEntity currentUser(Principal principal) {
        String user = principal.getName();
        EmployeeEntity employeeEntity = empDao.findByUsername(user);
        return employeeEntity;
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUsername(Principal principal) {
        return principal.getName();
    }

//    @RequestMapping(value = "/role",method = RequestMethod.GET)
//    @ResponseBody
//    private boolean hasRole(String role) {
//        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
//                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        boolean hasRole = false;
//        for (GrantedAuthority authority : authorities) {
//            hasRole = authority.getAuthority().equals(role);
//            if (hasRole) {
//                break;
//            }
//        }
//        return hasRole;
//    }


    @Autowired
    private IssueDao issueDao;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserRoleDao userRoleDao;


}