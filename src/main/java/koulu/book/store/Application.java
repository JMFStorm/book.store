package koulu.book.store;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner (BookRepository books, CategoryRepository categories)
	{
		return (args) -> {
			
			Category c1 = new Category("Fantasy");
			Category c2 = new Category("Not Fantasy");
			
			// repository.deleteAll();
			categories.save(c1);
			categories.save(c2);
			
			books.save(new Book("Jannen kirja", "Janne", "123232-12", 2020, 99.95d, c1));
			books.save(new Book("Koodarin opas", "Anniina", "334455-12", 2022, 19.95d, c1));
			books.save(new Book("Jannen kirja 2", "Janne", "143423-92", 2020, 199.95d, c1));
		};
	}
}
