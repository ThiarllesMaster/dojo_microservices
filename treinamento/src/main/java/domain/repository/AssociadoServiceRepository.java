package domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import domain.model.Associado;

@Repository
public interface AssociadoServiceRepository extends PagingAndSortingRepository<Associado, Integer>{

	Page<Associado>findByNomeAssociadoStartingWith(String nome, Pageable pageable);
}
