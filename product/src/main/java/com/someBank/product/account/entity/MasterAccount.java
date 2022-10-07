package com.someBank.product.account.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "masterAccount")
public class MasterAccount {
	
	/*public enum EType{
		CURRENT, FIXEDTERM, SAVING
	}*/

	@Id
	private String id;
	
	//private EType type;
	
	private String type;	/*
		C	CURRENT
		F	FIXEDTERM
		S	SAVING
		*/
	
	private double maintanceFee;
	private boolean hasMaximumLimitMovements;
	private double maximumLimitMovements;
	
}
