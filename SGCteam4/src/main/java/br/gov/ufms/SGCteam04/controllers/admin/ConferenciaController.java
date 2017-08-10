package br.gov.ufms.SGCteam04.controllers.admin;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import br.gov.ufms.SGCteam04.models.*;
import br.gov.ufms.SGCteam04.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/conferencia")
public class ConferenciaController extends CustomController{

	@Autowired
    ConferenciaRepository conferenciaRepository;
	@Autowired
	TipoArquivoRepository tipoArquivoRepository;
	@Autowired
	OpcaoPagamentoRepository opcaoPagamentoRepository;
	@Autowired
	TipoSubmissaoRepository tipoSubmissaoRepository;
	@Autowired
	GrupoParticipanteRepository grupoParticipanteRepository;
	@Autowired
	TopicoRepository topicoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TipoFaseRepository tipoFaseRepository;

	@Autowired
	FaseRepository faseRepository;

	@Autowired
	SessaoRepository sessaoRepository;
	
	// atributos para mainipulação de eventos...
	private Conferencia currentConferencia;
	
	
    public ConferenciaController() {
    	viewModel = "restrito/admin/conferencia";
    	titleForm = "Cadastro de Conferência";
    	titleList = "Listagem de Conferência";
    	statusEdicao = "";
    	continueInsert = false;
    }
    
	@Override
    protected Conferencia getObj() {
		currentConferencia = new Conferencia();
		return currentConferencia;
	}
	
	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	protected <Conferencia> Iterable<Conferencia> getObjList(){
		return (Iterable<Conferencia>) conferenciaRepository.findAll();
	}
	
	@Override
	protected void saveObj(Object obj) {
		currentConferencia = (Conferencia)obj;
		conferenciaRepository.save(currentConferencia);
	}
	
	@Override
	protected Object findObj(Integer id) {
		currentConferencia = conferenciaRepository.findOne(id);
		return currentConferencia;
	}
	
	@Override
	protected boolean deleteObj(Integer id) {
		// Procura o objeto no banco de dados
		currentConferencia = conferenciaRepository.findOne(id);
    	
    	// Se não conseguir encontrar o objeto exibe uma mensagem de erro
    	if (currentConferencia == null) {
    		return false;
    	}
    	else {
    		conferenciaRepository.delete(currentConferencia);
    		return true;
    	}
	}

	@Override
	protected void doGetViewChilds(ModelAndView mv, Model model) {
		// Busca as listas que serão apresentadas na página
		Iterable<TipoSubmissao> listTipoSubmissaoObjs = tipoSubmissaoRepository.findAll();
		Iterable<GrupoParticipante> listParticipanteObjs = grupoParticipanteRepository.findAll();
		Iterable<Topico> listTopicoObjs = topicoRepository.findAll();
		Iterable<TipoArquivo> listArqObjs = tipoArquivoRepository.findAll();
		Iterable<OpcaoPagamento> listPgObjs = opcaoPagamentoRepository.findAll();
		Iterable<Usuario> usuarios  = usuarioRepository.findAll();
		
		// Pega as lista já configuradas da conferencia
		List<TipoSubmissao> listTipoSubmissaoConferencia = currentConferencia.getTipoSubmissaoList();
		List<GrupoParticipante> listGrupoParticipanteConferencia = currentConferencia.getGrupoParticipanteList();
		List<Topico> listTipocoConferencia = currentConferencia.getTopicoList();

		List<TipoArquivo> listArqConferencia = currentConferencia.getTipoArquivoList();
		List<OpcaoPagamento> listOpPgConferencia = currentConferencia.getOpcaoPagamentoList();
		
		// Sinaliza quais estão selecionadas para esta conferencia...
		for (TipoSubmissao obj : listTipoSubmissaoObjs) 
			obj.setSelected(listTipoSubmissaoConferencia.indexOf(obj) != -1);
		
		for (GrupoParticipante obj : listParticipanteObjs) 
			obj.setSelected(listGrupoParticipanteConferencia.indexOf(obj) != -1);
		
		for (Topico obj : listTopicoObjs) 
			obj.setSelected(listTipocoConferencia.indexOf(obj) != -1);

		for (TipoArquivo obj : listArqObjs) 
			obj.setSelected(listArqConferencia.indexOf(obj) != -1);
		
		for (OpcaoPagamento obj : listPgObjs) 
			obj.setSelected(listOpPgConferencia.indexOf(obj) != -1);
		
		mv.addObject("listTipoSubmissaoObjs", listTipoSubmissaoObjs);
		mv.addObject("listParticipanteObjs", listParticipanteObjs);
		mv.addObject("listTopicoObjs", listTopicoObjs);		
		mv.addObject("listArqObjs", listArqObjs);
    	mv.addObject("listPgObjs", listPgObjs);
    	mv.addObject("usuarios",usuarios);
	}
	
