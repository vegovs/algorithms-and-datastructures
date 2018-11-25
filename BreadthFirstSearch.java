import java.io.*; 
import java.util.*; 

class Graph{
	/* Number of vertices and adjacency list */
	private int v;
	private LinkedList<Integer> adj[];

	/* Constructor */
	Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
	}

	/* Add an edge */
	void addEdge(int v, int w){
		adj[v].add(w);
	}

	void breadthFirstSearch(int s){
		
		boolean visited[] = new boolean[v];
		LinkedList queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while(queue.size() != 0){
			s = (int)queue.poll();
			System.out.println(s + " ");

			for(int n : adj[s]){
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String args[]){

		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "+ 
										   "(starting from vertex 2)");

	g.breadthFirstSearch(2);
	}
}
