package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.TipoEventoProduto;
import br.gov.ufms.SGCteam04.repositories.TipoEventoProdutoRepository;
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
@RequestMapping("/admin/tipo-evento-produto")
public class TipoEventoProdutoController {

    @Autowired
    TipoEventoProdutoRepository tipoEventoProdutoRepository;

    @GetMapping
    private String tipoEventoProduto(Model model)
    {

        List<TipoEventoProduto> tipoEventoProdutoList = (List<TipoEventoProduto>) tipoEventoProdutoRepository.findAll();
        model.addAttribute("itens",tipoEventoProdutoList);
        return "restrito/admin/tipo-evento-produto";
    }

    @PostMapping
    private String tipoEventoProdutoPost(
            @Valid TipoEventoProduto tipoEventoProduto,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try {
            tipoEventoProdutoRepository.save(tipoEventoProduto);
            response = "success";

        }
        catch(DataIntegrityViolationException d)
        {
            response = "Já existe um tipo evento produto com este nome !";
        }
        catch(Exception e)
        {
            response = "Ocorreu um erro !";
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:admin/tipo-evento-produto";
    }

    @DeleteMapping
    private String tipoEventoProdutoDelete(
            @RequestParam(value = "id",required = true) Integer id,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try{
            tipoEventoProdutoRepository.delete(id);
            response = "Deletado com sucesso !";

        }catch(Exception e)
        {
            e.printStackTrace();
            response = "Ocorreu um erro";
        }
        //redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/tipo-evento-produto";
    }

    @PutMapping
    private String tipoEventoProdutoUpdate(
            @Valid TipoEventoProduto tipoEventoProduto,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try{

            tipoEventoProdutoRepository.save(tipoEventoProduto);

        }catch (Exception e)
        {
            e.printStackTrace();
            response = "Ocorreu um erro";
        }
        //redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/tipo-evento-produto";
    }
}
