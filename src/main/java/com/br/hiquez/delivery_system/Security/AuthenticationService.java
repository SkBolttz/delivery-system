package com.br.hiquez.delivery_system.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.br.hiquez.delivery_system.Repository.LoginGeralRepository;

@Service
public class AuthenticationService implements UserDetailsService{

    @Autowired
    private LoginGeralRepository loginGeralRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        var user = loginGeralRepository.findByEmail(username);

        if(user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("Dados inválidos!");
        }
    }
    
}
