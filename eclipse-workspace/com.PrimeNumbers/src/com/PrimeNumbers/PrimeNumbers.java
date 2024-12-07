package com.PrimeNumbers;

import java.util.Scanner;

public class PrimeNumbers
{
	public static void main(String[] args) 
	{
		Scanner scan=new Scanner(System.in);
		int n1=scan.nextInt();
		int n2=scan.nextInt();
		primeNumbers(n1,n2);
	}
	
	public static void primeNumbers(int n1,int n2) 
	{
		
		for(int i=n1;i<n2;i++) 
		{
			if(isPrime(i)) 
			{
				System.out.print(i+" ");
			}
		}
	}
	
	public static boolean isPrime(int n)
	{
		if(n<=1) 
		{
			return false;
		}
		
		for(int i=2;i*i<=n;i++) 
		{
			if(n%i==0) 
			{
				return false;
			}
		}
		return true;
	}
}
