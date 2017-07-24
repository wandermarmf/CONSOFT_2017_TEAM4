package br.gov.ufms.SGCteam04.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.gov.ufms.SGCteam04.models.TipoSubmissao;
import br.gov.ufms.SGCteam04.models.TipoSubmissao;
import br.gov.ufms.SGCteam04.repositories.TipoSubmissaoRepository;

@Controller
@RequestMapping("/admin/tipo-submissao")
public class TipoSubmissaoController {

    @Autowired
    TipoSubmissaoRepository tipoSubmissaoRepository;
    
    //RequestMapping(value="", method = RequestMethod.GET)
    @GetMapping 
	public ModelAndView doGetView(Model model) {
    	ModelAndView mv = new ModelAndView("restrito/admin/tipo-submissao");
    	mv.addObject("obj", new TipoSubmissao());
    	mv.addObject("listObjs", tipoSubmissaoRepository.findAll());
    	
    	return mv; 
    }
	
	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") TipoSubmissao obj, 
		      BindingResult result, Model model) {
		
		// cria uma nova visão
		ModelAndView mv = new ModelAndView("restrito/admin/tipo-submissao");
		
		String response;
        try {
            // Se for um objecto válido
        	if (obj != null) {
        		//Grava o objeto...
        		tipoSubmissaoRepository.save(obj);
        		response = "success";
        	}
        	else
        		response = "Objecto inválido";
        	
            // Cria um novo objeto para preparar a tela para um novo registro...
        	obj = new TipoSubmissao();            
        }
        catch(DataIntegrityViolationException d)
        {
            response = "Já existe um registro com estes dados !";
        }
        catch(Exception e)
        {
            response = "Ocorreu um erro!";
        }
        
        model.addAttribute("response",response);
    	
        // Carrega o objeto atual (em branco) e a lista de objetos para a view apresentar 
        mv.addObject("obj", obj);
    	mv.addObject("listObjs", tipoSubmissaoRepository.findAll());
    	
        return mv;  	
	}
	
	@GetMapping(value="/editar")
	public ModelAndView doEditView(@RequestParam(value="filterid", required=true) Integer id, Model model) {
    	ModelAndView mv = new ModelAndView("restrito/admin/tipo-submissao");
    	
    	// Procura o objeto no banco de dados
    	TipoSubmissao obj = tipoSubmissaoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		String response = "Registro não encontrato !";
    		model.addAttribute("response",response);
    	}
    	mv.addObject("obj", obj);
    	mv.addObject("listObjs", tipoSubmissaoRepository.findAll());
    	
    	return mv; 
    }
	
	@GetMapping(value="/apagar")
	public ModelAndView doDeleteView(@RequestParam(value="filterid", required=true) Integer id, Model model) {
    	ModelAndView mv = new ModelAndView("restrito/admin/tipo-submissao");
    	
    	// Procura o objeto no banco de dados
    	TipoSubmissao obj = tipoSubmissaoRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		String response = "Registro não encontrato !";
    		model.addAttribute("response",response);
    	}
    	else {
    		tipoSubmissaoRepository.delete(obj);
    	}
    	
    	mv.addObject("obj", obj);
    	mv.addObject("listObjs", tipoSubmissaoRepository.findAll());
    	
    	return mv; 
    }
	
}
