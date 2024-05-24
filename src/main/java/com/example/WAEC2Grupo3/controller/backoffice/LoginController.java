package com.example.WAEC2Grupo3.controller.backoffice;

import com.example.WAEC2Grupo3.model.db.Usuario;
import com.example.WAEC2Grupo3.service.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {

    private IUsuarioService usuarioService;
    private BCryptPasswordEncoder encoder;

    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/login";
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

    @GetMapping("/registrar")
    public String registraruser(Model model){
        model.addAttribute("u", new Usuario());
        return "backoffice/auth/registro";
    }

    @PostMapping("/registrar")
    public String registraruser(@ModelAttribute Usuario security, Model model){
        try{
            security.setPassword(encoder.encode(security.getPassword()));
            security.setActivo(true);
            usuarioService.guardarUsuario(security, security.getNomusuario());
            model.addAttribute("success", "Usuario Registrado Exitosamente");
            model.addAttribute("u", new Usuario());
        }catch(Exception ex) {
            System.out.println("Error : " + ex.getCause().getMessage());
        }
        return "backoffice/auth/registro";
    }

}
