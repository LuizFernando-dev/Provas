package br.com.makeProva.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.makeProva.infra.saveFile;
import br.com.makeProva.modelo.Questao;
import br.com.makeProva.modelo.Teste;

@Controller
public class HomeController {
	
	private saveFile saveFile;

	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/registra")
	public ModelAndView registra(Teste teste, RedirectAttributes redirect,
			String q1, String q2, String q3, String q4, String resposta, MultipartFile arquivo, String tituloQuest) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maketest");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(teste);
		em.getTransaction().commit();
		
		ModelAndView model = new ModelAndView("/");
		
		String[] respostas = resposta.split(",");
		String[] titulos = tituloQuest.split(",");
		String[] alt1 = q1.split(",");
		String[] alt2 = q2.split(",");
		String[] alt3 = q3.split(",");
		String[] alt4 = q4.split(",");
		
		System.out.println(titulos.length);
			
			System.out.println("tamanho do arrey da q1 "+alt1.length);
			
			for (int i = 0; i < alt1.length; i++) {
				Questao q = new Questao(titulos[i], respostas[i]);
				q.setTeste(teste);
				q.setQ1(alt1[i]);
				q.setQ2(alt2[i]);
				q.setQ3(alt3[i]);
				q.setQ4(alt4[i]);
				q.setArquivo(arquivo.getOriginalFilename());
				em.getTransaction().begin();
				em.persist(q);
				em.getTransaction().commit();
			}		
		
		redirect.addFlashAttribute("msg", "teste realizado com sucesso!");
		redirect.addFlashAttribute("teste", teste);
		
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/responder")
	public ModelAndView responder(int teste, RedirectAttributes redirect, String[] q1) {
		System.out.println("testando pegar a resposta: "+q1);
		System.out.println("tudo certo teste " + teste);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("maketest");
		EntityManager em = emf.createEntityManager();
		Teste test = em.find(Teste.class, teste);

		Query query = em.createQuery("select q from Questao q where q.teste = :teste");
		query.setParameter("teste", test);
		@SuppressWarnings("unchecked")
		List<Questao> questoes = query.getResultList();
		
		System.out.println("valor do teste : " + test.getValor() + "nome do teste: " + test.getTitulo());
		ModelAndView model = new ModelAndView("/responderTeste");
		model.addObject("questoes", questoes);
		model.addObject("test", test);
		model.addObject("index", questoes.size());
		
		return model ;

	}
	
	@RequestMapping("/responderTeste")
	public String responderTeste() {
		return "responderTeste";
	}
	
	@RequestMapping("/corrige")
	public ModelAndView corrige(String resposta, int total, RedirectAttributes redirect) {
		String[] respostas = resposta.split(",");
		int acertos = respostas.length;
		int nota = acertos * 100 / total;
		System.out.println(total + "acertos "+ acertos);
		ModelAndView model  = new ModelAndView("/resultado");
		model.addObject("nota", nota);
		return model;
	}
		
}
