class Problem3{
	public static void main(String[] args){
		int i=1;
		int sum=0;
		for(i=1;i<=100;i++)
		{
			if(i%2==0)
			{
				System.out.println(i);
				sum+=i;
			}
				
		}
		System.out.println("The sum of the numbers is" + " " + sum);
	}
}
