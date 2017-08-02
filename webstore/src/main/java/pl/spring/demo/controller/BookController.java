package pl.spring.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.service.BookService;
import pl.spring.demo.service.impl.AmbiguousIdException;
import pl.spring.demo.to.BookTo;

/**
 * Book controller
 * 
 * @author mmotowid
 *
 */
@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	//
	// @RequestMapping
	// public String list(Model model) {
	// // TODO: implement default method
	// return ViewNames.BOOKS;
	// }

	@RequestMapping
	public String list(Model model) {
		// TODO: implement default method uzupelnic ten model o ksiazki
		// return allBooks();
		return ViewNames.FILTER;
	}

	/**
	 * Method collects info about all books
	 */
	@RequestMapping("/all")
	public ModelAndView allBooks() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.BOOK_LIST, bookService.findAllBooks());
		modelAndView.setViewName(ViewNames.BOOKS);
		return modelAndView;
	}

	@RequestMapping("/book")
	//TODO spring moze od razu rzutowac string na long, nie ma pozniej 
	public ModelAndView singleBookById(@RequestParam("id") String id) throws AmbiguousIdException {
		BookTo bookTo = bookService.findBookByID(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.BOOK, bookTo);
		modelAndView.setViewName(ViewNames.BOOK);
		return modelAndView;
	}

	// TODO: here implement methods which displays book info based on query
	// arguments
	@RequestMapping(value = "/find")
	public ModelAndView booksBySearchCriteria(@RequestParam("title") String title,
			@RequestParam("author") String author) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(ViewNames.BOOKS);
		List<BookTo> foundBooks = bookService.findBooksByAuthor(author).stream()
				.filter(bookService.findBooksByTitle(title)::contains)
				.collect(Collectors.toList());
		modelAndView.addObject(ModelConstants.BOOK_LIST, foundBooks);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addBook() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("newBook", new BookTo());
		modelAndView.setViewName(ViewNames.ADD_BOOK);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createBook(@ModelAttribute("newBook") BookTo bookTo) {
		bookService.saveBook(bookTo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(ModelConstants.BOOK, bookTo);
		modelAndView.setViewName(ViewNames.BOOK);
		return modelAndView;
	} 
	
	@RequestMapping(value = "/delete")
	public ModelAndView deleteBook(@ModelAttribute("bookToRemove") BookTo bookTo) {
		ModelAndView modelAndView = new ModelAndView();
		bookService.deleteBook(bookTo.getId());
		modelAndView.addObject(ModelConstants.BOOK, bookTo);
		modelAndView.setViewName(ViewNames.DELETE);
		return modelAndView;
	}

	/**
	 * Binder initialization
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "title", "authors", "status");
	}
}
