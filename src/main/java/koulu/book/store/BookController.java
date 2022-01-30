package koulu.book.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController
{
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository cRepository; 
	
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
		model.addAttribute("categories", cRepository.findAll());
		return "addbook";
	}
	
	@PostMapping("/addbook")
	public String saveBook(Book book)
	{
		repository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model)
	{
		Book currentBook = repository.findById(bookId).get();
		model.addAttribute("book", currentBook);
		return "editbook";
	}
	
	@PostMapping("/editbook/save/{id}")
	public String saveEditBook(@PathVariable("id") Long bookId, Book book)
	{
		if (repository.existsById(bookId))
		{
			Book currentBook = repository.findById(bookId).get();
			currentBook.author = book.author;
			currentBook.title = book.title;
			currentBook.isbn = book.isbn;
			currentBook.year = book.year;
			
			repository.save(currentBook);
		}
		
		return "redirect:../../booklist";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model)
	{
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
}
