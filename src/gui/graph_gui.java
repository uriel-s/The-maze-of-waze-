package gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.LinkedList;
import utils.*;
import dataStructure.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class graph_gui extends JFrame implements ActionListener, MouseListener
{
	DGraph gr;

	public graph_gui(DGraph g)
	{
		this.gr=g;
		initGUI(gr);
	}

	private void initGUI(DGraph gr) 
	{
		//StdDraw.setCanvasSize(700, 500);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Menu");
		Menu menu2 = new Menu("file");

		menuBar.add(menu1);
		menuBar.add(menu2);

		this.setMenuBar(menuBar);

		MenuItem item1 = new MenuItem("shortest Path");
		item1.addActionListener(this);

		MenuItem item2 = new MenuItem("tsp");
		item2.addActionListener(this);

		menu1.add(item1);
		menu1.add(item2);

		this.addMouseListener(this);

	}

	public void paint() {
		StdDraw.setCanvasSize(700, 500);
		StdDraw.setXscale(-100,100);
		StdDraw.setYscale(-100,100);
		Collection<node_data> search = gr.getV();
		StdDraw.setPenRadius(0.005);

		for (node_data d : search) 
		{
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.setPenRadius(0.015);

			int k = d.getKey();
			double x = d.getLocation().x();
			double y = d.getLocation().y();
			StdDraw.point(x, y);
			StdDraw.text(x,y+4,""+k);

			for(edge_data e :  gr.getE(k)) 
			{
				StdDraw.setPenColor(Color.RED);
				StdDraw.setPenRadius(0.004);
				int dest = e.getDest();
				node_data n = gr.getNode(dest);
				double x1 = n.getLocation().x();
				double y1 = n.getLocation().y();
				StdDraw.line(x, y, x1, y1);
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.text((x+x1)/2,(y+y1)/2,""+ e.getWeight());
				StdDraw.setPenColor(Color.YELLOW);
				double a=0,b=0;
				if(x<x1 && y<y1) {
					a=x+(Math.abs(x-x1)*0.9);
					b=y+(Math.abs(y-y1)*0.9);
				}
				if(x>x1 && y>y1 ) {
					a=x-(Math.abs(x-x1)*0.9);
					b=y-(Math.abs(y-y1)*0.9);
				}
				if(x>x1 && y<y1 ) {
					a=x-(Math.abs(x-x1)*0.9);
					b=y+(Math.abs(y-y1)*0.9);
				}
				if(x<x1 && y>y1) {
					a=x+(Math.abs(x-x1)*0.9);
					b=y-(Math.abs(y-y1)*0.9);
				}
				StdDraw.setPenRadius(0.015);
				StdDraw.point(a,b);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		if(str.equals("shortest Path"))
		{
           // shortest_Path();
			paint();
		}
		if(str.equals("tsp"))
		{
           
		}


	}

	public void shortest_Path() {
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(StdDraw.isMousePressed()) {
		double x = StdDraw.mouseX();
		double y = StdDraw.mouseY();
		DNode d = new DNode();
		Point3D p = new Point3D(x,y);
		d.setLocation(p);
		gr.addNode(d);
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.setPenRadius(0.015);
		int k = d.getKey();
		StdDraw.point(x, y);
		StdDraw.text(x,y+4,""+k);
	}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");

	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}


	public static void main(String [] args) {

		Point3D p= new Point3D(10, 10);
		Point3D p1= new Point3D(50, 50);
		Point3D p2= new Point3D(60, 40);
		Point3D p3= new Point3D(5,90);

		DNode n = new DNode();
		DNode n1 = new DNode();
		DNode n2 = new DNode();
		DNode n3 = new DNode();

		n.setLocation(p);
		n1.setLocation(p1);
		n2.setLocation(p2);
		n3.setLocation(p3);

		DGraph DGrahp1 = new DGraph();

		DGrahp1.addNode(n);
		DGrahp1.addNode(n1);
		DGrahp1.addNode(n2);
		DGrahp1.addNode(n3);

		DGrahp1.connect(0, 1, 11);
		DGrahp1.connect(0, 2, 22);
		DGrahp1.connect(1, 0, 22);	
		DGrahp1.connect(1, 2, 22);
		DGrahp1.connect(2, 0, 23);
		DGrahp1.connect(2, 1, 23);
		DGrahp1.connect(3, 0, 24);
		DGrahp1.connect(0, 3, 21);
		DGrahp1.connect(2, 1, 2);

		graph_gui g = new graph_gui(DGrahp1);
		g.setVisible(true);

	}
}
