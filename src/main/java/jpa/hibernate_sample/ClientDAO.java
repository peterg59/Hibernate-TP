package jpa.hibernate_sample;

import java.util.*;

import javax.persistence.*;

public class ClientDAO {
	
	public static Client createClient(EntityManager em, String lastName, String firstName, Gender gender) {
		Client client = new Client(lastName, firstName, gender);
		em.persist(client);
		return client;
	}
	
	public static void addBook(EntityManager em, Client client, Book book) {
		client.getBooks().add(book);
		em.merge(client);
		em.merge(book);
	}
}
