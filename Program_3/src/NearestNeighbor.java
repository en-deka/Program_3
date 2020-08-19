//******************************************************************************************************			
//	Programming Fundamentals			Program 3
//
//	NearestNeighbor.java				Allison Fischer
//******************************************************************************************************

import java.io.*;
import java.util.Scanner;

public class NearestNeighbor {

	double[][] trainingVal = new double[75][4];

	static String[] trainingClass = new String[75];

	double[][] testingVal = new double[75][4];

	String[] testingClass = new String[75];

	String[] testingClassAccurate = new String[75];

	double[][] val2;

	

	void main(String[] args) {

		System.out.println(
				"Programming Fundamentals \nNAME: Allison Fischer \nPROGRAMMING ASSIGNMENT 3 \n\nEnter the name of the training file: ");

		Scanner scan = new Scanner(System.in);

		String trainingFileName = scan.nextLine();

		loadTrainingData(trainingFileName);

		System.out.println("\nEnter the name of the testing file: ");

		String testingFileName = scan.nextLine();

		loadTestingData(testingFileName);

		TestSamples();

		calcAccuracy();

		scan.close();
	}

	 void TestSamples() {
	
		
	}

	void calcAccuracy() {

		int count = 0;

		for (int s = 0; s < testingClass.length; s++) {

			if (testingClass[s].equalsIgnoreCase(testingClassAccurate[s])) {
				count++;
			}
		}

		double accuracy = (double) count / (double) testingClass.length;

		System.out.println(" count: " + count);

		System.out.println(" ACCURACY: " + accuracy);

	}

	void analyzeTestSamples() {

		System.out.println("EX#: TRUE LABEL, PREDICTED LABEL");

		for (int i = 0; i < testingVal.length; i++) {

			double testingSample[] = testingVal[i];

			double smallestKnownDistance = 0.0;

			double currentDistance = 0.0;

			int smallestIndex = 0;

			for (int j = 0; j < trainingVal.length; j++) {

				double trainingSample[] = trainingVal[j];

				currentDistance = calculateDistance(testingVal, trainingVal);

				if (j == 0) {

					smallestKnownDistance = currentDistance;
				}

				if (currentDistance < smallestKnownDistance) {

					smallestKnownDistance = currentDistance;

					smallestIndex = j;
				}
			}

			testingClassAccurate[i] = trainingClass[smallestIndex];

			System.out.println(i + 1 + ":" + testingClass[i] + " " + testingClassAccurate[i]);

		}
	}

	private double calculateDistance(double[][] testingVal2) {
	
		return 0;
	}

	double calculateDistance(double[][] testingVal2, double[][] trainingVal2) {

		val2 = trainingVal2;
		
		
		double distance = Math.sqrt(Math.pow(val2[0] -- testingVal2[0]), 2)

				+ Math.pow(trainingVal2[1] -- testingVal2[1], 2) + Math.pow(trainingVal2[2] - testingVal2[2], 2)

				+ Math.pow(trainingVal2[3] -- testingVal2[3], 2));

		return distance;
	}

	void loadTestingData(String testingFileName) {

		BufferedReader br = null;

		String line = " ";

		String cvsSplitBy = ",";

		int rowCount = 0;

		try {

			br = new BufferedReader(new FileReader(testingFileName));

			while ((line = br.readLine()) != null) {

				String[] row = line.split(cvsSplitBy);

				testingVal[rowCount][0] = Double.valueOf(row[0]);

				testingVal[rowCount][1] = Double.valueOf(row[1]);

				testingVal[rowCount][2] = Double.valueOf(row[2]);

				testingVal[rowCount][3] = Double.valueOf(row[3]);

				testingClass[rowCount] = row[4];

				rowCount++;

			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {

			if (br != null) {

				try {

					br.close();
				}

				catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}

	private static void loadTrainingData(String trainingFileName) {

		BufferedReader br = null;

		String line = "";

		String cvsSplitBy = ",";

		int rowCount = 0;

		try {

			br = new BufferedReader(new FileReader(trainingFileName));

			while ((line = br.readLine()) != null) {

				String[] row = line.split(cvsSplitBy);

				Double[][] trainingSamples = null;
				trainingSamples[rowCount][0] = Double.valueOf(row[0]);

				trainingSamples[rowCount][1] = Double.valueOf(row[1]);

				trainingSamples[rowCount][2] = Double.valueOf(row[2]);

				trainingSamples[rowCount][3] = Double.valueOf(row[3]);

				trainingClass[rowCount] = row[4];

				rowCount++;

			}

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		finally {

			if (br != null) {

				try {
					br.close();
				}

				catch (IOException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
