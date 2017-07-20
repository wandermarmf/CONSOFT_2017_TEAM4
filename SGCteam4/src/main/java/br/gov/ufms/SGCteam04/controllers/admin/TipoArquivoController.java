package br.gov.ufms.SGCteam04.controllers.admin;

import br.gov.ufms.SGCteam04.models.TipoArquivo;
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
@RequestMapping("/admin/tipo-arquivo")
public class TipoArquivoController {


    /*
    @GetMapping("/tipo-arquivo")
    private String tipoArquivo()
    {
        return "restrito/admin/tipo-arquivo";
    }

    @PostMapping("/tipo-arquivo")
    private String tipoArquivoPost(
            Model model,
            @RequestParam(value = "descricao",required = true) String descricao
    )
    {
        try {
            TipoArquivo tipoArquivo = new TipoArquivo();
            tipoArquivo.setTipoArquivo(descricao);
            tipoArquivoRepository.save(tipoArquivo);
            model.addAttribute("response","success");
        }
        catch(DataIntegrityViolationException d)
        {
            d.printStackTrace();
            model.addAttribute("response","Já existe um tipo de arquivo com esta descrição !");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            model.addAttribute("response","Um erro aconteceu !");
        }



        return "restrito/admin/tipo-arquivo";
    }
    */

}
