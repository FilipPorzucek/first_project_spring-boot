package com.example.task_menager.init;

import com.example.task_menager.model.Role;
import com.example.task_menager.model.User;
import com.example.task_menager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DataLoader(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin=new User("Marek", passwordEncoder.encode("admin123"),"admin@op.pl", Role.ADMIN);
        User user=new User("Damian", passwordEncoder.encode("user123"),"user@op.pl",Role.USER );
        userRepository.save(admin);
        userRepository.save(user);
    }
}
