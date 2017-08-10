package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.models.Fase;
import br.gov.ufms.SGCteam04.models.Sessao;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;
import br.gov.ufms.SGCteam04.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;

/**
 * Created by Marco Cardoso on 7/31/2017.
 */
@Controller
@RequestMapping("/admin/sessoes-conferencia")
public class SessaoController {

    @Autowired
    SessaoRepository sessaoRepository;

    @Autowired
    ConferenciaRepository conferenciaRepository;


    @GetMapping
    private ModelAndView getSessao(
            @RequestParam(value = "adc",required = false)String adc,
            @RequestParam(value = "id",required = true)Integer idConferencia
    )
    {
        Conferencia conferencia = conferenciaRepository.findOne(idConferencia);
        Set<Sessao> sessoes = conferencia.getSessaoArrayList();
        ModelAndView modelAndView  = new ModelAndView("restrito/admin/sessoes-conferencia");
        modelAndView.addObject("sessoes",sessoes);
        modelAndView.addObject("obj",conferencia);

        if(adc != null)
        {
            modelAndView.addObject("adc","adc");
        }
        return modelAndView;

    }

    @DeleteMapping
    private String deleteSessao(RedirectAttributes redirectAttributes,
                                          @RequestParam(value = "adc",required =  false)String adc,
                                          @RequestParam(value = "sessao_id",required = true)Long idSessao,
                                          @RequestParam(value = "conferencia_id",required =  true)Integer idConferencia)
    {
        sessaoRepository.delete(idSessao);
        redirectAttributes.addAttribute("id",idConferencia);
        if(adc != null)
            redirectAttributes.addAttribute("adc",adc);
        return "redirect:/admin/sessoes-conferencia";
    }

    @PostMapping
    private String adicionarSessao(
            Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "adc",required = false) String adc,
            @RequestParam(value = "modo",required=false)String modo,
            @RequestParam(value = "id_sessao",required = false)Long sessaoId,
            @RequestParam(value = "id_conferencia",required = true)Integer conferenciaId, @Valid Sessao sessao)
    {
        Conferencia conferencia = conferenciaRepository.findOne(conferenciaId);
        sessao.setConferencia(conferencia);
        sessaoRepository.save(sessao);
        if(modo != null)
        {
            redirectAttributes.addAttribute("filterid",conferenciaId);
            return "redirect:/admin/conferencia/editar";
        }
        else
        {
            model.addAttribute("sessao",null);
            Set<Sessao> sessoes = conferencia.getSessaoArrayList();
            model.addAttribute("sessoes",sessoes);
            model.addAttribute("obj",conferencia);
            if(adc != null)
                model.addAttribute("adc",adc);
            return "restrito/admin/sessoes-conferencia";
            /*
            ModelAndView modelAndView = new ModelAndView("restrito/admin/sessoes-conferencia");
            modelAndView.addObject("sessoes",sessoes);
            modelAndView.addObject("obj",conferencia);

            if(adc != null)
                modelAndView.addObject("adc",adc);


            return modelAndView;*/
        }
    }

}
