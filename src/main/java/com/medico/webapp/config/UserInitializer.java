package com.medico.webapp.config;

import com.medico.webapp.entity.Role;
import com.medico.webapp.entity.Users;
import com.medico.webapp.repository.RolesRepository;
import com.medico.webapp.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class UserInitializer {
  @Bean
  CommandLineRunner initDatabase(UsersRepository usersRepo, RolesRepository roleRepo, PasswordEncoder passwordEncoder) {

    return args -> {
      if (usersRepo.findByUsername("admin").isEmpty()) {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepo.save(adminRole);

        Users admin = new Users();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123")); // must be encoded
        admin.setEmail("admin@medico.com");
        admin.setPhone("1234567890");
        admin.setEnable(true);
        admin.setRoles(Set.of(adminRole));
        usersRepo.save(admin);
      }
    };
  }
}
