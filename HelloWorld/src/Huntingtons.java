
public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
    	int maxRepeats = 0;
    	int index = 0;
    	while (index < dna.length() - 3 * maxRepeats) {
    		int repeats = 0;
    		String trinuclotide = dna.substring(index, Math.min(dna.length()-1, index+3));
    		while (trinuclotide.equals("CAG")) {
    			repeats++;
    			index+=3;
    			trinuclotide = dna.substring(index, Math.min(dna.length()-1, index+3));
    		}
    		if (repeats > 0) index-=2;
    		else index++;
    		if (repeats > maxRepeats) maxRepeats = repeats;
    	}
    	return maxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
    	return s.replace(" ", "").replace("\t", "").replace("\n", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
    	if (maxRepeats < 10) return "not human";
    	if (maxRepeats < 36) return "normal";
    	if (maxRepeats < 40) return "high risk";
    	if (maxRepeats < 181) return "Huntington’s";
    	return "not human";
    }
	public static void main(String[] args) {
		String filePath = args[0];
		//filePath = "src\\chromosome4-healthy.txt";
		In input = new In(filePath);
        String content = input.readAll();
        int repeats = maxRepeats(removeWhitespace(content));
        StdOut.println("max repeats = " + repeats);
        StdOut.println(diagnose(repeats));
		}
	}