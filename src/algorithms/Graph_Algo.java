package algorithms;

import java.util.*;

import dataStructure.DGraph;
import dataStructure.DNode;
import dataStructure.Dedge;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{
	DGraph g;
	public List<node_data> list = new ArrayList <node_data> ();	


	public void init(graph g) {
		this.g=(DGraph) g;		
	}

	@Override
	public void init(String file_name) {
		DGraph g =null;          

		try
		{    
			FileInputStream file = new FileInputStream("file_name"); 
			ObjectInputStream in = new ObjectInputStream(file); 

			g = (DGraph)in.readObject(); 

			in.close(); 
			file.close(); 

			System.out.println("Object has been deserialized"); 
			System.out.println(g);
		} 

		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 

		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
		} 

	}




	@Override
	public void save(String file_name) {
		DGraph g =null;          
		try
		{    
			FileOutputStream file = new FileOutputStream(file_name); 
			ObjectOutputStream out = new ObjectOutputStream(file); 

			out.writeObject(g); 

			out.close(); 
			file.close(); 

			System.out.println("Object has been serialized"); 
		}   
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 


	}

	@Override
	public boolean isConnected() {
		all0(g);
		Iterator<node_data> iter= g.getV().iterator();
		DNode root= (DNode) iter.next();
		//painting all the Nodea that connect with Root.
		Rootconect(root);
		while(iter.hasNext()) 
			//if one of the Node isnt painting return false;
		{
			DNode n= (DNode) iter.next();
			if (!n.isVisited() ) { 
				System.out.println("Node N is rootconect "+n.getKey());
				return false;
			}


		}
		all0(g);
		Iterator<node_data> iter2= g.getV().iterator();
		//checking if every Nodes connect to root
		iter2.next();
		while(iter2.hasNext()) 
		{
			DNode n= (DNode) iter2.next();
			if(ConnectWith (n.getKey(),root.getKey())==false) {	
				System.out.println("N isnt conect with root " + n.getKey() ); 
				return false;
			}
		}
		return true;
	}





	public void all0(DGraph g) {
		Iterator<node_data> itrerator= g.getV().iterator();
		DNode n= (DNode) itrerator.next();
		while( itrerator.hasNext())
		{		
			n.setVisited(false);
			n= (DNode) itrerator.next();
		}
		n.setVisited(false);

	}

	public void Rootconect(DNode root)
	{
		if (root.isVisited()) return ;
		root.setVisited(true);

		Iterator<edge_data> iter= g.getE(root.getKey()).iterator();
		Dedge e=  (Dedge) iter.next();

		while(iter.hasNext())
		{
			int key= e.getDest();
			DNode n = (DNode) g.getVErtex().get(key);
			Rootconect(n) ;
			e=(Dedge) iter.next();
		}
		int key= e.getDest();
		DNode n = (DNode) g.getVErtex().get(key);
		Rootconect(n) ;

	}
	public boolean ConnectWith(int src,int dest) 
	{
		DNode n = (DNode) g.getNode(src);
		if(n.isVisited())return false;
		n.setVisited(true);
		//if( n.getEdge(dest)!=null ) return true;
		if(n.getEdges().containsKey(dest))return true;

		Iterator<edge_data> iter= g.getE(n.getKey()).iterator();
		Dedge e=  (Dedge) iter.next();		

		while(iter.hasNext())
		{
			int key= e.getKey();
			n = (DNode) g.getVErtex().get(key);
			if(ConnectWith(key, dest))return true;
			e=(Dedge) iter.next();
		}
		int key=e.getKey();
		n = (DNode) g.getVErtex().get(key);
		if(ConnectWith(key, dest))return true;

		return false;


	}

	@Override
	public double shortestPathDist(int src, int dest) {
		this.invinityAll();
		this.all0(g);
		g.getNode(src).setWeight(0);
		return 0;
	}
	public void dijkstra (DNode src) 
	{
		Iterator<edge_data> I= g.getE(src.getKey()).iterator();
		Dedge e=  (Dedge) I.next();

		while (I.hasNext() )
		{
			DNode nb = (DNode) g.getNode( e.getDest() );
			double Weight= e.getWeight()+src.getWeight();
			if(Weight>nb.getWeight()) nb.setWeight(Weight);
		}

	}






	public Dedge minEdge(DNode n)
	{
		Iterator<edge_data> I= g.getE(n.getKey()).iterator();
		Dedge e=  (Dedge) I.next();
		Dedge ans=e;
		double min ;
		while (I.hasNext())
		{
			e=(Dedge) I.next();
			if( e.getWeight()>ans.getWeight() ) ans=e;

		}
		return e;
	}

	public void invinityAll() 
	{
		Iterator<node_data> I= g.getV().iterator();
		DNode n= (DNode) I.next();
		while(I.hasNext()) {
			n.setWeight(Double.MAX_VALUE);
			n= (DNode) I.next();
		}
		n.setWeight(Double.MAX_VALUE);

	}


	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		return null;
	}
	public Iterator<node_data> iterator() {
		return this.list.iterator();
	}
}
