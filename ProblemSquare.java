class Square {
	private int side;

	public Square() {
		side = 15;
	}

	public Square(int s) {
		side = s;
	}

	public String toString () {
		return "Square " + side + " area " + side*side;
	}
}

class ProblemSquare {
	public static void main(String[] args) {
		Square v1 = new Square();
		Square v2 = new Square(20);

		System.out.println(v1);
		System.out.println(v2);
	}
}
