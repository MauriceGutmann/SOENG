package de.htwg.retroweb.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import de.htwg.retroweb.entities.Project;
import de.htwg.retroweb.entities.Retro;
import de.htwg.retroweb.service.ProjectService;
import de.htwg.retroweb.service.RetroService;
import de.htwg.retroweb.service.SessionService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
@AutoConfigureMockMvc
public class ProjectControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private SessionService sessionService;
	
	@MockBean
	private RetroService retroService;
	
	@MockBean
	private ProjectService projectService;
	
	private MockHttpSession mockSession;
	
	@Mock
	private Project p;
	
	@Mock
	private List<Retro> retros;
	
	@Before
	public void initializeData(){
		mockSession = new MockHttpSession();
	}
	
	@Test
	public void testShowProject() throws Exception {
		when(sessionService.isLoggedIn(mockSession)).thenReturn(true);
		when(sessionService.getUserName(mockSession)).thenReturn("test");
		when(sessionService.isAdmin(mockSession)).thenReturn(false);
		
		when(projectService.getById(123l)).thenReturn(p);
		
		when(retroService.listAll()).thenReturn(retros);
		
		mvc.perform(MockMvcRequestBuilders.get("/project").session(mockSession).param("id", "123"))
		.andExpect(model().size(4))
		.andExpect(model().attribute("userName", "test"))
		.andExpect(model().attribute("Project1", p ))
		.andExpect(model().attribute("Retros", retros ))
		.andExpect(status().isOk())
		.andExpect(view().name("project"))
		.andExpect(forwardedUrl("/WEB-INF/jsp/project.jsp"));
	}
	
	@Test
	public void testShowProjectWithoutLogin() throws Exception {
		when(sessionService.isLoggedIn(mockSession)).thenReturn(false);
		
		mvc.perform(MockMvcRequestBuilders.get("/project").session(mockSession).param("id", "123"))
		.andExpect(model().size(0))
		.andExpect(status().is(302))
		.andExpect(view().name("redirect:/login"))
		.andExpect(redirectedUrl("/login"));
	}
}