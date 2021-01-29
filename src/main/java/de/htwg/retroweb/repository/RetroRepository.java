package de.htwg.retroweb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import de.htwg.retroweb.entities.Project;
import de.htwg.retroweb.entities.Retro;

public interface RetroRepository extends JpaRepository<Retro, Long> {
	List<Retro> findByProject(Project project);
	
	@Transactional
	@Modifying
	@Query("update Retro r set r.name = ?1, r.scheduled = ?2, r.active = ?3, r.updated = ?4 where r.id = ?5")
	int update(String name, Date schedule, boolean active, Date updated, long id);	
}