	@PostMapping
	private ModelAndView doPostView(@Valid @ModelAttribute("obj") Conferencia obj, @RequestParam(value = "uslt") Long idUsuario,
			      @RequestParam(value = "editar",required = false)String editar,
									BindingResult result, Model model, HttpServletRequest request) {
		
		// guarda o objeto da conferencia que está sendo manipulado
		currentConferencia = obj;
		obj = conferenciaRepository.findOne(obj.getId());
		Usuario administrador = usuarioRepository.findOne(idUsuario);
		if(administrador != null)
			obj.setAdministrador(administrador);


		// Pega as listas do banco de dados...
		Iterable<TipoArquivo> listArqObjs = tipoArquivoRepository.findAll();
		Iterable<OpcaoPagamento> listPgObjs = opcaoPagamentoRepository.findAll();
		Iterable<TipoSubmissao> listTipoSubmissaoObjs = tipoSubmissaoRepository.findAll();
		Iterable<GrupoParticipante> listParticipanteObjs = grupoParticipanteRepository.findAll();
		Iterable<Topico> listTopicoObjs = topicoRepository.findAll();
		
		String paramName, paramValue;
		
		/* Zera a lista de arquivos e opção de pagamento anteriores...*/
		currentConferencia.getTipoArquivoList().clear();
		currentConferencia.getOpcaoPagamentoList().clear();
		
		/* guarda o botão auxiliar, caso seja clicado */
		Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
        	paramName = (String) enumeration.nextElement();
        	paramValue = request.getParameter(paramName);
        	
            if ((paramName == null) || (paramName.length() < 11))
            	continue;
            
            if (CheckOption.isField(paramName, "checklistarq") == true) {
            	currentConferencia.addTipoArquivo(listArqObjs, paramValue);
            } else if (CheckOption.isField(paramName, "checklistpg") == true) {
            	currentConferencia.addOpcaoPagamento(listPgObjs, paramValue);
            } else if (CheckOption.isField(paramName, "checklisttopico") == true) {
            	currentConferencia.addTopico(listTopicoObjs, paramValue);
            } else if (CheckOption.isField(paramName, "checklistparticip") == true) {
            	currentConferencia.addGrupoParticipante(listParticipanteObjs, paramValue);
            } else if (CheckOption.isField(paramName, "checklisttiposub") == true) {
            	currentConferencia.addTipoSubmissao(listTipoSubmissaoObjs, paramValue);
            }            	
        }

        ModelAndView modelAndView = doPostMappingSave(obj, result, model);
        String response = (String) modelAndView.getModel().get("response");
        
        if (response.equals("success")) {
        	paramValue = request.getParameter("buttoncommand");
        	
        	if (CheckOption.isField(paramValue, "fase") == true) {
            	ArrayList<TipoFase> arrayList =(ArrayList<TipoFase>) tipoFaseRepository.findAll();
    			String diretorioFasesConferencia = "restrito/admin/fases-conferencia";
    			modelAndView.getModel().put("obj",obj);
    			modelAndView.getModel().put("tipos",arrayList);
    			modelAndView.getModel().put("adc","conferencia");
    			modelAndView.getModel().put("fases",obj.getConferenciaFaseArrayList());
    			return new ModelAndView(diretorioFasesConferencia,modelAndView.getModel());
        	}
        	else if (CheckOption.isField(paramValue, "sessao") == true) {
    			String diretorioFasesConferencia = "restrito/admin/sessoes-conferencia";
    			modelAndView.getModel().put("obj",obj);
    			modelAndView.getModel().put("adc","conferencia");
				modelAndView.getModel().put("sessoes",obj.getSessaoArrayList());
    			return new ModelAndView(diretorioFasesConferencia,modelAndView.getModel());
        	}
		}
        
		return modelAndView;
	}
}
