package com.someBank.product.account.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(collection = "accountTransaction")
public class AccountTransaction {
	
	/*public enum EType{
		WITHDRAW, DEPOSIT
	}*/
	
	@Id
	private String id;
	private String idAccount;
	
	private String typeAccountTransaction;				//	W	WITHDRA	-	D	DEPOSIT
	private LocalDate date;
	private double amount;

}