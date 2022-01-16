package koulu.book.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;
	
	@Column
	public String title;
	
	@Column
	public String author;
	
	@Column
	public String isbn;
	
	@Column
	public int year;
	
	@Column
	public double price;
	
	
	public Book()
	{
	}
	
	public Book(String title, String author, String isbn, int year, double price)
	{
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return this.title;
	}
}
