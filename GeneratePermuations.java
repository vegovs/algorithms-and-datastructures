class GeneratePermuations{

	int[] p;
	int n;
	boolean[] used;

	GeneratePermuations(int i){
		n =i;
		p = new int[n];
		used = new boolean[n];
	}

	void gen(){
		gen(0);
	}

	private void gen(int index){
		for(int digit = 0; digit < n; digit++){
			if(!used[digit]){
				used[digit] = true;
				p[index] = digit;
				if(index < n-1){
					gen(index + 1);
				}
				else{
					for(int i = 0; i < n; i++){
						System.out.print(p[i]);
					}
					System.out.print("\n");

				}
				used[digit] = false;
			}
		}
	}

	public static void main(String[] args){

		GeneratePermuations g = new GeneratePermuations(3);

		g.gen();
	}
}
