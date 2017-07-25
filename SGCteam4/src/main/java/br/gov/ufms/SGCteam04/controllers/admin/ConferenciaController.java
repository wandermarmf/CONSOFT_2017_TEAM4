package br.gov.ufms.SGCteam04.controllers.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.ufms.SGCteam04.models.Conferencia;
import br.gov.ufms.SGCteam04.repositories.ConferenciaRepository;

@Controller
@RequestMapping("/admin/conferencia")
public class ConferenciaController extends CustomController{

	private String buttonCommand = "";
	
	@Autowired
    ConferenciaRepository conferenciaRepository;
    
    public ConferenciaController() {
    	viewModel = "restrito/admin/conferencia";
    	titleForm = "Cadastro de Conferência";
    	titleList = "Listagem de Conferência";
    	statusEdicao = "";
    	continueInsert = false;
    }
    
	@Override
    protected Conferencia getObj() {
		return new Conferencia();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <Conferencia> Iterable<Conferencia> getObjList(){
		return (Iterable<Conferencia>) conferenciaRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		conferenciaRepository.save((Conferencia)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return conferenciaRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	Conferencia obj = conferenciaRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		conferenciaRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") Conferencia obj, 
			      BindingResult result, Model model, HttpServletRequest request) {
		 
		/* guarda o botão auxiliar, caso seja clicado */
		buttonCommand = request.getParameter("buttoncommand");

        return doPostMappingSave(obj, result, model);
	}
	
	protected ModelAndView doPostMappingSave(Object obj, BindingResult result, Model model) {
		
		String response;
        try {
            // Se for um objecto válido
        	if (obj != null) {
        		//Grava o objeto...
        		saveObj(obj);
        		response = "success";
        	}
        	else
        		response = "Objecto inválido";
        	
            // Cria um novo objeto para preparar a tela para um novo registro...
        	if (continueInsert == true)
        		obj = getObj();            
        }
        catch(DataIntegrityViolationException d)
        {
            response = "Já existe um registro com estes dados !";
        }
        catch(Exception e)
        {
            response = "Ocorreu um erro:" + e.getMessage();
        }
        
        if (response.equals("success") == false) {
        	model.addAttribute("response", response);
        	return showViewConferencia(obj, result, model);
        } else
        if (buttonCommand.equals("registraarq")) {
        	return showViewConferenciaTipoArqivo(obj, result, model);
        } else if (buttonCommand.equals("registraop")) {
        	return showViewConferenciaOpcaoPagamento(obj, result, model);
        } else {
        	return showViewConferencia(obj, result, model);
        }

	}
        
    private ModelAndView showViewConferencia(Object obj, BindingResult result, Model model) {
        // cria uma nova visão
		ModelAndView mv = new ModelAndView(viewModel);

    	model.addAttribute("titleForm", titleForm);
    	model.addAttribute("titleList", titleList);
    	model.addAttribute("statusEdicao", "Incluir um novo registro");
    	
        // Carrega o objeto atual (em branco) e a lista de objetos para a view apresentar 
        mv.addObject("obj", obj);
    	mv.addObject("listObjs", getObjList());
    	
        return mv;  	
    }
    
    private ModelAndView showViewConferenciaTipoArqivo(Object obj, BindingResult result, Model model) {
    	
    }
    
    private ModelAndView showViewConferenciaOpcaoPagamento(Object obj, BindingResult result, Model model) {
    	
    }

}
