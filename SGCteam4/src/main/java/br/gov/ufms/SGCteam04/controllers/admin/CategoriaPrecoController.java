package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.CategoriaPreco;
import br.gov.ufms.SGCteam04.repositories.CategoriaPrecoRepository;
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
@RequestMapping("/admin/categoria-preco")
public class CategoriaPrecoController {


    @Autowired
    CategoriaPrecoRepository categoriaPrecoRepository;

    @GetMapping
    private String categoriaPreco(Model model)
    {

        List<CategoriaPreco> categoriaPrecoList = (List<CategoriaPreco>) categoriaPrecoRepository.findAll();
        model.addAttribute("itens",categoriaPrecoList);
        return "restrito/admin/categoria-preco";
    }

    @PostMapping
    private String categoriaPrecoPost(
            Model model,
            @Valid CategoriaPreco categoriaPreco,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try {
            categoriaPrecoRepository.save(categoriaPreco);
            response = "success";
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            response = "Já existe uma categoria com a descrição fornecida !";
        }
        catch(Exception e )
        {
            response = "Um erro ocorreu !";
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/categoria-preco";
    }

    @DeleteMapping
    private String categoriaPostDelete(
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "id",required = true)Integer id
    )
    {
        String response = "";
        try{

            categoriaPrecoRepository.delete(id);
            response = "Deletado com sucesso";

        }catch(Exception e)
        {
            e.printStackTrace();
            response = "Um erro aconteceu !";
        }
        //redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/categoria-preco";
    }

    @PutMapping
    private String categoriaPostDelete(
            RedirectAttributes redirectAttributes,
            @Valid CategoriaPreco categoriaPreco
    )
    {
        String response = "";
        try{

            categoriaPrecoRepository.save(categoriaPreco);
            response = "Atualizado com sucesso";

        }catch(Exception e)
        {
            e.printStackTrace();
            response = "Um erro aconteceu !";
        }
        //redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/categoria-preco";
    }

}
