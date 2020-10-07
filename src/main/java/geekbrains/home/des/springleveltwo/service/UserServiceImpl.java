package geekbrains.home.des.springleveltwo.service;

import geekbrains.home.des.springleveltwo.dao.UserDAO;
import geekbrains.home.des.springleveltwo.domain.User;
import geekbrains.home.des.springleveltwo.domain.UserRole;
import geekbrains.home.des.springleveltwo.dto.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean save(UserDTO userDTO) {
        if (!Objects.equals(userDTO.getPassword(), userDTO.getMatchPassword())){
            throw new RuntimeException("password is not identical");
        }
        User user = User.builder()
                .name(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .role(UserRole.USER)
                .build();
        userDAO.save(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        if (user == null){
            throw new RuntimeException("Enter null user");
        }
        userDAO.save(user);
        return true;
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User findUser = userDAO.findFirstByName(s);
        if (findUser == null){
            throw  new UsernameNotFoundException("User not found with name: " + s);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(findUser.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                findUser.getName(),
                findUser.getPassword(),
                roles);
    }
}