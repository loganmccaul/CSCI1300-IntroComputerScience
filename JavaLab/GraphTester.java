

public class GraphTester
{
	public static void main(String[] args)
	{
		int n = 7;
		Graph g = new Graph(n);
		
		int i = 0;
		while (i+(n/2) != 0){
			g.addEdge(i, i+(n/2), 1);
			i = (i+(n/2))%n;
		}
		for(int k = 0; k < n; k++){
			System.out.println(g.getAdjList(k));
		}
		//add(g, 0, n/2, 1);
					
	}
	/*public void add(Graph g, int x, int y, int z){
		if(y == 0){
			return;
		}
		g.addEdge(x, y, z);
		add(g, x+y/2, y/2, z);
	}*/
}
