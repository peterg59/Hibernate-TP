package jpa.hibernate_sample;

import java.util.List;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_version", sequenceName = "seq_version", initialValue = 1, allocationSize = 1)
public class Book {
	
	private String title, author;
	
	@Id
	@GeneratedValue(generator = "seq_version")
	private Integer id;
	
	@ManyToMany(mappedBy = "books")
	private List<Client> clients;
	
	@OneToMany(mappedBy = "favoriteBook")
	private List<Client> clientsFavorite;
	
	public Book() {
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public List<Client> getClients() {
		return clients;
	}
	
	public String toString() {
		return title + " ; " + author;
	}
}
