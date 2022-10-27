package spring.mvc.atlas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.mvc.atlas.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{

	@Query(value = "select * from paises p where p.continente = :continente", nativeQuery = true)
	List<Pais> findByContinente(String continente);

	Pais findByNome(String nomePais);
	
}
