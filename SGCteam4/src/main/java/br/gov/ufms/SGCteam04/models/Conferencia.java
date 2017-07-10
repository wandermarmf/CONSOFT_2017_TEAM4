package br.gov.ufms.SGCteam04.models;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Conferencia {

	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Integer id;

	   @Column(unique=true,nullable = false)
	   private String nomeAbreviado;

	   @Column(unique = true,nullable = false)
	   private String nomeConferencia;

	   @Column(nullable = false)
	   private String subTitulo;

	   private String subTituloSecundario;

	   private String paginaWeb;

	   @Column(nullable = false)
	   private String cidadeConferencia;

	   @Column(nullable = false)
	   private String cidadeEmissaoFatura;

	   @Column(nullable = false)
	   private Double valorTaxaEmissaoFatura;

	   @Column(nullable = false)
	   private String moedaConferencia;

	   @ManyToMany
	   private ArrayList<Topico> topicoArrayList;

	   @ManyToMany
	   private ArrayList<OpcaoPagamento> opcaoPagamentoArrayList;

	   /*
	   TODO criar entidade e repositorio da sessao
	   @OneToMany
	   private ArrayList<Sessao> sessaoArrayList;
		*/

	   /*
	   TODO criar entidade e repositorio da fase da conferencia
	   @OneToMany
	   private ArrayList<ConferenciaFase> conferenciaFaseArrayList;
		*/

	   /*
	   TODO criar entidade e repositorio do evento/produto da conferencia
	   @OneToMany
	   private ArrayList<ConferenciaEventoProduto> conferenciaEventoProdutoArrayList;
		*/

	   /*
	   	TODO criar entidade e repositorio do intervalo desconto da conferencia
	   	@OneTo?????
	   	private ArrayList<IntervaloDescontoConferencia> ...
	    */

	   /*
	   	TODO criar entidade e repositorio da inscricao
	   	@OneToMany
	   	private ArrayList<Inscricao> inscricaoArrayList;
	    */

	   /*
	   TODO criar entidade e repositorio do coordenador
	   @OneTo????
	   private ....
	    */

	   /*
	   TODO criar entidade e repositorio do administrador
	   @OneTo????
	   private ....
	    */

	   @OneToMany
	   private ArrayList<TipoSubmissao> tipoSubmissaoArrayList;

	   @OneToMany
	   private ArrayList<TipoArquivo> tipoArquivoArrayList;

	   /*
	   TODO criar entidade e repositorio do perfil
	   @ManyToMany
	   private ArrayList<Perfil> perfilArrayList;
	    */



	   public Conferencia() {
		// TODO Auto-generated constructor stub
	}

}
