package org.appandroidmc.controller;

import org.appandroidmc.entity.Usuario;
import org.appandroidmc.service.UsuarioService;
import org.appandroidmc.utils.GenericResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request){
        String email = request.getParameter("email");
        String contrasenia= request.getParameter("pass");
        return this.service.login(email,contrasenia);
    }
}
