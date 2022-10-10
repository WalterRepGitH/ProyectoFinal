package com.someBank.client.entity.extern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MasterAccount {

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