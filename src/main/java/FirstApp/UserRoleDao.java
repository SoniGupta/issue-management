package FirstApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRoleDao extends JpaRepository<UserRoleEntity, Integer>{
    @Modifying
    @Query("select a.role from UserRoleEntity a, EmployeeEntity b where b.username=?1 and a.employee.id=b.id")
    public List<String> findRoleByUserName(String username);



}
