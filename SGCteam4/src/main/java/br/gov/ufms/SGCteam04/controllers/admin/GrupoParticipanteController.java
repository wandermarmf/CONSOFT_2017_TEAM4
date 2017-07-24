package br.gov.ufms.SGCteam04.controllers.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.ufms.SGCteam04.models.GrupoParticipante;
import br.gov.ufms.SGCteam04.repositories.GrupoParticipanteRepository;

/**
 * Created by Marco Cardoso on 7/17/2017.
 */
@Controller
@RequestMapping("/admin/grupo-participante")
public class GrupoParticipanteController extends CustomController {

    @Autowired
    GrupoParticipanteRepository grupoParticipanteRepository;

    public GrupoParticipanteController() {
    	viewModel = "restrito/admin/grupo-participante";
    	titleForm = "Cadastro de Grupos de Participantes";
    	titleList = "Listagem de Grupos de Participantes";
    	statusEdicao = "";
    }
    
	@Override
    protected GrupoParticipante getObj() {
		return new GrupoParticipante();
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <GrupoParticipante> Iterable<GrupoParticipante> getObjList(){
		return (Iterable<GrupoParticipante>) grupoParticipanteRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		grupoParticipanteRepository.save((GrupoParticipante)obj);
	}
	
	@Override
	protected Object findObj(Integer id) {
		return grupoParticipanteRepository.findOne(id);
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
    	GrupoParticipante obj = grupoParticipanteRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (obj == null) {
    		return false;
    	}
    	else {
    		grupoParticipanteRepository.delete(obj);
    		return true;
    	}
	}

	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") GrupoParticipante obj, 
			      BindingResult result, Model model) {
		 
		return doPostMappingSave(obj, result, model);
	}
	
}
