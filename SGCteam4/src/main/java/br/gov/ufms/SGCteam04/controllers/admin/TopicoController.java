package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.Topico;
import br.gov.ufms.SGCteam04.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/topico")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping
    private String topico(Model model)
    {
        List<Topico> topicoList = (List<Topico>) topicoRepository.findAll();
        model.addAttribute("itens",topicoList);
        return "restrito/admin/topico";
    }

    @PostMapping
    private String topicoPost(
            Model model,
            @Valid Topico topico,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try {
            topicoRepository.save(topico);
            response = "success";
        }
        catch(DataIntegrityViolationException d)
        {
            response = "Já existe um topico com este nome !";
        }
        catch(Exception e)
        {
            response = "Ocorreu um erro!";
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/topico";
    }

    @DeleteMapping
    private String topicoDelete(
            @RequestParam(value = "id",required = true)Integer id,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try{
            topicoRepository.delete(id);
            response = "Deletado  com sucesso !";
        }catch(Exception e)
        {
            e.printStackTrace();
            response = "Um erro ocorreu!";
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/topico";
    }

    @PutMapping
    private String topicoUpdate(
            @Valid Topico topico,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try{

           topicoRepository.save(topico);
           response = "Atualizado com sucesso!";

        }catch(Exception e)
        {
            e.printStackTrace();
            response = "Um erro ocorreu !";
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/topico";

    }

}
