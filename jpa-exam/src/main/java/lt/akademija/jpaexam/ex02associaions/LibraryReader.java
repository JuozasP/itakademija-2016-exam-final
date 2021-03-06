package lt.akademija.jpaexam.ex02associaions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LibraryReader {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    
    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    private List<LibraryReaderAddress> addresses;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Book> borrowedBooks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBorrowedBooks() {
        if (borrowedBooks == null) {
            borrowedBooks = new ArrayList<>();
        }
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public List<LibraryReaderAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<LibraryReaderAddress> addresses) {
        this.addresses = addresses;
    }

    public void addBorrowedBook(Book b) {
          if (borrowedBooks == null) {
              borrowedBooks = new ArrayList<>();
          }
        borrowedBooks.add(b);
        b.addBookReader(this);
    }
}
