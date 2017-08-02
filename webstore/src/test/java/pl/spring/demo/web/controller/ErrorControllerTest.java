package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.controller.ErrorController;

public class ErrorControllerTest {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(new ErrorController()).setViewResolvers(viewResolver).build();
	}

	@Test
	public void shouldInvokeAddBook() throws Exception {
		// given when
		ResultActions resultActions = mockMvc.perform(post("/accessDenied"));
		// then
		resultActions.andExpect(view().name("403"))
		.andExpect(model().attributeExists(ModelConstants.ERROR_MESSAGE));
	}

}
