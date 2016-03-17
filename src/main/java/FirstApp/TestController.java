package FirstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @RequestMapping(value = "/emp", produces = {"application/json"})
    @ResponseBody
    public List<EmployeeEntity> disp() {


        List<EmployeeEntity> employeeList;
        employeeList = empDao.findAll();

        return  employeeList;
    }


    @RequestMapping("/addemp")
    @ResponseBody
    public EmployeeEntity create( String name, String fatherName, String address, String email, String phone, String gender)
    {
        EmployeeEntity ee=new EmployeeEntity(name,fatherName,address,email,phone,gender);
        return empDao.save(ee);
    }

    @RequestMapping("/addissue")
    @ResponseBody
    public IssueEntity add(String title, String description, String status, String created_date, Integer emp_id)
    {
        EmployeeEntity assignee = empDao.findOne(emp_id);
        IssueEntity i=new IssueEntity(title,description,status, created_date, assignee);
        IssueEntity aa= issueDao.save(i);
        return aa;
    }

    @RequestMapping("/allissues")
    @ResponseBody
    public List<IssueEntity> show()
    {
        List<IssueEntity> issueList;
        issueList= issueDao.findAll();
        return issueList;

    }

    @RequestMapping("/addcomments")
    @ResponseBody
    public commentEntity savecomments( Integer issue_id, String comment, Integer emp_id,String date)
    {
       commentEntity comm=new commentEntity(issue_id,comment,emp_id,date);
        return commentDao.save(comm);
    }




    @RequestMapping("/issuedetails")
    @ResponseBody
    public IssueEntity testcomment(Integer issue_id)
    {
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


    @Autowired
    private IssueDao issueDao;

    @Autowired
    private EmpDao empDao;

    @Autowired
    private CommentDao commentDao;
}