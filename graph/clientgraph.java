package graph;

public class clientgraph {

	public static void main(String[] args) {

		graph g = new graph();
		g.addvertex("a");
		g.addvertex("b");
		g.addvertex("c");

		g.addvertex("d");
		g.addvertex("e");
		g.addvertex("f");
		g.addvertex("g");

		g.addedge("a", "b");
		g.addedge("a", "c");
		g.addedge("c", "d");
		g.addedge("b", "d");
		g.addedge("d", "e");
		g.addedge("e", "f");
		g.addedge("e", "g");
		g.addedge("f", "g");

//		g.dispay();
//		System.out.println(g.haspath("a", "g"));
		/* g.removeedge("e", "f"); */
//		System.out.println(g.haspath("a", "g"));
//
//		g.bft();
//		System.out.println("********************");
//
//		System.out.println(g.allconnectedcomp());

//		g.dispay();
//		System.out.println(g.isbiparted());

		System.out.println(g.isacyclic());
		g.removeedge("c", "d");
		System.out.println(g.isacyclic());
		g.removeedge("e", "g");
		System.out.println(g.isacyclic());
	}

}
