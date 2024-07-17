package com.usg.apirest.controller.security;

import com.usg.apirest.dominio.usuarios.IUsuariosRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.rmi.RemoteException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private IUsuariosRepository iUsuariosRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var authheader = request.getHeader("Authorization");
        if (authheader != null) {
            var token = authheader.replace("Bearer ", "");
            var subject = tokenService.getSubject(token);
            if (subject != null){
                var usuario = iUsuariosRepository.findByLogin(subject);
                var autentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
