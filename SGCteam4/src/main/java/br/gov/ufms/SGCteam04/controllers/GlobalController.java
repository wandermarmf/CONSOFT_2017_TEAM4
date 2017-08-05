package br.gov.ufms.SGCteam04.controllers;

import br.gov.ufms.SGCteam04.models.Endereco;
import br.gov.ufms.SGCteam04.models.Role;
import br.gov.ufms.SGCteam04.models.Usuario;
import br.gov.ufms.SGCteam04.repositories.RoleRepository;
import br.gov.ufms.SGCteam04.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/6/2017.
 */
@Controller
public class GlobalController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/register")
    public String registerUser(
            @Valid Usuario usuario,
            @Valid Endereco local,
            Model model,
            RedirectAttributes redirectAttributes
    )
    {
        try{
            usuario.setLocal(local);
            usuarioRepository.save(usuario);

            Role role = new Role();
            role.setRole("ROLE_ADMIN");
            role.setUsuario(usuario);
            roleRepository.save(role);
            redirectAttributes.addFlashAttribute("register","Você foi registrado com sucesso");
            return "redirect:/login";
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("erro","Já existe um registro com estes dados !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("erro","Não foi possivel efetuar o registro !");

        }
        return "/default/register";
    }

    @GetMapping("/register")
    public String register()
    {
        return "/default/register";
    }

    @RequestMapping("/")
    public String index()
    {
        return "redirect:/admin/conferencia-consulta";
    }

    @GetMapping("/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
