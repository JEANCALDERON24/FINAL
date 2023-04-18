package pea2.onpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pea2.onpe.model.examen;

@Repository

public interface Iexamen extends JpaRepository<examen,Integer>{
	@Query(value="{call  sp_getResumen}",nativeQuery = true)
	examen getExamen();
}

