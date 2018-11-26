import java.io.*; 
import java.util.*; 

class Graph{
	/* Number of vertices and adjacency list */
	private int v;
	private LinkedList<Integer> adj[];
	private boolean[] visited;

	/* Constructor */
	Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		visited = new boolean[v];
		for(int i = 0; i < v; i++){
			adj[i] = new LinkedList();
		}
	}

	/* Add an edge */
	void addEdge(int v, int w){
		adj[v].add(w);
	}

	/* Recursive dfs */
	void depthFirstSearch(int v){

		visited[v] = true;
		System.out.println(v + " ");

		for(int s: adj[v]){
			if(!visited[s]){
				depthFirstSearch(s);
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

		System.out.println("Following is Depth First Traversal "+ 
										   "(starting from vertex 2)");

	g.depthFirstSearch(2);
	}
}
