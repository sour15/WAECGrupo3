package com.example.WAEC2Grupo3.controller.backoffice;

import com.example.WAEC2Grupo3.service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {

    private IUsuarioService usuarioService;
    private BCryptPasswordEncoder encoder;

    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/logueo";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/home";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("nomusuario", "Bienvenido : " + userDetails.getUsername());
        return "backoffice/auth/home";
    }



}
