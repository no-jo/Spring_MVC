package pl.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.service.BookService;
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
	public ModelAndView list(Model model) {
		// TODO: implement default method uzupelnic ten model o ksiazki
		return allBooks();
		// return ViewNames.BOOKS;
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
	public ModelAndView filteredBooks(@RequestParam("id") String id) {
		List<BookTo> bookTos = bookService.findBookByID(id);
		// bookService.findAllBooks();
		ModelAndView modelAndView = new ModelAndView();
		if (bookTos.size() == 1) {
			modelAndView.addObject(ModelConstants.BOOK, bookTos.get(0));
		}
		modelAndView.setViewName(ViewNames.BOOK);
		return modelAndView;
	}
	// TODO: here implement methods which displays book info based on query
	// arguments

	// TODO: Implement GET / POST methods for "add book" functionality

	/**
	 * Binder initialization
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "title", "authors", "status");
	}
}
