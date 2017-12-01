package jpa.hibernate_sample;

import java.awt.Window.Type;
import java.util.*;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "seq_client", sequenceName = "seq_client", initialValue = 1, allocationSize = 1)
public class Client {
	
	private String lastName, firstName;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Id
	@GeneratedValue(generator = "seq_client")
	private Integer id;
	
	@ManyToMany
	private List<Book> books;
	
	@ManyToOne
	private Book favoriteBook;
	
	public Client() {
		
	}
	
	public Client(String lastName, String firstName, Gender gender) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
		books = new ArrayList();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public int getId() {
		return id;
	}
	public Gender getGender() {
		return gender;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public String toString() {
		return lastName + " ; " + firstName + " ; " + gender;
	}

}
