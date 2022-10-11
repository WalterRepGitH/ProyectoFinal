package com.someBank.client.extern.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MasterAccount {

	public enum EType{
		CURRENT, FIXEDTERM, SAVING
	}

	private String id;
	
	private EType type;
	
	private double maintanceFee;
	private boolean hasMaximumLimitMovements;
	private double maximumLimitMovements;
	
}