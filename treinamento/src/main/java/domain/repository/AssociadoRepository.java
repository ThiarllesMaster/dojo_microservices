/**
 * Interface que contem os métodos simples de CRUD para as chamadas de serviço
 * @author thiarlles.gomes 
 */
package domain.repository;

import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import domain.model.Associado;


public interface AssociadoRepository extends CrudRepository<Associado, Long>{
	
	
	Integer countByNomeAssociado(String name);
	
	List<Associado>queryFirst1ByNomeAssociado(String nome);
	
	List<Associado>findByIdGreaterThan(Integer id);
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	List<Associado>findBynomeAssociado(String name);

}
