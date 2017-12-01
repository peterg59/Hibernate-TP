package jpa.hibernate_sample;

import javax.persistence.*;

public class BookDAO {
	
	public static Book createBook(EntityManager em, String title, String author) {
		Book book = new Book(title, author);
		em.persist(book);
		return book;
	}
}
