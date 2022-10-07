package com.someBank.client.entity.extern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Account {
	
	private String id;
	private Integer idClient;
	private String idMasterAccount;
	
	private double availableBalance;
	private int dayOfMonthMovements;

}
