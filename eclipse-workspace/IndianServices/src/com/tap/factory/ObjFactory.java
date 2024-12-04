package com.tap.factory;

import com.tap.interfaces.Services;
import com.tap.services.IndianAirForce;
import com.tap.services.IndianArmy;
import com.tap.services.IndianNavy;

public class ObjFactory
{
	public static Services giveObject(String obj)
	{
		if(obj.equals("x"))
		{
			return new IndianArmy();
		}
		else if(obj.equals("y"))
		{
			return new IndianNavy();
		}
		else if(obj.equals("z"))
		{
			return new IndianAirForce();
		}
		else
		{
			return null;
		}
	}
}
