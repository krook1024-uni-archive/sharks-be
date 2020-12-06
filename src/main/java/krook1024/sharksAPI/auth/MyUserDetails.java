package krook1024.sharksAPI.auth;

import krook1024.sharksAPI.exception.CustomException;
import krook1024.sharksAPI.user.model.User;
import krook1024.sharksAPI.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(s);

        if (user == null) {
            throw new CustomException("User not found", HttpStatus.NOT_FOUND);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(s)
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
