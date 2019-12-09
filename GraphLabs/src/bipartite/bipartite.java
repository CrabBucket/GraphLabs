package bipartite;

import java.util.LinkedList;

public class bipartite {
	public static void explore(LinkedList<Node> graph) {
		//All of the node start as null which represents gray.
		for(Node node : graph) {
			if(node.blue == null) {
				node.blue = true;
				if(!isBipartite(node)) {
					return;
				}
			}
		}
		
	}
	public static boolean isBipartite(Node node) {
		LinkedList<Node> neighbors = new LinkedList<Node>();
		node.parent = new Node();
		neighbors.add(node);
		while(neighbors.size()>0) {
			Node neighbor = neighbors.remove();
			for(Node temp: neighbor.adj) {
				if(temp.blue == null) {
					temp.blue = !neighbor.blue;
					neighbors.add(temp);
				}else if (temp.blue == neighbor.blue) {
					System.out.println("Not Bipartite");
					return false;
				}
			}
		}
		return true;
	}
	public static void print(LinkedList<Node> graph) {
		for(Node node : graph) {
			if(node.blue == null) {
				System.out.println("Node: "+ node.num + "  Color: Grey");
			}else if(node.blue) {
				System.out.println("Node: "+ node.num + "  Color: Blue");
			}else {
				System.out.println("Node: "+ node.num + "  Color: Red");
			}
		}
	}
	public static void main(String args[]) {
		RandomUndirectedGraph graph = new RandomUndirectedGraph(10,10);
		graph.printGraph();
		LinkedList<Node> list = graph.getGraph();
		explore(list);
		print(list);
		
	}
}
