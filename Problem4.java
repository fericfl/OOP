class Problem4{
	public static void main(String[] args){
		int i;
		int j;
		for(i=3; i>=0; i--)
		{
			j=i;
			while(j>0)
			{
				System.out.print("*");
				j--;
			}
			System.out.println();
		}
	}
}
