package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.GrupoParticipante;
import br.gov.ufms.SGCteam04.repositories.GrupoParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/grupo-participante")
public class GrupoParticipanteController {

/*
    @Autowired
    GrupoParticipanteRepository grupoParticipanteRepository;

    @GetMapping("/grupo-participante")
    private String grupoParticipante(Model model)
    {
        List<GrupoParticipante> grupoParticipanteList = (List<GrupoParticipante>) grupoParticipanteRepository.findAll();
        model.addAttribute("itens",grupoParticipanteList);
        return "restrito/admin/grupo-participante";
    }

    @PostMapping("/grupo-participante")
    private String grupoParticipantePost(
            RedirectAttributes redirectAttributes,
            @Valid GrupoParticipante grupoParticipante
    )
    {
        String response = "";
        try {
            grupoParticipanteRepository.save(grupoParticipante);
            response = "success";
        }
        catch(DataIntegrityViolationException d)
        {
            model.addAttribute("response","Já existe um grupo com este nome !");
        }
        catch(Exception e)
        {
            model.addAttribute("response","Ocorreu um erro !");
        }
        return "restrito/admin/grupo-participante";
    }
    */
}
