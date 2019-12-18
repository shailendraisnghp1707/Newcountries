package newcountries;

import java.util.Arrays;

import org.apache.commons.exec.util.StringUtils;

public class SplitWords {

	
	public static void main(String[] args) {
		
		/*
		 * String s = "Pankaj,New York,USA";
		 * 
		 * String[] data = s.split(",", 3);
		 * 
		 * System.out.println("Name = "+data[0]); //Pankaj
		 * 
		 * System.out.println("Address = "+data[1]); //New York,USA
		 * 
		 * System.out.println("Country ="+data[2]);
		 */
		
		String str = "abcd1234";
		String[] part = str.split("(?<=\\D)(?=\\d)");
		System.out.println(part[0]);
		System.out.println(part[1]);
	}
}
