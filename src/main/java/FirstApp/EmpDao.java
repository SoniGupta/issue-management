package FirstApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EmpDao extends JpaRepository<EmployeeEntity, Integer> {




}
