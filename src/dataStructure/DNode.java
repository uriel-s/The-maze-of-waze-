package dataStructure;

import java.util.HashMap;

import utils.Point3D;

public class DNode implements node_data {
	private	int key;
	private int Tag;
	private double Weight;
	private Point3D Location ;
	private String Info;
	private	HashMap  <Integer, edge_data>  Edges;
  
	@Override
	public int getKey() {
		return this.key;
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
	public void AddEdge(DNode dest, double Weight) {
	dest.setWeight(Weight);
		this.Edges.put(dest.getKey(),(edge_data) dest);
	
	}
}
