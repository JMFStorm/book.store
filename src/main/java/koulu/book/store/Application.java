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
	CommandLineRunner commandLineRunner (BookRepository repository)
	{
		return (args) -> {
			repository.deleteAll();
			repository.save(new Book("Jannen kirja", "Janne", "123232-12", 2020, 99.95d));
			repository.save(new Book("Koodarin opas", "Anniina", "334455-12", 2022, 19.95d));
			repository.save(new Book("Jannen kirja 2", "Janne", "143423-92", 2020, 199.95d));
		};
	}
}
