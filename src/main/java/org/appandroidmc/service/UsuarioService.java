package org.appandroidmc.service;

import org.appandroidmc.entity.Usuario;
import org.appandroidmc.repository.UsuarioRepository;
import org.appandroidmc.utils.GenericResponse;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.appandroidmc.utils.Global.*;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public GenericResponse<Usuario> login(String email, String clave){
        Optional<Usuario> opt = this.repository.login(email, clave);
        if(opt.isPresent()){
            return new GenericResponse<Usuario>(TIPO_AUTH,RPTA_OK,"Iniciaste sesión correctamente",opt.get());
        }else{
            return new GenericResponse<Usuario>(TIPO_AUTH,RPTA_WARNING,"El usuario no existe",new Usuario());
        }
    }
}
