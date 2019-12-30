package dataStructure;

import java.util.HashMap;
import dataStructure.DGraph;
import utils.Point3D;

public class DNode implements node_data {
	private	int key;
	private int Tag;
	private double Weight;
	private Point3D Location ;
	private String Info;
	private	HashMap  <Integer, edge_data>  Edges;
	private boolean Visited;



	public  DNode() {
		this.key=DGraph.I;
		DGraph.I++;
		this.Edges = new HashMap<>();
		this.Visited=false;
		this.Weight=0;
	}
	public boolean isVisited() {
		return this.Visited;
	}

	public void setVisited(boolean b) {
		this.Visited=b;
	}

	@Override
	public int getKey() {
		return this.key;
	}

	public void SetKey(int x) {
		this.key=x;
	}
	@Override
	public Point3D getLocation() {

		return this.Location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.Location=p;
	}

	@Override
	public double getWeight() {
		return this.Weight;
	}

	@Override
	public void setWeight(double w) {
		this.Weight=w;
	}

	@Override
	public String getInfo() {
		return this.Info;
	}

	@Override
	public void setInfo(String s) {
		this.Info=s;

	}

	@Override
	public int getTag() {
		return this.Tag;	
	}


	@Override
	public void setTag(int t) {
		this.Tag=t;

	}

	public Dedge getEdge(int dest)
	{
		return (Dedge) this.Edges.get(dest);
	}


	public void AddEdge(Dedge e)
	{  
		this.Edges.put(e.getDest(),(edge_data) e);
	}


	public void RemoveEdge(int e)
	{  
		this.Edges.remove(e);
	}

	public String EdgesString() {
		return this.Edges.toString();
	}

	public String toString()
	{
		String s = Integer.toString(this.key);
	  return s;
	}

	public HashMap<Integer, edge_data> getEdges() {
		return this.Edges;
	}

}


