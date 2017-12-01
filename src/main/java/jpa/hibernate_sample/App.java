package jpa.hibernate_sample;

import java.util.*;

import javax.persistence.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManager em = DatabaseHelper.createEntityManager();

		DatabaseHelper.beginTx(em);

		Book book1 = BookDAO.createBook(em, "Le seigneur des anneaux", "J.R.R Tolkien");
		Book book2 = BookDAO.createBook(em, "Dragon Ball", "Akira Toriyama");
		Book book3 = BookDAO.createBook(em, "One Piece", "Eichiro Oda");
		Book book4 = BookDAO.createBook(em, "Star Wars", "George Lucas");

		Client client1 = ClientDAO.createClient(em,"Guyard", "Pierre", Gender.M);
		Client client2 = ClientDAO.createClient(em,"Joseph", "Caleb", Gender.M);
		Client client3 = ClientDAO.createClient(em,"Tan", "Julie", Gender.F);
		
		ClientDAO.addBook(em, client1, book1);
		ClientDAO.addBook(em, client1, book2);
		ClientDAO.addBook(em, client2, book4);
		ClientDAO.addBook(em, client3, book2);
		ClientDAO.addBook(em, client2, book1);

		DatabaseHelper.commitTxAndClose(em);

		em = DatabaseHelper.createEntityManager();

		// Quelles livres ont été achetées par un certain client
		
		TypedQuery<Book> query = em.createQuery("select distinct b from Book b inner join b.clients clients where clients.id = :id", Book.class);
		query.setParameter("id", client1.getId());
		List<Book> list = query.getResultList();
		for (Book b : list) {
			System.out.println(b);
		}
		
		// Quels clients ont acheté un certain livre
		
		TypedQuery<Client> queryClient = em.createQuery("select distinct c from Client c inner join c.books books where books.id = :id", Client.class);
		queryClient.setParameter("id", book1.getId());
		List<Client> listClient = queryClient.getResultList();
		for (Client c : listClient) {
			System.out.println(c);
		}
		
		// Quels livres ont été achetés
		
		TypedQuery<Book> queryBook = em.createQuery("select distinct b from Book b inner join b.clients", Book.class);
		List<Book> listBook = queryBook.getResultList();
		for (Book b : listBook) {
			System.out.println(b);
		}

		em.close();
	}
}
