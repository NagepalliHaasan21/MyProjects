
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.bank.dbutil.DBConnection;

public class newClass
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
			//result=pstmt.executeQuery();
			//pstmt.addBatch();
			result=pstmt.executeQuery();
			
			if(result.next()) 
			{
					balance=result.getInt("balance");
					pin=result.getInt("pin");
				
					System.out.println("Enter the amount to be transfered ");
					amount=scan.nextInt();
					
					if(balance>=amount)
					{
				
						pstmt=con.prepareStatement(DEDUCTBALANCE);
						pstmt.setInt(1,amount);
						pstmt.setInt(2,sAccNo);
						//int x=pstmt.executeUpdate();
						pstmt.addBatch();
						
						System.out.println("Enter receiver accNo");
						rAccNo=scan.nextInt();
						pstmt=con.prepareStatement(ADDBALANCE);
						
						pstmt.setInt(1,amount);
						pstmt.setInt(2,rAccNo);
						pstmt.addBatch();
						
						System.out.println("Enter the pin number");
						int userPin=scan.nextInt();
						
						if(pin==userPin)
						{
							pstmt.executeBatch();
							System.out.println("Transaction Success");
						}
						else
						{
							System.out.println("Wrong Pin");
							System.exit(0);
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
