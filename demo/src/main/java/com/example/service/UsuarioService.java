package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Usuario;
import com.example.exepcion.BadRequestException;
import com.example.exepcion.ResourceNotFoundException;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


    public Usuario getUsuarioById(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Usuario no encontrado: " + id)
                );
    }


    public Usuario crearUsuario(Usuario usuario) {

        if (usuario.getNombre() == null || usuario.getNombre().isBlank()) {
            throw new BadRequestException("El nombre es obligatorio");
        }

        if (usuario.getCorreo() == null || usuario.getCorreo().isBlank()) {
            throw new BadRequestException("El correo es obligatorio");
        }

        if (usuario.getContrasena() == null || usuario.getContrasena().isBlank()) {
            throw new BadRequestException("La contraseña es obligatoria");
        }

        if (usuario.getRol() == null) {
            throw new BadRequestException("El rol es obligatorio");
        }


        return usuarioRepository.save(usuario);
    }


    public Usuario actualizarUsuario(Long id, Usuario usuario) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Usuario no encontrado: " + id)
                );


        if (usuario.getNombre() == null || usuario.getNombre().isBlank()) {
            throw new BadRequestException("El nombre es obligatorio");
        }

        if (usuario.getCorreo() == null || usuario.getCorreo().isBlank()) {
            throw new BadRequestException("El correo es obligatorio");
        }

        if (usuario.getContrasena() == null || usuario.getContrasena().isBlank()) {
            throw new BadRequestException("La contraseña es obligatoria");
        }

        if (usuario.getRol() == null) {
            throw new BadRequestException("El rol es obligatorio");
        }


        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setCorreo(usuario.getCorreo());
        usuarioExistente.setContrasena(usuario.getContrasena());
        usuarioExistente.setRol(usuario.getRol());


        return usuarioRepository.save(usuarioExistente);
    }


    public void eliminarUsuario(Long id) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> 
                    new ResourceNotFoundException("Usuario no encontrado: " + id)
                );


        usuarioRepository.delete(usuarioExistente);
    }

}