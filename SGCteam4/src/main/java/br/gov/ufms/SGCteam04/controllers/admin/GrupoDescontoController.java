package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.GrupoDesconto;
import br.gov.ufms.SGCteam04.models.OpcaoPagamento;
import br.gov.ufms.SGCteam04.repositories.GrupoDescontoRepository;
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
@RequestMapping("/admin/grupo-desconto")
public class GrupoDescontoController {

    @Autowired
    GrupoDescontoRepository grupoDescontoRepository;


    @DeleteMapping
    private String deleteGrupoDesconto(
            @RequestParam(value = "id", required = true) Integer id,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try{
            grupoDescontoRepository.delete(id);
            response = "Deletado com sucesso !";

        }catch(Exception e)
        {
            e.printStackTrace();
            response = "Um erro ocorreu !";
        }
        //redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/opcao-pagamento";
    }

    @GetMapping
    private String grupoDesconto(Model model)
    {
        List<GrupoDesconto> grupoDescontoList = (List<GrupoDesconto>) grupoDescontoRepository.findAll();
        model.addAttribute("itens",grupoDescontoList);
        return "restrito/admin/grupo-desconto";
    }

    @PutMapping
    private String opcaoPagamentoUpdate(Model model,
                                        @Valid GrupoDesconto grupoDesconto)
    {
        try {
            grupoDescontoRepository.save(grupoDesconto);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "restrito/admin/opcao-pagamento";
    }


    @PostMapping
    private String grupoDescontoPost(
            @Valid GrupoDesconto grupoDesconto,
            Model model,
            RedirectAttributes redirectAttributes
    )
    {
        String response;
        try {

            grupoDescontoRepository.save(grupoDesconto);
            response = "success";
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            response = "Já existe um grupo de desconto com esta descrição !";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            response = "Ocorreu um erro!";
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:admin/grupo-desconto";
    }
}
