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
public class AccountTransaction {
	
	private String id;
	private String idAccount;
	
	private String typeAccountTransaction;				//	W	WITHDRA	-	D	DEPOSIT
	private LocalDate date;
	private double amount;

}
