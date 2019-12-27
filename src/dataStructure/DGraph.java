package dataStructure;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.io.Serializable;
public class DGraph implements graph ,Serializable{
	private int IDcounter;
	private int Ecounter;
	private int MC;
	private HashMap<Integer, node_data> Vertex;
	public static  int I=0;

	public  DGraph() 
	{
		HashMap h=new HashMap<Integer, node_data>();
		this.Vertex= h;
		IDcounter=0;
		Ecounter=0;
		MC=0;
	}

	@Override
	public node_data getNode(int key) {
		if (this.Vertex.isEmpty())return null;
		return this.Vertex.get(key);

	}

	@Override
	public edge_data getEdge(int src, int dest) 
	{
		if(!this.Vertex.containsKey(src))  
			throw new  RuntimeException("src not exist");
		if(!Vertex.containsKey(dest))
			throw new  RuntimeException("destetion not exist");
		DNode n =  (DNode) this.Vertex.get(src);
		if(!n.getEdges().containsKey(dest)) return null;

		Dedge e=n.getEdge(dest); 
		return e;
	}

	public HashMap getVErtex()
	{ 
		return this.Vertex ;
	}
	@Override
	public void addNode(node_data n) {
		this.Vertex.put(n.getKey(), (DNode) n);
		IDcounter ++;
		MC++;
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(!Vertex.containsKey(src))
			throw new  RuntimeException("src not exist");
		if(!Vertex.containsKey(dest))
			throw new  RuntimeException("dest not exist");

		Dedge e = new Dedge(w);
		e.setSrc(src);
		e.setDest(dest);
		e.setWeight(w);
		DNode n = (DNode) this.Vertex.get(src);
		n.AddEdge(e);  
		Ecounter++;
		MC++;
	}

	@Override
	public Collection<node_data> getV() {
		return this.Vertex.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		DNode n = (DNode) this.getNode(node_id);
		return n.getEdges().values();
	}
	//need to test again 
	@Override
	public node_data removeNode(int key)
	{
		if(!Vertex.containsKey(key)) throw new  RuntimeException("node is not exist");

		Iterator<node_data> itrerator= this.getV().iterator();
		DNode n= new DNode();

		while(itrerator.hasNext())
		{
			n =(DNode) itrerator.next();
			System.out.println(n.getKey());

			if (n.getEdges().containsKey(key))
			{
				n.getEdges().remove(key);
				Ecounter--;
				MC++;
			}				
		}

		this.Vertex.remove(key); 
		IDcounter--;
		MC++;
		//YA
		return this.Vertex.get(key);
	}
	@Override

	//not finish 
	public edge_data removeEdge(int src, int dest) {

		DNode n=(DNode) this.Vertex.get(src);

		n.RemoveEdge(dest);
		Ecounter--;
		MC++;
		return n.getEdge(dest);
	}

	@Override
	public int nodeSize() {
		return this.Vertex.size();
	}

	@Override
	public int edgeSize() {
		return this.Ecounter;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub

		return this.MC;
	}

}
