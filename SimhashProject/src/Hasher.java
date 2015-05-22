import org.apache.commons.codec.digest.DigestUtils;

public class Hasher {
	
	public Hasher() {
	}
	
	public int[] retSim(String redak) {
		String[] komadi = redak.trim().split(" ");
		int[] sh = new int[128];
		for (int i=0;i<128;i++) {
			sh[i] = 0;
		}
		for(String l : komadi) {
			//byte[] hash = "fakultet elektrotehnike i racunarstva".getBytes();
			byte[] hash = l.getBytes();
			byte[] rezHash = DigestUtils.md5(hash);
			for(int j=0;j<16;j++) {
				for (int g=0;g<8;g++) {
					byte x = 0;
					switch(g) {
					case 0:
						x = (byte) ((rezHash[j])&0b00000001);
						break;
					case 1:
						x = (byte) ((rezHash[j]>>1)&0b00000001);
						break;
					case 2:
						x = (byte) ((rezHash[j]>>2)&0b00000001);
						break;
					case 3:
						x = (byte) ((rezHash[j]>>3)&0b00000001);
						break;
					case 4:
						x = (byte) ((rezHash[j]>>4)&0b00000001);
						break;
					case 5:
						x = (byte) ((rezHash[j]>>5)&0b00000001);
						break;
					case 6:
						x = (byte) ((rezHash[j]>>6)&0b00000001);
						break;
					case 7:
						x = (byte) ((rezHash[j]>>7)&0b00000001);
						break;
					}
					if (x == 1) {
						sh[j*8+g]=sh[j*8+g]+1;
					} else {
						sh[j*8+g]=sh[j*8+g]-1;
					}
				}
			}
		}
		for (int i=0;i<128;i++) {
			if (sh[i] < 0) {
				sh[i] = 0;
			} else {
				sh[i] = 1;
			}
		}
		return sh;
	}
	
}
