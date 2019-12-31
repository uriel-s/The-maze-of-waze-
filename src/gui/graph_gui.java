package gui;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import algorithms.*;
import dataStructure.*;
import utils.*;



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
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Menu");
		Menu menu2 = new Menu("file");

		menuBar.add(menu1);
		menuBar.add(menu2);

		this.setMenuBar(menuBar);

		MenuItem item1 = new MenuItem("shortest Path way");
		item1.addActionListener(this);

		MenuItem item2 = new MenuItem("shortest Path distance");
		item2.addActionListener(this);

		MenuItem item3 = new MenuItem("tsp");
		item3.addActionListener(this);

		MenuItem item4 = new MenuItem("isConnected");
		item4.addActionListener(this);

		MenuItem item5 = new MenuItem("save to file");
		item5.addActionListener(this);

		MenuItem item6 = new MenuItem("draw from file");
		item6.addActionListener(this);

		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);

		menu2.add(item5);
		menu2.add(item6);



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
				double c=0,s=0;
				if(x<x1 && y<y1) {
					c=x+(Math.abs(x-x1)*0.4);
					s=y+(Math.abs(y-y1)*0.4);
				}
				if(x>x1 && y>y1 ) {
					c=x-(Math.abs(x-x1)*0.4);
					s=y-(Math.abs(y-y1)*0.4);
				}
				if(x>x1 && y<y1 ) {
					c=x-(Math.abs(x-x1)*0.4);
					s=y+(Math.abs(y-y1)*0.4);
				}
				if(x<x1 && y>y1) {
					c=x+(Math.abs(x-x1)*0.4);
					s=y-(Math.abs(y-y1)*0.4);
				}
				StdDraw.text(c,s,""+ e.getWeight());

				StdDraw.setPenColor(Color.YELLOW);
				double a=0,b=0;
				if(x<x1 && y<y1) {
					a=x+(Math.abs(x-x1)*0.8);
					b=y+(Math.abs(y-y1)*0.8);
				}
				if(x>x1 && y>y1 ) {
					a=x-(Math.abs(x-x1)*0.8);
					b=y-(Math.abs(y-y1)*0.8);
				}
				if(x>x1 && y<y1 ) {
					a=x-(Math.abs(x-x1)*0.8);
					b=y+(Math.abs(y-y1)*0.8);
				}
				if(x<x1 && y>y1) {
					a=x+(Math.abs(x-x1)*0.8);
					b=y-(Math.abs(y-y1)*0.8);
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
		// Graph_Algo graph = new Graph_Algo();

		if(str.equals("shortest Path way"))
		{
			shortest_Path();
		}
		if(str.equals("shortest Path distance"))
		{
			shortestPathDistance();
		}
		if(str.equals("tsp")) {
			tsp();
		}
		if(str.equals("isConnected")) {
			isConnected();
		}
		if(str.equals("save to file")) {
			saveToFile();
		}
		if(str.equals("draw from file")) {
			drawfromfile();
		}

	}

	private void shortestPathDistance() {

	}

	private void tsp() {
		try {
			List<Integer> targets = new ArrayList<Integer>();
			JFrame in = new JFrame();
			String str = "-1";
			String travel ="";
			while(!(travel.equals(str))){
				travel = JOptionPane.showInputDialog(in,"Enter targets Node,enter -1 when you finish:");
				int s = Integer.parseInt(travel);
				targets.add(s);
			}
			Graph_Algo newTsp = new Graph_Algo();
			newTsp.init(gr);

			List<node_data> dis = newTsp.TSP(targets);
			paint();
			for (int i=0; i<dis.size()-1; i++) {
				double x1 = dis.get(i).getLocation().x();
				double y1 = dis.get(i).getLocation().y();
				double x2 = dis.get(i+1).getLocation().x();
				double y2 = dis.get(i+1).getLocation().y();

				StdDraw.setPenColor(Color.GREEN);
				StdDraw.setPenRadius(0.004);	
				StdDraw.line(x1, y1, x2, y2);
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


private void isConnected() {
	JFrame f = new JFrame();
	this.setSize(150, 50);
	JPanel p = new JPanel();

	Graph_Algo graphIsC = new Graph_Algo();
	graphIsC.init(gr);
	if(graphIsC.isConnected()) {
		JLabel l = new JLabel("the graph is connected");

		p.add(l);
		f.add(p);
		f.setVisible(true);
	} else {
		JLabel K = new JLabel("the graph is NOT connected");

		p.add(K);
		f.add(p);
		f.setVisible(true);
	}
}

private void saveToFile() {
	// TODO Auto-generated method stub

}

public void shortest_Path() {
	try {
		JFrame in = new JFrame();
		String Source = JOptionPane.showInputDialog(in,"Enter Source-Node:");
		String Dest = JOptionPane.showInputDialog(in,"Enter Destination-Node:");

		int srcSSP = Integer.parseInt(Source);
		int destSSP = Integer.parseInt(Dest);

		Graph_Algo newGSSP = new Graph_Algo();
		newGSSP.init(gr);

		List<node_data> dis = newGSSP.shortestPath(srcSSP, destSSP);
		paint();
		for (int i=0; i<dis.size()-1; i++) {
			double x1 = dis.get(i).getLocation().x();
			double y1 = dis.get(i).getLocation().y();
			double x2 = dis.get(i+1).getLocation().x();
			double y2 = dis.get(i+1).getLocation().y();

			StdDraw.setPenColor(Color.GREEN);
			StdDraw.setPenRadius(0.004);	
			StdDraw.line(x1, y1, x2, y2);
		}

	}
	catch (Exception e) {
		e.printStackTrace();
	}

}


private void drawfromfile() {
	JFileChooser jf = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	int returnV = jf.showOpenDialog(null);
	Graph_Algo gra = new Graph_Algo();
	if (returnV == JFileChooser.APPROVE_OPTION) {
		File selected = jf.getSelectedFile();
		gra.init(selected.getAbsolutePath());
	}
	this.gr = (DGraph) gra.copy();
}



@Override
public void mouseClicked(MouseEvent e) {
	System.out.println("mouseClicked");
}

@Override
public void mousePressed(MouseEvent e) {
	System.out.println("mousePressed");

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
