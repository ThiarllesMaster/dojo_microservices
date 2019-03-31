/**
 * Interface que contem os métodos simples de CRUD para as chamadas de serviço
 * @author thiarlles.gomes 
 */
package domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.model.Associado;

@Repository
public interface AssociadoRepository extends CrudRepository<Associado, Long>{
	

}
