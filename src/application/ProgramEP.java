package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class ProgramEP {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		String inPath = "c:\\temp\\source.csv";
		String outPath = "c:\\temp\\out\\summary.csv";
		List<Product> products = new ArrayList<>();

		readFile(inPath, outPath, products);

	}

	public static void readFile(String iPath, String oPath, List<Product> rProducts) {

		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(iPath))) {
			while ((line = br.readLine()) != null) {
				String[] metadata = line.split(",");
				String item = metadata[0];
				double dblPrice = Double.parseDouble(metadata[1]);
				int intQuantity = Integer.parseInt(metadata[2]);
				rProducts.add(new Product(item, dblPrice, intQuantity));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		writeFile(oPath, rProducts);
	}

	public static void writeFile(String oPath, List<Product> wProducts) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(oPath))) {
			for (Product prod : wProducts) {
				bw.write(prod.getItem() + ", " + String.format("%.2f", prod.totalValue()));
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Terminated!");
		}
	}
}
