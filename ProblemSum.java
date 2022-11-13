class Sum {
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int a, int b, int c) {
		return sum(a,b) + c;
	}

	public static int sum(int a, int b, int c, int d) {
		return sum(a,b,c) + d;
	}
}

class ProblemSum {
	public static void main(String[] args) {
		System.out.println(Sum.sum(5,5));
		System.out.println(Sum.sum(5,5,5));
		System.out.println(Sum.sum(5,5,5,5));
	}
}
