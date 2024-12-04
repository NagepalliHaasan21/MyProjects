package com.tap.gov;

public class PrimeMinister
{
	private static PrimeMinister pm=new PrimeMinister();
	
	public static PrimeMinister getPM()
	{
		return pm;
	}
	
	public String name = "NaMo";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private PrimeMinister()
	{
	}
}
