package dataStructure;

import algorithms.Graph_Algo;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DNode n = new DNode();
		DNode n1 = new DNode();
		DNode n2 = new DNode();
		DNode n3 = new DNode();


		DGraph DGrahp1 = new DGraph();
		DGrahp1.addNode(n);
		DGrahp1.addNode(n1);
		DGrahp1.addNode(n2);
	//	DGrahp1.addNode(n3);

		System.out.println("Edges before conect "+n.EdgesString());
		System.out.println("this is the VErtex "+DGrahp1.getVErtex().toString());
		DGrahp1.connect(0, 1, 2);
		System.out.println("edgesSize "+DGrahp1.edgeSize());
		System.out.println("NodeSize "+DGrahp1.nodeSize());
		System.out.println("Edges after conect "+n.EdgesString());
		DGrahp1.removeNode(1);
		System.out.println(	"remove n1");

		System.out.println("this is the VErtex "+DGrahp1.getVErtex().toString());
		System.out.println("Edges after remove "+n.EdgesString());

		System.out.println("mc="+DGrahp1.getMC());
		System.out.println("edgesSize= "+DGrahp1.edgeSize());
		System.out.println("NodeSize= "+DGrahp1.nodeSize());
		System.out.println("******************");

		Graph_Algo g = new  Graph_Algo();
		g.init(DGrahp1);
		System.out.println(g);

		
	}





}
