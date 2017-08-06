package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.models.Sessao;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;
import br.gov.ufms.SGCteam04.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Marco Cardoso on 8/5/2017.
 */
@Controller
@RequestMapping("/admin/sessao")
public class SessaoControllerEdit {


    @Autowired
    SessaoRepository sessaoRepository;

    @Autowired
    ConferenciaRepository conferenciaRepository;


    @GetMapping("/edit")
    private String editLinkSessao(
            @RequestParam(value = "id")Long id,
            @RequestParam(value = "conferencia_id")Integer conferencia_id,
            Model model
    )
    {
        Conferencia conferencia = conferenciaRepository.findOne(conferencia_id);
        model.addAttribute("obj",conferencia);
        Sessao sessao = sessaoRepository.findOne(id);
        model.addAttribute("sessao",sessao);
        model.addAttribute("origem","editarSessao");
        return "restrito/admin/sessoes-conferencia";
    }

    @DeleteMapping
    private String deleteSessao(
            @RequestParam(value = "id",required = true)Long id,
            @RequestParam(value = "conferencia_id",required = true)Long conferenciaId,
            RedirectAttributes redirectAttributes
    )
    {
        try{
            sessaoRepository.delete(id);
            redirectAttributes.addAttribute("filterid",conferenciaId);
            return "redirect:/admin/conferencia/editar";
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
