package tests;

import static org.junit.Assert.assertTrue;

import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.TreinamentoApplication;

import domain.model.Associado;
import domain.repository.AssociadoServiceRepository;

@ContextConfiguration(classes = TreinamentoApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class TestLearning {

	@Autowired
	AssociadoServiceRepository assoicadoService;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	
	@Test
	public void test() {
		Associado associado = new Associado();
		associado.setCpfAssociado("680.338.110-21");
		associado.setNomeAssociado("Thiarlles Duarte Gomes");
		testEntityManager.persist(associado);
		
		Associado associado2 = new Associado();
		associado2.setCpfAssociado("680.338.110-21");
		associado2.setNomeAssociado("Thiarlles Duarte Gomes");
		testEntityManager.persist(associado2);
		testEntityManager.flush();

		testEntityManager.flush();
		
		Page<Associado>associadoPage = assoicadoService.findAll(PageRequest.of(0, 1));
		Page<Associado>thiarllesPages = assoicadoService.findByNomeAssociadoStartingWith("Th", PageRequest.of(0, 2));
	    assertTrue(thiarllesPages.stream().collect(Collectors.toList()).size() == 2);
	
	}

}
