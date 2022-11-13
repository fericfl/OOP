class Pyramid {
	private int k;

	public Pyramid(int p) {
		k = p;
	}

	public String toString () {
		int i;
		int j;
		String str = new String();
		
		for (i = k; i > 0; i--) {
			j = i;
			for(j = 0; j < i; j++) {
				str = str.concat(i + " ");
			}
			str = str.concat("\n");
		}
		return str;
	}
}

class ProblemPyramid {
	public static void main(String[] args) {
		Pyramid pyr = new Pyramid(4);
		System.out.println(pyr);
	}
}
