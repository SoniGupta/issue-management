package FirstApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsServices implements UserDetailsService {
    private final EmpDao empDao;
    private final UserRoleDao userRoleDao;

    @Autowired
    public CustomUserDetailsServices(EmpDao empDao, UserRoleDao userRoleDao)
    {
        this.empDao = empDao;
        this.userRoleDao = userRoleDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EmployeeEntity employeeEntity = empDao.findByUsername(username);
        if (null == employeeEntity) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            List<String> userRoles = userRoleDao.findRoleByUserName(username);
            return new CustomuserDetails(employeeEntity, userRoles);
        }
    }

}