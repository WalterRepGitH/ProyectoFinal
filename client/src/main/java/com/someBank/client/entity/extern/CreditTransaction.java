package com.someBank.client.entity.extern;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CreditTransaction {
	
	private String id;
	private String idCredit;
	
	private String typeCreditTransaction;	//	C	P
	
	private LocalDate date;
	private double amount;

}
