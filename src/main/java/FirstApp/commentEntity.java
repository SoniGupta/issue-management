package FirstApp;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class commentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer comment_id;

    private Integer issue_id;

    private String comment;

    private Integer emp_id;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public commentEntity()
        {

        }

    public commentEntity(Integer issue_id, String comment, Integer emp_id,String date){
        this.issue_id=issue_id;
        this.comment=comment;
        this.emp_id=emp_id;
        this.date=date;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(Integer issue_id) {
        this.issue_id = issue_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }



}
