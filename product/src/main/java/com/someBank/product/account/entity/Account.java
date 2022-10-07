package com.someBank.product.account.entity;

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

@Document(collection = "account")
public class Account {
	
	@Id
	private String id;
	private Integer idClient;
	private String idMasterAccount;
	
	private double availableBalance;
	private int dayOfMonthMovements;
	
/*	private List<String> holders;
	private List<String> signatories;*/
	

	//private List<AccountTransaction> accountTransactions;
	
	

}
