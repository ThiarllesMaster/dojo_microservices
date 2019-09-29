package domain.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.model.Associado;
import domain.repository.AssociadoRepository;

@RestController
public class AssociadoRest {

	@Autowired
	AssociadoRepository associadoRepository;
	
	@GetMapping(value = "/associados")
	public Iterable<Associado> getAssociado() {
		return associadoRepository.findAll();
	}
	
	@PostMapping(value = "/associados")
	public HttpStatus cadastrarAssociado(@RequestBody Associado associado) {
	    associadoRepository.save(associado);
		return HttpStatus.CREATED;
	}
	
	@PutMapping(value = "/associados")
	public HttpStatus atualizarAssociado(@RequestBody Associado associado) {
		associadoRepository.save(associado);
		return HttpStatus.OK;
	}
	
	@DeleteMapping(value = "/associados")
	public HttpStatus removerAssociado(@RequestBody Associado associado) {
		 associadoRepository.delete(associado);
		 return HttpStatus.OK;
		
	}
	
	@RequestMapping(path="/associados/{id}", method = RequestMethod.GET)
	public Optional<Associado> obterAssociado(@PathVariable("id") Long id) {
		return associadoRepository.findById(id);
	}
	
	
}
