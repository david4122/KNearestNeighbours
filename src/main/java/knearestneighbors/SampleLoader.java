package knearestneighbors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class SampleLoader {

	private String filename;

	public SampleLoader(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public LinkedList<Sample> load(){
		LinkedList<Sample> result = new LinkedList<Sample>();
		try (Scanner sc = new Scanner(new File(this.filename))) {
			while(sc.hasNextLine()){
				result.add(parseSample(sc.nextLine()));
			}
		} catch(FileNotFoundException e){
			throw new RuntimeException(e);
		}
		return result;
	}

	private Sample parseSample(String line) {
		String[] args = line.split(",");
		return new Sample(args[0], Double.parseDouble(args[1]), Double.parseDouble(args[2]));
	}
}
