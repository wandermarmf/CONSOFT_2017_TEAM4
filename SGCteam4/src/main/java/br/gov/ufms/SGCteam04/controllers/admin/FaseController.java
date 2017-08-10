package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.models.Fase;
import br.gov.ufms.SGCteam04.models.TipoFase;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;
import br.gov.ufms.SGCteam04.repositories.FaseRepository;
import br.gov.ufms.SGCteam04.repositories.TipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Marco Cardoso on 7/30/2017.
 */
@Controller
@RequestMapping("/admin/fases-conferencia")
public class FaseController {

    @Autowired
    FaseRepository faseRepository;

    @Autowired
    ConferenciaRepository conferenciaRepository;

    @Autowired
    TipoFaseRepository tipoFaseRepository;

    @GetMapping
    private ModelAndView faseConferenciaPage(@RequestParam(value = "id",required = true)Integer idConferencia,
                                             @RequestParam(value = "adc",required = false)String adc)
    {
        Conferencia conferencia = conferenciaRepository.findOne(idConferencia);
        List<TipoFase> tipos = (ArrayList<TipoFase>) tipoFaseRepository.findAll();


        Set<Fase> fases = conferencia.getConferenciaFaseArrayList();
        ModelAndView modelAndView  = new ModelAndView("restrito/admin/fases-conferencia");
        modelAndView.addObject("fases",fases);
        modelAndView.addObject("obj",conferencia);
        modelAndView.addObject("tipos",tipos);

        if(adc != null)
        {
            modelAndView.addObject("adc","adc");
        }
        return modelAndView;
    }

    @DeleteMapping
    private String deleteFaseOfConference(RedirectAttributes redirectAttributes,
                                          @RequestParam(value = "adc",required =  false)String adc,
                                          @RequestParam(value = "fase_id",required = true)Long idFase,
                                            @RequestParam(value = "conferencia_id",required =  true)Integer idConferencia)
    {
        faseRepository.delete(idFase);
        redirectAttributes.addAttribute("id",idConferencia);
        if(adc != null)
            redirectAttributes.addAttribute("adc",adc);
        return "redirect:/admin/fases-conferencia";
    }

    @PostMapping
    private String adicionarFaseAConferencia(Model model,
                                             RedirectAttributes redirectAttributes,
            @RequestParam(value = "adc",required = false) String adc,
                                             @RequestParam(value = "modo",required=false)String modo,
                                             @RequestParam(value = "id_fase",required = false)Long faseId,
            @RequestParam(value = "conferencia_id",required = true)Integer conferenciaId, @Valid Fase fase,
            @RequestParam(value = "tipolst",required = true)Integer idTipoFase)
    {

        Conferencia conferencia = conferenciaRepository.findOne(conferenciaId);
        TipoFase tipoFase = tipoFaseRepository.findOne(idTipoFase);
        fase.setTipoFase(tipoFase);
        fase.setConferencia(conferencia);
        faseRepository.save(fase);
        if(modo!= null)
        {
            redirectAttributes.addAttribute("filterid",conferenciaId);
            return "redirect:/admin/conferencia/editar";
        }
        else
        {
            model.addAttribute("fase",null);
            Set<Fase> fases = conferencia.getConferenciaFaseArrayList();
            model.addAttribute("fases",fases);
            model.addAttribute("obj",conferencia);
            model.addAttribute("adc",adc);
            model.addAttribute("tipos",tipoFaseRepository.findAll());
            return "restrito/admin/fases-conferencia";
        }

        /*
        ModelAndView modelAndView = new ModelAndView("restrito/admin/fases-conferencia");
        modelAndView.addObject("fases",fases);
        modelAndView.addObject("obj",conferencia);

        if(adc != null)
            modelAndView.addObject("adc",adc);

        return modelAndView;*/
    }

}
