package koulu.book.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping("/addbook")
	public String addBook(Model model)
	{
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("/addbook")
	public String saveBook(Book book)
	{
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model)
	{
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
}
