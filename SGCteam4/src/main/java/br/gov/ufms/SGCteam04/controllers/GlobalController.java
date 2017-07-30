package br.gov.ufms.SGCteam04.controllers;

import br.gov.ufms.SGCteam04.models.Endereco;
import br.gov.ufms.SGCteam04.models.Role;
import br.gov.ufms.SGCteam04.models.Usuario;
import br.gov.ufms.SGCteam04.repositories.RoleRepository;
import br.gov.ufms.SGCteam04.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            Model model
    )
    {
        try{
            usuario.setLocal(local);
            usuarioRepository.save(usuario);

            Role role = new Role();
            role.setRole("user");
            role.setUsuario(usuario);
            roleRepository.save(role);
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
        return "/default/index";
    }
}
