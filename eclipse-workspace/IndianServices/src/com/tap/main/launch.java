package com.tap.main;

import com.tap.factory.ObjFactory;
import com.tap.interfaces.Services;
import com.tap.services.IndianAirForce;
import com.tap.services.IndianArmy;
import com.tap.services.IndianNavy;

public class launch 
{
	public static void main(String[] args)
	{
		Services ia	= ObjFactory.giveObject("x");
		Services in	= ObjFactory.giveObject("y");
		Services iaf= ObjFactory.giveObject("z");
		
		ia.addressPM();
		in.addressPM();
		iaf.addressPM();
	}
}
