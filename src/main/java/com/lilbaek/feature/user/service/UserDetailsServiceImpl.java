package com.lilbaek.feature.user.service;


import com.lilbaek.framework.model.User;
import com.lilbaek.framework.model.UserDetailsImpl;
import com.lilbaek.feature.user.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmailIgnoreCase(email);

        user.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));

        Optional<UserDetailsImpl> userDetails = user.map(UserDetailsImpl::new);
        return userDetails.get();
    }

}