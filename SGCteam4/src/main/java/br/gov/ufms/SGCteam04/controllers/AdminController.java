package br.gov.ufms.SGCteam04.controllers;

import br.gov.ufms.SGCteam04.models.TipoFase;
import br.gov.ufms.SGCteam04.repositories.TipoFaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Marco Cardoso on 7/9/2017.
 */
@Controller()
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    TipoFaseRepository tipoFaseRepository;

    @GetMapping("/tipo-fase")
    private String tipoFase()
    {
        return "restrito/tipo-fase";
    }

    @PostMapping("/tipo-fase")
    private String tipoFasePost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            TipoFase fase = new TipoFase();
            fase.setDescricao(descricao);
            tipoFaseRepository.save(fase);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Fase com descrição já existente !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro aconteceu !");
        }



        return "restrito/tipo-fase";
    }

}
