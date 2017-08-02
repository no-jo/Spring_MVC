package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.controller.BookController;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

	private MockMvc mockMvc;

	@Mock
	private BookService bookService;
	@InjectMocks
	private BookController bookController;

	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(bookController).setViewResolvers(viewResolver).build();
	}

	@Test
	public void shouldShowAllBooks() throws Exception {
		// given
		List<BookTo> allBooks = new ArrayList<BookTo>();
		allBooks.add(new BookTo());
		Mockito.when(bookService.findAllBooks()).thenReturn(allBooks);
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/all"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOKS))
				.andExpect(model().attribute(ModelConstants.BOOK_LIST, allBooks));
	}

	@Test
	public void shouldShowDefaultViewOfFiltering() throws Exception {
		// given when
		ResultActions resultActions = mockMvc.perform(get("/books"));
		// then
		resultActions.andExpect(view().name(ViewNames.FILTER));
	}

	@Test
	public void shouldSearchByCriteria() throws Exception {
		// given
		List<BookTo> allBooks = new ArrayList<BookTo>();
		allBooks.add(new BookTo());
		Mockito.when(bookService.findBooksByAuthor(Mockito.anyString())).thenReturn(allBooks);
		Mockito.when(bookService.findBooksByTitle(Mockito.anyString())).thenReturn(allBooks);
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/find/?title=one&author=two"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOKS))
				.andExpect(model().attribute(ModelConstants.BOOK_LIST, allBooks));
		Mockito.verify(bookService).findBooksByAuthor("two");
		Mockito.verify(bookService).findBooksByTitle("one");
	}

	@Test
	public void shouldDeleteABook() throws Exception {
		// given when
		ResultActions resultActions = mockMvc.perform(get("/books/delete/?id=7"));
		// then
		resultActions.andExpect(view().name(ViewNames.DELETE))
		.andExpect(model().attributeExists(ModelConstants.BOOK));
		Mockito.verify(bookService).deleteBook(7L);
	}

	@Test
	public void shouldShowAddBookPage() throws Exception {
		// given when
		ResultActions resultActions = mockMvc.perform(get("/books/add"));
		// then
		resultActions.andExpect(view().name(ViewNames.ADD_BOOK))
		.andExpect(model().attributeExists("newBook"));
	}

	@Test
	public void shouldInvokeAddBook() throws Exception {
		// given when
		ResultActions resultActions = mockMvc
				.perform(post("/books/add").param("title", "It")
						.param("author", "King").param("status", "LOAN"));
		// then
		Mockito.verify(bookService).saveBook(Mockito.anyObject());
		resultActions.andExpect(view().name(ViewNames.BOOK))
		.andExpect(model().attributeExists(ModelConstants.BOOK));
	}
}
