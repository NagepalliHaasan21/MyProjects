package com.tap.services;

import com.tap.gov.PrimeMinister;
import com.tap.interfaces.Services;

public class IndianAirForce implements Services
{
	@Override
	public void addressPM()
	{
		PrimeMinister pm= PrimeMinister.getPM();
		System.out.println("IndianAirForce says prime minister is "+pm);
	}
}
