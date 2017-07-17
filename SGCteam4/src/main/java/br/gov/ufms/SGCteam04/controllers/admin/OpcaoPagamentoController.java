package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.OpcaoPagamento;
import br.gov.ufms.SGCteam04.repositories.OpcaoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marco Cardoso on 7/16/2017.
 */
@Controller
@RequestMapping("/admin/opcao-pagamento")
public class OpcaoPagamentoController {


    @Autowired
    OpcaoPagamentoRepository opcaoPagamentoRepository;


    @DeleteMapping
    private String deleteOpcaoPagamento(
            @RequestParam(value = "id", required = true) Integer id,
            RedirectAttributes redirectAttributes
    )
    {
        String response = "";
        try{
            opcaoPagamentoRepository.delete(id);
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
    private String opcaoPagamento(Model model)
    {
        List<OpcaoPagamento> opcaoPagamentos = (List<OpcaoPagamento>) opcaoPagamentoRepository.findAll();
        model.addAttribute("itens",opcaoPagamentos);
        return "restrito/admin/opcao-pagamento";
    }

    @PutMapping
    private String opcaoPagamentoUpdate(Model model,
                                        @Valid OpcaoPagamento opcaoPagamento)
    {
        try {
            opcaoPagamentoRepository.save(opcaoPagamento);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "restrito/admin/opcao-pagamento";
    }

    @PostMapping
    private String opcaoPagamentoPost(
            Model model,
            @Valid OpcaoPagamento opcaoPagamento,
            RedirectAttributes redirectAttributes
    )
    {
        String response  = "";
        try {
            opcaoPagamentoRepository.save(opcaoPagamento);
            response = "success";
        }
        catch(DataIntegrityViolationException d)
        {
            response = "Já existe uma opcao de pagamento com esta descricao !";
            d.printStackTrace();
        }
        catch(Exception e)
        {
            response = "Um erro ocorreu";
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("response",response);
        return "redirect:/admin/opcao-pagamento";
    }

}
