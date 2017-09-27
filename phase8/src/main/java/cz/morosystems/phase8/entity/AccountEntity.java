package cz.morosystems.phase8.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ACCOUNTTABLE")
public class AccountEntity {
	
	// POZN: messages jsou loadovany z errormessages.properties umisteneho v resources
	
	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	@Column(name="NAME")
	private String name;
	
	@NotEmpty @Pattern(regexp = "[0-9]*")
	@Column(name="ACCOUNTPREFIX")
	private String accountPrefix;
	
	@NotEmpty @Pattern(regexp = "[0-9]*")
	@Column(name="ACCOUNTNUMBER")
	private String accountNumber;
	
	@NotEmpty @Pattern(regexp = "[0-9]*")
	@Column(name="BANKCODE")
	private String bankCode;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAccountPrefix() {
		return accountPrefix;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccountPrefix(String accountPrefix) {
		this.accountPrefix = accountPrefix;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountPrefix == null) ? 0 : accountPrefix.hashCode());
		result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		AccountEntity other = (AccountEntity) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountPrefix == null) {
			if (other.accountPrefix != null)
				return false;
		} else if (!accountPrefix.equals(other.accountPrefix))
			return false;
		if (bankCode == null) {
			if (other.bankCode != null)
				return false;
		} else if (!bankCode.equals(other.bankCode))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
