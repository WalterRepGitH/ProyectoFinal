package com.someBank.product.account.entity.extern;

import java.util.List;
import java.util.Objects;

import com.someBank.product.account.entity.Account;
import com.someBank.product.credit.entity.Credit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Client {
	
	public enum EType {
		PERSONAL, ENTERPRISE
	}

	private Integer id;
	
	private EType type;
	
	private String name;
	
	private List<Account> accounts;
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
