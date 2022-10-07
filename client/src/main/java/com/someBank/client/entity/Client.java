package com.someBank.client.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.someBank.client.entity.extern.Account;
import com.someBank.client.entity.extern.Credit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class Client {
	
	public enum EType {
		PERSONAL, ENTERPRISE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column( nullable = false, length = 15, name = "type" )
	@Enumerated(value=EnumType.STRING)
	private EType type;
	
	@Column( nullable = false, length = 60, name = "name" )
	private String name;
	
	@Transient
	private List<Account> accounts;
	@Transient
	private List<Credit> credits;
	
	@Override
	public int hashCode() {
		return Objects.hash(accounts, credits, id, name, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(credits, other.credits)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && type == other.type;
	}
	
	
	
}