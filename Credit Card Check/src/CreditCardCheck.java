import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditCardCheck
	{

		public static void main(String[] args) throws FileNotFoundException
			{
				Scanner file = new Scanner (new File("CreditCardNumbers.txt"));
				
				int counter = 0;
				
				while(file.hasNext())
				{
					//just initializing these arrays and numbers
					String credit = file.nextLine();
					long creditCardNumber = Long.parseLong(credit);
					long[] separatedNumbers = new long[16];
					
					//separating into an array
					for(int i = 15; i >= 0; i--)
					{
						long digit = creditCardNumber % 10;
						separatedNumbers[i] = digit;
						creditCardNumber  = creditCardNumber / 10;
					}
					
					//want new array with the modified for Luhn check
					for (int i = 0; i < 16; i+=2)
					{
						long doubledNumber = separatedNumbers[i] * 2;
						if(doubledNumber > 9)
							{
								long[] summedDigits = new long[2];
								summedDigits[0] = doubledNumber % 10;
								doubledNumber = doubledNumber / 10;
								summedDigits[1] = doubledNumber;
								
								doubledNumber = summedDigits[0] + summedDigits[1];
							}
						separatedNumbers[i] = doubledNumber;
					}
					
					/*for (long l: separatedNumbers)
						{
							System.out.print(l);
						}
					System.out.println();*/
					
					//now add and check for final luhn plus count
					int sum = 0;
					for (int i = 0; i < 16; i++)
						{
							sum += separatedNumbers[i];
						}
					if (sum % 10 == 0)
						{
							counter++;
						}
					//System.out.println(sum);
					
					
				}
				System.out.println("There are \"" + counter + "\" valid cards in this set.");
				
			}

	}