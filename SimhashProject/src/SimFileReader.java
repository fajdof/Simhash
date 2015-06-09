

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SimFileReader {
	private BufferedReader buffy;
	private int N;
	
	public SimFileReader(String file) {
		try {
			buffy = new BufferedReader (new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//public SimFileReader(InputStream in) {
		//buffy = new BufferedReader (new InputStreamReader(in));
	//}
	
	public List<String> readFile() {
		List<String> lista = new ArrayList<String>();
		String line = null;
		String komadici;
		
		try {
			line = buffy.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		komadici = line.trim();
		N = Integer.parseInt(komadici);
		try {
			for (int i=0; i<N; i++) {
				line = buffy.readLine();
				lista.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void processQueries(List<int[]> shlista) {
		String line = null;
		String[] komadici;
		
		try {
			line = buffy.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		komadici = line.split(" ");
		int Q = Integer.parseInt(komadici[0]);
		
		try {
			for (int j=0; j<Q; j++) {
				line = buffy.readLine();
				komadici = line.split(" ");
				int I = Integer.parseInt(komadici[0]);
				int K = Integer.parseInt(komadici[1]);
				int brojac = 0;
				for (int g=0;g<N;g++) {
					if (g!=I) {
						int br = 0;
						for (int z = 0; z<128;z++) {
							if (shlista.get(I)[z]!=shlista.get(g)[z]) {
								br++;
							}
						}
						if (br<K+1) {
							brojac++;
						}
					}
				}
				System.out.println(brojac);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			buffy.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}