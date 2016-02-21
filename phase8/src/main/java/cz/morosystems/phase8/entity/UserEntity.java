package cz.morosystems.phase8.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "READERTABLE")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ]*")
	@Column(name = "FIRSTNAME")
	private String firstname;

	@NotEmpty
	@Pattern(regexp = "[a-zA-Z0-9 ]*")
	@Column(name = "LASTNAME")
	private String lastname;

	@NotEmpty
	@Email
	@Column(name = "EMAIL")
	private String email;

	@Size(min = 9, max = 13)
	@Pattern(regexp = "[+]?[0-9]*")
	@Column(name = "TELEPHONE")
	private String telephone;

	@ManyToMany(fetch=FetchType.LAZY, targetEntity = cz.morosystems.phase8.entity.BookEntity.class, cascade = { CascadeType.ALL })
	// definice spojeni - tabulka user_book_table musi existovat a obsahuje primarni klice obou tabulek - viz. definice tabulek v readme-db.txt
	@JoinTable(name = "USERS_BOOKS_TABLE", joinColumns = @JoinColumn(name = "USERID") , inverseJoinColumns = @JoinColumn(name = "BOOKID") )
	private Set<BookEntity> books;

	@OneToMany(fetch=FetchType.LAZY, targetEntity = cz.morosystems.phase8.entity.AccountEntity.class, cascade = { CascadeType.ALL})
	@JoinTable(name = "USER_ACCOUNTS_TABLE", joinColumns = @JoinColumn(name = "USERID") , inverseJoinColumns = @JoinColumn(name = "ACCOUNTID") )
	private Set<AccountEntity> accounts;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity = cz.morosystems.phase8.entity.BookEntity.class, cascade = { CascadeType.ALL})
	@JoinTable(name = "USER_FAVOURITEBOOK_TABLE", joinColumns = @JoinColumn(name = "USERID") , inverseJoinColumns = @JoinColumn(name = "BOOKID") )
	private BookEntity favouriteBook;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity = cz.morosystems.phase8.entity.AccountEntity.class, cascade = { CascadeType.ALL})
	@JoinTable(name = "USER_PREFFEREDACCOUNT_TABLE", joinColumns = @JoinColumn(name = "USERID") , inverseJoinColumns = @JoinColumn(name = "ACCOUNTID") )
	private AccountEntity prefferedAccount;

	public Integer getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public Set<BookEntity> getBooks() {
		return books;
	}
	
	public Set<AccountEntity> getAccounts() {
		return accounts;
	}
	
	public BookEntity getFavouriteBook() {
		return favouriteBook;
	}
	
	public AccountEntity getPrefferedAccount() {
		return prefferedAccount;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}
	
	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}
	
	public void setFavouriteBook(BookEntity favouriteBook) {
		this.favouriteBook = favouriteBook;
	}
	
	public void setPrefferedAccount(AccountEntity prefferedAccount) {
		this.prefferedAccount = prefferedAccount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}