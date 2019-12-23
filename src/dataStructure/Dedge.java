package dataStructure;

public class Dedge implements edge_data {
	private	int key;
	private int Src;
	private	int Dest;
	private int Tag;
	private double Weight;
	private String Info;

	public Dedge(double w) {
		this.Weight=w;

	}

	public void setSrc(int src) {
		this.Src = src;
	}

	public void setDest(int dest) {
		Dest = dest;
	}

	public int getKey() {
		return this.key;
	}
	@Override
	public int getSrc() {
		return this.Src;
	}

	@Override
	public int getDest() {

		return this.Dest;
	}

	@Override
	public double getWeight() {
		return this.Weight;
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

}
