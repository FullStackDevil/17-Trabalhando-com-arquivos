package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProgramEP {

	public static void main(String[] args) throws IOException {

		String inPath = "c:\\temp\\source.csv";
		
		Files.createDirectories(Paths.get("c:\\temp\\out"));
		
		String outPath = "c:\\temp\\out\\summary.csv";

		File file = new File(outPath);
		if (file.exists()) {
			file.delete();
		}

		readingFile(inPath, outPath);

	}

	public static void readingFile(String iPath, String oPath) {

		String line0 = "";

		try (BufferedReader br = new BufferedReader(new FileReader(iPath))) {
			while ((line0 = br.readLine()) != null) {
				String[] metadata = line0.split(",");
				String item = metadata[0].toString();
				Double dblPrice = Double.parseDouble(metadata[1].toString());
				Double dblQuantity = Double.parseDouble(metadata[2].toString());
				Double total = dblPrice * dblQuantity;
				String line1 = (item + ", " + String.format("%.2f", total));
				writingFile(oPath, line1);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void writingFile(String oPath, String line) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(oPath, true))) {
			bw.write(line);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
