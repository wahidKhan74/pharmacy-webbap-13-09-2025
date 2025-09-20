package com.medico.webapp.services;

import com.medico.webapp.entity.Users;
import com.medico.webapp.exception.NotFound;
import com.medico.webapp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = usersRepository.findByUsername(username)
      .orElseThrow(() -> new NotFound("User not found."));

    return new User(
      user.getUsername(),
      user.getPassword(),
      user.isEnable(),
      true,
      true,
      true,
      user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getName()))
        .collect(Collectors.toList())
    );
  }
}
