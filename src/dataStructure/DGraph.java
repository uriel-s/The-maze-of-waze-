package dataStructure;
import java.util.Collection;
import java.util.HashMap;
import java.util.Collection;
public class DGraph implements graph{
	private HashMap<Integer, node_data> Vertex;
	//private Collection<node_data> collection = new Collection Vertex1 ;

	public  DGraph() 
	{
		HashMap h=new HashMap<Integer, node_data>();
		this.Vertex= h;
	}

	@Override
	public node_data getNode(int key) {
		if (this.Vertex.isEmpty())return null;
		return this.Vertex.get(key);

	}

	@Override
	public edge_data getEdge(int src, int dest) {
		DNode n =  (DNode) this.Vertex.get(src);
		Dedge e=n.getEdge(dest);
		return e;
	}

	@Override
	public void addNode(node_data n) {
		this.Vertex.put(n.getKey(), (DNode) n);

	}

	@Override
	public void connect(int src, int dest, double w) {
		Dedge e = new Dedge(w);
		e.setSrc(src);
		e.setDest(dest);
		DNode n = (DNode) this.Vertex.get(src);
		n.AddEdge(e);  
	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		//this.Vertex.remove(key);
		
		}
		@Override
		//for now 
		public edge_data removeEdge(int src, int dest) {
			DNode n=(DNode) this.Vertex.get(src);
			n.RemoveEdge(dest);
			return n.getEdge(dest);
		}

		@Override
		public int nodeSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int edgeSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMC() {
			// TODO Auto-generated method stub
			return 0;
		}

	}
