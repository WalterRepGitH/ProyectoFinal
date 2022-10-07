package com.someBank.client.entity.extern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Credit {
	
	private String id;

	private Integer idClient;
	
	private /*ETypeCredit*/String idTypeCredit;	//	P	E	C
	private double creditAmount;
	private double availableCredit;

}
