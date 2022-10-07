package com.someBank.product.credit.entity;

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

@Document(collection = "creditTransaction")
public class CreditTransaction {
	
	/*public enum EType{
		CONSUMPTION, PAYMENT
	}*/

	@Id
	private String id;
	private String idCredit;
	
	private String typeCreditTransaction;	//	C	P
	
	private LocalDate date;
	private double amount;
	
}
