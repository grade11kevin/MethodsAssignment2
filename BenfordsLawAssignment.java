import java.util.*;
import java.util.Arrays;
import java.io.*;

public class BenfordsLawAssignment {

	public static void main(String[] args) throws IOException{
	
		String salesFile = "sales.csv";
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader(salesFile));

		ArrayList<String> readFile = new ArrayList<>();
		int fileLength = 0;
		String[] current = new String[2];

		br.readLine();
		while((line = br.readLine()) != null){
			current = line.split(",");
			readFile.add(current[1]);
			fileLength++;
		}
		Collections.sort(readFile);


		//System.out.println(readFile);
		//System.out.println("size of file: " + fileLength);

		String [] fileArray = new String[fileLength];
		String [] saleAmt = new String[fileLength];
		char[] numOne = new char[fileLength];
		int[] firstDigitInt = new int[fileLength];

		for(int i = 0; i < fileLength; i++){
			fileArray[i] = readFile.get(i);
			saleAmt[i] = fileArray[i].substring(4);
			numOne[i] = saleAmt[i].charAt(0);
			firstDigitInt[i] = Character.getNumericValue(numOne[i]);
		}

		int count = 0;
		int allocate = 0;
		int[] frequency = new int[9];
		for(int j = 1; j < 10; j++){
			count = 0;
			for(int k = 0; k <firstDigitInt.length; k++){
				if(firstDigitInt[k] == j){
					count++;
				}
			}
			frequency[allocate] = count;
			allocate++;
		}
	}

}
