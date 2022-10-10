package com.someBank.product.credit.entity;

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

@Document(collection = "credit")
public class Credit {
	
	/*public enum ETypeCredit{
		PERSONAL, ENTERPRISE, CARD
	}*/

	@Id
	private String id;

	private Integer idClient;
	
	private /*ETypeCredit*/String idTypeCredit;	//	P	E	C
	private double creditAmount;
	private double availableCredit;
	
	//private List<CreditTransaction> creditTransactions;

	
}
