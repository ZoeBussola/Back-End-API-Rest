package com.proyecto.BussolaZoe.login;
import com.proyecto.BussolaZoe.model.Usuario;
import com.proyecto.BussolaZoe.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private IUsuarioRepository userRepository;

    @Autowired
    public DataLoader(IUsuarioRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("Admin");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder.encode("User");

        userRepository.save(new Usuario("Admin","Admin","Admin",
                hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new Usuario("User","User","User",
                hashedPassword, AppUserRole.USER));

    }
}

