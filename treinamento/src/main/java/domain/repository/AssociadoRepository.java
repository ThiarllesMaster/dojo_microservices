/**
 * Interface que contem os métodos simples de CRUD para as chamadas de serviço
 * @author thiarlles.gomes 
 */
package domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.model.Associado;

@Repository
public interface AssociadoRepository extends CrudRepository<Associado, Long>{
	
	Integer countByNomeAssociado(String name);
	
	List<Associado>findByIdGreaterThan(Integer id);

}
