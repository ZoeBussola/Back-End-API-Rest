package com.proyecto.BussolaZoe.login;

import com.proyecto.BussolaZoe.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final IUsuarioRepository userRepository;

    @Autowired
    public AppUserService(IUsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        return userRepository.finduserName(nombreUsuario).orElseThrow((() ->
                new UsernameNotFoundException(
                "Usuario no encontrado")));
    }

}
