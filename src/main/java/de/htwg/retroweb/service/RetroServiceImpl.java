package de.htwg.retroweb.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.htwg.retroweb.entities.Project;
import de.htwg.retroweb.entities.Retro;
import de.htwg.retroweb.exception.ResourceAlreadyExistsException;
import de.htwg.retroweb.exception.ResourceNotFoundException;
import de.htwg.retroweb.repository.RetroRepository;

@Service
public class RetroServiceImpl implements RetroService {
	
	private static final String RETRO = "Retro";

	@Autowired
	private RetroRepository retroRepository;
	
	@Override
	public Retro getById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return retroRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException(RETRO, "id", id));
	}

	@Override
	public Retro update(Retro domainObject) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
	}
	@Override
	public List<Retro> listAll() {
		return retroRepository.findAll();
	}

	@Override
	public List<Retro> findByProject(Project project) {
		return retroRepository.findByProject(project);
	}

	@Override
	public Retro save(Retro domainObject) throws ResourceAlreadyExistsException {
		domainObject.setUpdated(new Date()); 
		int result = retroRepository.update(domainObject.getName(), domainObject.getScheduled(), domainObject.isActive(), domainObject.getUpdated(), domainObject.getId());
		if(result < 1) {
    		throw new ResourceAlreadyExistsException("User", "id", domainObject.getId());
    	}
		return null;
	}

}
