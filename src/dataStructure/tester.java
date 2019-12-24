package dataStructure;
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DNode n = new DNode(0);
		DNode n1 = new DNode(1);
		DGraph DGrahp1 = new DGraph();

		DGrahp1.addNode(n);
		DGrahp1.addNode(n1);
		System.out.println("Edges before conect "+n.EdgesString());
		System.out.println(DGrahp1.getVErtex().toString());
		DGrahp1.connect(0, 1, 2);
		System.out.println("Edges after conect "+n.EdgesString());
		DGrahp1.removeNode(1);
		System.out.println(	"****");

		System.out.println(DGrahp1.getVErtex().toString());
		System.out.println("Edges after remove "+n.EdgesString());
	}


}
