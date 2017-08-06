package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.models.Fase;
import br.gov.ufms.SGCteam04.models.Sessao;
import br.gov.ufms.SGCteam04.models.TipoFase;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;
import br.gov.ufms.SGCteam04.repositories.FaseRepository;
import br.gov.ufms.SGCteam04.repositories.SessaoRepository;
import br.gov.ufms.SGCteam04.repositories.TipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

/**
 * Created by Marco Cardoso on 8/5/2017.
 */
@Controller
@RequestMapping("/admin/fase")
public class FaseControllerEdit {


    @Autowired
    FaseRepository faseRepository;

    @Autowired
    ConferenciaRepository conferenciaRepository;

    @Autowired
    TipoFaseRepository tipoFaseRepository;

    @GetMapping("/edit")
    private String editLinkFase(
            @RequestParam(value = "id")Long id,
            @RequestParam(value = "conferencia_id")Integer conferencia_id,
            Model model
    )
    {
        Conferencia conferencia = conferenciaRepository.findOne(conferencia_id);
        model.addAttribute("obj",conferencia);
        Fase fase = faseRepository.findOne(id);
        ArrayList<TipoFase> arrayList = (ArrayList<TipoFase>) tipoFaseRepository.findAll();
        model.addAttribute("fase",fase);
        model.addAttribute("origem","editarFase");
        model.addAttribute("tipos",arrayList);
        return "restrito/admin/fases-conferencia";
    }

    @DeleteMapping
    private String deleteFase(
            @RequestParam(value = "id",required = true)Long id,
            @RequestParam(value = "conferencia_id",required = true)Long conferenciaId,
            RedirectAttributes redirectAttributes
    )
    {
        try{
            faseRepository.delete(id);
            redirectAttributes.addAttribute("filterid",conferenciaId);
            return "redirect:/admin/conferencia/editar";
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
