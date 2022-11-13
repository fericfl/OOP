class Book {
	private int pages;
	
	public Book(int p) {
		pages = p;
	}

	public boolean equals(Object o) {
		return (o instanceof Book) && ((Book)o).pages == pages;
	}		
}

class ClientBook {
	public static void main(String[] args) {
				Book book1, book2;
				book1 = new Book(50);
				book2 = new Book(50);
				System.out.println(book1.equals(book2));
	}
}