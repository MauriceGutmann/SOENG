package de.htwg.retroweb.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.htwg.retroweb.entities.Project;
import de.htwg.retroweb.entities.Retro;
import de.htwg.retroweb.exception.ResourceNotFoundException;
import de.htwg.retroweb.service.ProjectService;
import de.htwg.retroweb.service.RetroService;
import de.htwg.retroweb.service.SessionService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private RetroService retroService;
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
    public String showProjects(@RequestParam long id, Map<String, Object> model, HttpServletRequest request) {
		String page = ControllerConstants.PROJECT;
		
		HttpSession session = request.getSession();
		if (sessionService.isLoggedIn(session)) {
            model.put("userName", sessionService.getUserName(session));
        	model.put("isAdmin", sessionService.isAdmin(session));
        	try { 
    			Project p =projectService.getById(id);
    			model.put("Project1",p);
    			List<Retro> retros = retroService.findByProject(p);
    			model.put("Retros", retros);
    			
    		} catch (ResourceNotFoundException e) {
    			e.printStackTrace();
    		}
        	
        } else {
            page = ControllerConstants.REDIRECT_LOGIN;
        }
		
		return page;
	}
	
}
