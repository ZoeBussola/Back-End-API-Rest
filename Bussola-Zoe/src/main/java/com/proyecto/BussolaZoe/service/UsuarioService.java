package com.proyecto.BussolaZoe.service;


import com.proyecto.BussolaZoe.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
@Service
public class UsuarioService implements UserDetailsService {

    private IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        return usuarioRepository.finduserName(nombreUsuario).orElseThrow((() -> new UsernameNotFoundException(
                "Usuario no encontrado")));
    }
}

*/