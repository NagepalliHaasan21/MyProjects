package com.tap.services;

import com.tap.gov.PrimeMinister;
import com.tap.interfaces.Services;

public class IndianNavy implements Services
{
	@Override
	public void addressPM()
	{
		PrimeMinister pm= PrimeMinister.getPM();
		System.out.println("IndianNavy says prime minister is "+pm);
	}
}
