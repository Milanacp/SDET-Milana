package Generic;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/** 
	 * @author Milana
	 * To generate a random number till 10000
	 * @return random number
	 */
	public int createRandomNum()
	{
		Random r = new Random();
		int rand = r.nextInt(10000);
		return rand;
	}
	    
	/**
	 * @author Milana
	 * Generate current system date
	 * @return current system date
	 */
	public String getCurrentSystemDate()
	{
		Date obj = new Date();
		String currentSysDate = obj.toString();
		return currentSysDate;
	}
	
	/**
	 * Generate current month
	 * @return current month
	 */
	@SuppressWarnings("deprecation")
	public int getCurrentMonth()
	{
		Date obj = new Date();
		return obj.getMonth();
	}
	
	/**
	 * @author Milana
	 * Gives current date
	 * @return date
	 */
	public String getDate()
	{
		Date obj = new Date();
		String currentSysDate = obj.toString();
		String arr[] = currentSysDate.split(" ");
		return arr[2];
	}

}
