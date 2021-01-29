package de.htwg.retroweb.service;

import java.util.List;

import de.htwg.retroweb.entities.Project;
import de.htwg.retroweb.entities.Retro;

public interface RetroService extends CRUDable<Retro> {
	public List<Retro>findByProject(Project project);
	public List<Retro> listAll();
}
