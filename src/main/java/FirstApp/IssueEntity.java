package FirstApp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="issue")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class  IssueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer issue_id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private  String status;
    @NotNull
    private String created_date;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private EmployeeEntity assignee;

    @OneToMany(mappedBy = "issue_id", fetch = FetchType.EAGER)
    private List<commentEntity> commentList;

//    @NotNull
//    private Integer emp_id;


    public  IssueEntity()
    {

    }
    public IssueEntity(String title, String description, String status, String created_date, EmployeeEntity assignee)
    {
        this.title=title;
        this.description=description;
        this.status=status;
        this.created_date=created_date;
        this.assignee=assignee;
    }

    public Integer getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(Integer issue_id) {
        this.issue_id = issue_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getCreated_date()
    {
        return created_date;
    }

    public void setCreated_date(String created_date)

    {
        this.created_date = created_date;
    }

    public EmployeeEntity getAssignee()
    {
        return assignee;
    }

    public void setAssignee(EmployeeEntity assignee)
    {
        this.assignee = assignee;
    }

    public List getCommentList() {
        return commentList;
    }

    public void setCommentList(List commentList) {
        this.commentList = commentList;
    }



}
