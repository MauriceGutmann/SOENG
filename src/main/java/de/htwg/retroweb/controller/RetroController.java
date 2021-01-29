package de.htwg.retroweb.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import de.htwg.retroweb.entities.Retro;
import de.htwg.retroweb.exception.ResourceAlreadyExistsException;
import de.htwg.retroweb.exception.ResourceNotFoundException;
import de.htwg.retroweb.service.RetroService;
import de.htwg.retroweb.service.SessionService;

@Controller
public class RetroController {
	@Autowired
	private SessionService sessionService;
	@Autowired
	private RetroService retroService;
	
	@RequestMapping(value = "/retro", method = RequestMethod.GET)
    public String showRetros(@RequestParam long id, Map<String, Object> model, HttpServletRequest request) {
		String page = ControllerConstants.RETRO;
		HttpSession session = request.getSession();
		if (sessionService.isLoggedIn(session)) {
            model.put("userName", sessionService.getUserName(session));
        	model.put("isAdmin", sessionService.isAdmin(session));
        	try { 
        		Retro r = retroService.getById(id);
        		model.put("Retro", r);
        		

    		} catch (ResourceNotFoundException e) {
    			e.printStackTrace();
    		}
        	
        } else {
            page = ControllerConstants.REDIRECT_LOGIN;
        }
		
		return page;
	}
	
	@RequestMapping(value = "/retro", method = RequestMethod.POST)
    public String updateRetro(@RequestParam long id, @RequestParam String name, @RequestParam String scheduled, @RequestParam(defaultValue = "false") boolean active, Map<String, Object> model, HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	String page = ControllerConstants.REDIRECT_LOGIN;
    	if (sessionService.isLoggedIn(session)) {
    		page = ControllerConstants.REDIRECT_HOME;
    	
    		Retro retro = new Retro();
    		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    		retro.setId(id);
    		retro.setName(name);
    		retro.setActive(active);
    		try {
				retro.setScheduled(date1.parse(scheduled));
				retroService.save(retro);
    		}
			catch (ResourceAlreadyExistsException e) {
					session.setAttribute(ControllerConstants.ERROR_MSG, e.getMessage());
					e.printStackTrace();
				}
			catch (ParseException e1) {
				e1.printStackTrace();
			}
    	}
    	return page;
    }
}