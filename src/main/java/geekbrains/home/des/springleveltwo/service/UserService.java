package geekbrains.home.des.springleveltwo.service;

import geekbrains.home.des.springleveltwo.domain.User;
import geekbrains.home.des.springleveltwo.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAll();
    boolean save(UserDTO userDTO);
    boolean update(User user);
    User findById(Long id);
}
