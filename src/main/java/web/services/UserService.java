package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.dao.RoleRepositories;
import web.dao.UserRepositories;
import web.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepositories userRepository;
    @Autowired
    RoleRepositories roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getAuthorities()));
    }

        private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<? extends GrantedAuthority> roles) {
        return roles.stream()
                .peek(r -> System.out.println(r.getAuthority()))
                .map(r -> new SimpleGrantedAuthority(r.getAuthority())).collect(Collectors.toList());
    }

}
