package dataStructure;

import java.util.ArrayList;
import java.util.List;

import algorithms.Graph_Algo;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



		//System.out.println("Edges before conect "+n.EdgesString());
		//	System.out.println("this is the VErtex "+DGrahp1.getVErtex().toString());
		DNode n = new DNode();
		DNode n1 = new DNode();
		DNode n2 = new DNode();
		DNode n3 = new DNode();


		DGraph DGrahp1 = new DGraph();

		DGrahp1.addNode(n);
		DGrahp1.addNode(n1);
		DGrahp1.addNode(n2);
		DGrahp1.addNode(n3);

		//System.out.println("edgesSize "+DGrahp1.edgeSize());
		//System.out.println("NodeSize "+DGrahp1.nodeSize());
		//System.out.println("n0 Edges after conect "+n.EdgesString());
		//System.out.println("n0 Edges after conect "+n.EdgesString());
		//System.out.println("******************");

		DGrahp1.connect(0, 1, 118);
		DGrahp1.connect(0, 2, 22);
		DGrahp1.connect(1, 0, 22);	
		DGrahp1.connect(1, 2, 22);
		DGrahp1.connect(2, 0, 23);
		DGrahp1.connect(2, 1, 23);

		DGrahp1.connect(3, 0, 24);
		DGrahp1.connect(0, 3, 21);


		//DGrahp1.connect(2, 1, 2);

		Graph_Algo g = new  Graph_Algo();
		Graph_Algo g2 = new  Graph_Algo();
		DGraph DGrahp2 = new DGraph();
		g.init(DGrahp1);
		g2.init(g.copy());		
		System.out.println("g isConnected= "+g.isConnected());
		System.out.println("shortestPathDist(0to1)" + g.shortestPathDist(0, 1));
		System.out.println("g shortestPath="+g.shortestPath(0, 1));
		List<Integer> ans = new ArrayList <Integer> ();	
		ans.add(0);
		ans.add(1);
		ans.add(2);
		ans.add(3);
		System.out.println("g.TCP="+g.TSP(ans));
		System.out.println("g copy TCP="+g2.TSP(ans));
		System.out.println("testing deep copy - changing only one graph ////");
		//System.out.println("gMC="+g.getG().getMC());

		//	System.out.println("g2= Edges"+ g2.getG().getE(0));

		//System.out.println(g2.isConnected());
		//System.out.println(g2.TSP(ans));
		DGrahp1.removeEdge(0, 1);
		System.out.println("g edges sise"+g.getG().edgeSize());
		System.out.println("g2 edges sise"+g2.getG().edgeSize());
		String aaa = "guiii";
		g.save(aaa);


	}





}
