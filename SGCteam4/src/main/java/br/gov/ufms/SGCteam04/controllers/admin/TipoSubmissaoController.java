package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.TipoSubmissao;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/tipo-submissao")
public class TipoSubmissaoController {

    /*
    @GetMapping("/tipo-submissao")
    private String tipoSubmissao()
    {
        return "restrito/admin/tipo-submissao";
    }

    @PostMapping("/tipo-submissao")
    private String tipoSubmissaoPost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            TipoSubmissao tipoSubmissao = new TipoSubmissao();
            tipoSubmissao.setTipoSubmissao(descricao);
            tipoSubmissaoRepository.save(tipoSubmissao);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe um tipo de submissão com esta descrição !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro aconteceu !");
        }
        return "restrito/admin/tipo-submissao";
    }
    */
}
