package koulu.book.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController
{
	@Autowired
	private BookRepository repository;
	
	@GetMapping("/booklist")
	public String getBooklist(Model model)
	{
		Iterable<Book> books = repository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
}
