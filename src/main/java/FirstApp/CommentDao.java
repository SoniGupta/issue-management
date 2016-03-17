package FirstApp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommentDao extends JpaRepository<commentEntity, Integer> {


//    @Modifying
//    @Query("")
//    public void updatelist(boolean done,Integer id);

}
