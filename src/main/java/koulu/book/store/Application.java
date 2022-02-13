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
	CommandLineRunner commandLineRunner (BookRepository bRepo, CategoryRepository cRepo, UserRepository uRepo)
	{
		return (args) -> {
			
			Category c1 = new Category("Fantasy");
			Category c2 = new Category("Not Fantasy");
			cRepo.save(c1);
			cRepo.save(c2);
			
			bRepo.save(new Book("Jannen kirja", "Janne", "123232-12", 2020, 99.95d, c1));
			bRepo.save(new Book("Koodarin opas", "Anniina", "334455-12", 2022, 19.95d, c1));
			bRepo.save(new Book("Jannen kirja 2", "Janne", "143423-92", 2020, 199.95d, c1));
			
			// salasana1, $2a$10$zglslVQzVVoDs7zZyjJvD.4luHBHutb7YyaMoJaop.tV8I1QZ81FS
			User user1 = new User("user", "$2a$10$zglslVQzVVoDs7zZyjJvD.4luHBHutb7YyaMoJaop.tV8I1QZ81FS", "USER");
			
			// salasana2, $2a$10$npkdSVK4nk/98dfSoMwr9u1B2ZiV7aFESeI2p8jtVhC0.T1V17jDO
			User user2 = new User("admin", "$2a$10$npkdSVK4nk/98dfSoMwr9u1B2ZiV7aFESeI2p8jtVhC0.T1V17jDO", "ADMIN");
			
			uRepo.save(user1);
			uRepo.save(user2);
		};
	}
}
