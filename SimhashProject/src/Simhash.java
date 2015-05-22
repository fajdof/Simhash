import java.util.ArrayList;
import java.util.List;


public class Simhash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimFileReader sim = new SimFileReader(System.in);
		//SimFileReader sim = new SimFileReader(args[0]);
		List<String> retci = sim.readFile();
		Hasher hasher = new Hasher();
		List<int[]> shlist = new ArrayList<int[]>();
		for(String r : retci) {
			shlist.add(hasher.retSim(r));
		}
		sim.processQueries(shlist);
	}

}
