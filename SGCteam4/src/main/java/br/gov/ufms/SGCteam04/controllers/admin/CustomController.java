package br.gov.ufms.SGCteam04.controllers.admin;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public abstract class CustomController {
	protected String viewModel;
	protected String titleForm;
	protected String titleList;
	protected String statusEdicao;
	protected boolean continueInsert = true;
	
	protected abstract Object getObj();
	protected abstract Object findObj(Integer id);
	protected abstract boolean deleteObj(Integer id);
	protected abstract <T> Iterable<T> getObjList();
	protected abstract void saveObj(Object obj);
	
	public CustomController() {
		// TODO Auto-generated constructor stub
	}
	
	protected ModelAndView doPostMappingSave(Object obj, BindingResult result, Model model) {
		
		// cria uma nova visão
		ModelAndView mv = new ModelAndView(viewModel);

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
        
		model.addAttribute("response",response);
    	model.addAttribute("titleForm", titleForm);
    	model.addAttribute("titleList", titleList);
    	model.addAttribute("statusEdicao", "Incluir um novo registro");
    	
        // Carrega o objeto atual (em branco) e a lista de objetos para a view apresentar 
        mv.addObject("obj", obj);
    	mv.addObject("listObjs", getObjList());
    	mv.addObject("response",response);
    	// Adiciona eventuais objetos filhos ao formulário
  		doGetViewChilds(mv, model);
    	
        return mv;  	
	}
	
	protected void doGetViewChilds(ModelAndView mv, Model model) {
	}
	
    @GetMapping 
	public ModelAndView doGetView(Model model) {
    	ModelAndView mv = new ModelAndView(viewModel);
    	mv.addObject("obj", getObj());
    	mv.addObject("listObjs", getObjList());

    	model.addAttribute("titleForm", titleForm);
    	model.addAttribute("titleList", titleList);
  		model.addAttribute("statusEdicao", "Incluir um novo registro");
    	
  		// Adiciona eventuais objetos filhos ao formulário
  		doGetViewChilds(mv, model);
  		
    	return mv; 
    }
    
	@GetMapping(value="/editar")
	public ModelAndView doEditView(@RequestParam(value="filterid", required=true) Integer id, Model model) {
    	ModelAndView mv = new ModelAndView(viewModel);
    	
    	// Procura o objeto no banco de dados
    	Object obj = findObj(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		String response = "Registro não encontrato !";
    		model.addAttribute("response",response);
    	}
    	mv.addObject("obj", obj);
    	mv.addObject("listObjs", getObjList());

    	// Adiciona eventuais objetos filhos ao formulário
  		doGetViewChilds(mv, model);
    	
    	model.addAttribute("titleForm", titleForm);
    	model.addAttribute("titleList", titleList);
    	model.addAttribute("statusEdicao", "Editando o registro");

    	return mv; 
    }
	
	@GetMapping(value="/apagar")
	public ModelAndView doDeleteView(@RequestParam(value="filterid", required=true) Integer id, Model model) {
    	ModelAndView mv = new ModelAndView(viewModel);
    	
    	// Dispara a rotina que apaga o registro do banco de dados...
    	if (deleteObj(id) == false) {
    		// não encontrou/apagou o registro
    		String response = "Registro não encontrato !";
    		model.addAttribute("response",response);
    	}
    	else {
    		model.addAttribute("deletereg", "ok");
    	}
    		
    	
    	// Retorna um "Obj" vazio e a lista restante dos objetos
    	mv.addObject("obj", getObj());
    	mv.addObject("listObjs", getObjList());
    	
    	// Adiciona eventuais objetos filhos ao formulário
  		doGetViewChilds(mv, model);
  		
    	model.addAttribute("titleForm", titleForm);
    	model.addAttribute("titleList", titleList);
    	model.addAttribute("statusEdicao", "Incluir um novo registro");

    	return mv; 
    }

}
