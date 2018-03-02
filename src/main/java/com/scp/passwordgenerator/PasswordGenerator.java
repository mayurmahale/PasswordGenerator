package com.scp.passwordgenerator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;



enum PasswordStrength
{
	LOW,
	MEDIUM,
	HIGH
}



public class PasswordGenerator
{
	public static final String CAPITALCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static final String SMALLCHARS = "abcdefghijklmnopqrstuvwxyz";
	
	//public static final String CAPITALANDSMALLCHARS = CAPITALCHARS+SMALLCHARS;
	
	public static final String DIGITS = "0123456789";
	
	public static final String SYMBOLS = "!@#$%&*()_+-=[]|,./?><";
	
	//public static final String ALLCHARS = CAPITALCHARS+SMALLCHARS+DIGITS+SYMBOLS;
	
	
	public static String generatePassword(PasswordStrength pwdStrength, int minLength, int maxLength)
	{
		
		String password = "";
		PasswordStrength pwdStrength1 = pwdStrength;
		
		if(pwdStrength1 == PasswordStrength.HIGH)
		{
			int getDigit;
			int digit = ThreadLocalRandom.current().nextInt(minLength, ++maxLength);
			System.out.println("Your Password length is: " + digit);
			
			for(int i=0; i<digit; i++)
			{
				getDigit = ThreadLocalRandom.current().nextInt(0, 10);
				
				if(getDigit < 3)
				{
					password = password + CAPITALCHARS.charAt(ThreadLocalRandom.current().nextInt(0, 26));
				}
				else if(getDigit < 5)
				{
					password = password + SMALLCHARS.charAt(ThreadLocalRandom.current().nextInt(0, 26));
				}
				else if(getDigit < 8)
				{
					password = password + DIGITS.charAt(ThreadLocalRandom.current().nextInt(0, 10));
				}
				else
				{
					password = password + SYMBOLS.charAt(ThreadLocalRandom.current().nextInt(0, 22));
				}
			}
		}
		else if(pwdStrength1 == PasswordStrength.MEDIUM)
		{
			int getDigit;
			int digit = ThreadLocalRandom.current().nextInt(minLength, ++maxLength);
			System.out.println("Your Password length is: " + digit);
			
			for(int i=0; i<digit; i++)
			{
				getDigit = ThreadLocalRandom.current().nextInt(0, 10);
				
				if(getDigit < 4)
				{
					password = password + CAPITALCHARS.charAt(ThreadLocalRandom.current().nextInt(0, 26));
				}
				else if(getDigit < 7)
				{
					password = password + SMALLCHARS.charAt(ThreadLocalRandom.current().nextInt(0, 26));
				}
				else
				{
					password = password + DIGITS.charAt(ThreadLocalRandom.current().nextInt(0, 10));
				}
			}
			
			
		}
		else
		{
			int digit = ThreadLocalRandom.current().nextInt(minLength, ++maxLength);
			System.out.println("Your Password length is: " + digit);
			
			for(int i = 0; i<digit; i++)
			{
				password = password + String.valueOf(ThreadLocalRandom.current().nextInt(0, 10));
			}
	
		}
		
		return password;
	}
	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int choice;
		PasswordStrength pwdStrength;
		String password = "";
		int minLength;
		int maxLength;
		
		System.out.println("1. LOW");
		System.out.println("2. MEDIUM");
		System.out.println("3. HIGH");
		System.out.println();
		
		System.out.println("Enter password strength");
		choice = sc.nextInt();
		
		switch(choice)
		{
			case 1:	pwdStrength = PasswordStrength.LOW;
			
					try
					{
						System.out.println("Enter minimum length of password");
						minLength = sc.nextInt();
						
						if(minLength<1)
						{
							System.out.println("Minimum length should not be zero or less than zero.");
							return;
						}
						
						System.out.println("Enter maximum length of password");
						maxLength = sc.nextInt();
						
						password = generatePassword(pwdStrength, minLength, maxLength);
						System.out.println("Password is: " + password);
						
					}
					catch(IllegalArgumentException | InputMismatchException e)
					{
						//e.printStackTrace();
						System.out.println("Invalid input. Please enter only number");
					}
					finally
					{
						if(sc!=null)
							sc.close();
					}
					
					break;
			
			case 2:	pwdStrength = PasswordStrength.MEDIUM;
			
					try
					{
						System.out.println("Enter minimum length of password");
						minLength = sc.nextInt();
						
						if(minLength<1)
						{
							System.out.println("Minimum length should not be zero or less than zero.");
							return;
						}
				
						System.out.println("Enter maximum length of password");
						maxLength = sc.nextInt();
						
						password = generatePassword(pwdStrength, minLength, maxLength);
						System.out.println("Password is: " + password);
					}
					catch(IllegalArgumentException | InputMismatchException e)
					{
						//e.printStackTrace();
						System.out.println("Invalid input. Please enter only number");
					}
					finally
					{
						if(sc!=null)
							sc.close();
					}
					break;
			
			case 3:	pwdStrength = PasswordStrength.HIGH;
			
					try
					{
						System.out.println("Enter minimum length of password");
						minLength = sc.nextInt();
						
						if(minLength<1)
						{
							System.out.println("Minimum length should not be zero or less than zero.");
							return;
						}
				
						System.out.println("Enter maximum length of password");
						maxLength = sc.nextInt();
						
						password = generatePassword(pwdStrength, minLength, maxLength);
						System.out.println("Password is: " + password);
					}
					catch(IllegalArgumentException | InputMismatchException e)
					{
						//e.printStackTrace();
						System.out.println("Invalid input. Please enter only number");
					}
					finally
					{
						if(sc!=null)
							sc.close();
					}
					break;
			
			default: System.out.println("You entered wrong choice. Please try again.");
		}
		
	}

}
