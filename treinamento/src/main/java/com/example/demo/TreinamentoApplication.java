package com.example.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Associado;
import domain.repository.AssociadoRepository;

@SpringBootApplication
@EntityScan("domain.model")
@ComponentScan("domain.rest")
@EnableJpaRepositories("domain.repository")
public class TreinamentoApplication {

	private static final Logger log = LoggerFactory.getLogger(TreinamentoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoApplication.class, args);
	}

	@Bean
	public CommandLineRunner treinamento(AssociadoRepository associadoRepository) {
		return (args) -> {
			log.info("Saving the associado");
			Associado associado = new Associado();
			associado.setCpfAssociado("680.338.110-21");
			associado.setNomeAssociado("Thiarlles Duarte Gomes");
			associadoRepository.save(associado);
			Associado associadoDois = new Associado();
			associadoDois.setCpfAssociado("680.338.110-21");
			associadoDois.setNomeAssociado("Thiarlles Duarte Gomes");
			associadoRepository.save(associadoDois);

			Associado optionalAssociado = associadoRepository.findById(associado.getId()).orElse(null);
			Integer numberRecords = associadoRepository.countByNomeAssociado(associado.getNomeAssociado() + "Teste");
			List<Associado> associados = associadoRepository
					.queryFirst1ByNomeAssociado(associadoDois.getNomeAssociado());

			log.info("The associado's name {}", optionalAssociado.getNomeAssociado());
			log.info("The associado's cpf {}", optionalAssociado.getCpfAssociado());
			log.info("The count {}", numberRecords);
			log.info("The size of list only 1 {}", associados.size());

			findIds(associadoRepository);

		};
	}

	
	public List<Long> findIds(AssociadoRepository associadoRepository) {
		return associadoRepository.findBynomeAssociado("Thiarlles Duarte Gomes").stream()
				.filter(e -> !e.getCpfAssociado().isEmpty()).sorted(Comparator.comparing(Associado::getId).reversed())
				.map(Associado::getId).collect(Collectors.toList());

	}

}
