package bankApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.bank.dbutil.DBConnection;

public class bankApp
{	
	static final String CHECKBALANCE = "SELECT * FROM ACCOUNTTABLE WHERE ACCNO=?";
	static final String DEDUCTBALANCE="UPDATE ACCOUNTTABLE SET BALANCE=BALANCE-? WHERE ACCNO=?";
	static final String ADDBALANCE="UPDATE ACCOUNTTABLE SET BALANCE=BALANCE+? WHERE ACCNO=?";
	static Scanner scan=new Scanner(System.in);
	private static Connection con;
	private static PreparedStatement pstmt;
	private static int balance;
	private static ResultSet result;
	private static int amount;
	private static int rAccNo;
	private static int pin;
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Enter the AccNo");
			int sAccNo=scan.nextInt();
			con=DBConnection.connect();
			pstmt=con.prepareStatement(CHECKBALANCE);
			pstmt.setInt(1,sAccNo);
			result=pstmt.executeQuery();
			
			if(result.next())
			{
				balance=result.getInt("balance");
				System.out.println("User balance is : "+balance);
				
				pin=result.getInt("pin");
				con.setAutoCommit(false);
				
				//Begin of banking transaction
				System.out.println("Enter the amount to be transfered ");
				amount=scan.nextInt();
				
				if(balance>=amount)
				{
					pstmt=con.prepareStatement(DEDUCTBALANCE);
					pstmt.setInt(1,amount);
					pstmt.setInt(2,sAccNo);
					//int x=pstmt.executeUpdate();
					
					if(pstmt.executeUpdate()!=0)
					{
						System.out.println("Enter receiver accNo");
						rAccNo=scan.nextInt();
						pstmt=con.prepareStatement(ADDBALANCE);
						pstmt.setInt(1,amount);
						pstmt.setInt(2,rAccNo);
						if(pstmt.executeUpdate()!=0)
						{
							
							System.out.println("Enter the pin");
							int userPin=scan.nextInt();
							
							if(pin==userPin)
							{
								con.commit();
								System.out.println("success Transaction");
								System.exit(0);
							}
							else
							{
								con.rollback();
								System.out.println("Invalid pin");
							}
						}
						else
						{
							con.rollback();
							System.out.println("Invalid receiver accNo");
						}
					}
					else
					{
						con.rollback();
						System.out.println("Money was not deducted");
					}
				}
				else
				{
					System.out.println("Insufficient Funds");
				}
			}
			else
			{
				System.out.println("No such user");
				System.exit(0);
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
