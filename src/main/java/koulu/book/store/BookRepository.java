package koulu.book.store;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>
{
}
