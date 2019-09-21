import java.util.Random;

public class RandomDNA {
	private int minLength;
	private int range;
	private int numSeq;

	public RandomDNA(int minLength, int maxLength, int numSeq) {
		this.minLength = minLength;
		this.numSeq = numSeq;
		range = maxLength - minLength;
		if (range < 0) {
			throw new IllegalStateException("Minimum is larger than Maximum");
		} 
	}

	public String[] getDNA() {
		String[] ret = new String[numSeq];
		Random rng = new Random();
		Random ranDNA = new Random();
		int insrtPos = 0;
		for (int n = 0; n < numSeq; n++) {
			int strandLength;
			if (range == 0) {
				strandLength = minLength;
			} else {
				strandLength = rng.nextInt(range) + minLength;
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < strandLength; i++) {
				int nuc = ranDNA.nextInt(100);
				if (nuc >= 0 && nuc <= 24) {
					sb.append("a");
				} else if (nuc >= 25 && nuc <= 49) {
					sb.append("c");
				} else if (nuc >= 50 && nuc <= 74) {
					sb.append("t");
				} else if (nuc >= 75 && nuc <= 99) {
					sb.append("g");
				} else {
					sb.append("x");
				}
			}
			String finalString = sb.toString();
			
			// if want to insert sequence
//			finalString = finalString.substring(0,insrtPos) + "gggggxt" + finalString.substring(insrtPos + 7, 20);
//			
			ret[n] = finalString;
//			insrtPos++;
//			if (insrtPos == 14) {
//				insrtPos = 0;
//			}
		}
		return ret;
	}
}
