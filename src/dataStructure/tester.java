package dataStructure;
public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
DNode n = new DNode(0);

DNode n1 = new DNode(1);
	DGraph DGrahp1 = new DGraph();
	DGrahp1.addNode(n);
	DGrahp1.addNode(n1);
	DGrahp1.connect(1, 2, 2);
	}

}
