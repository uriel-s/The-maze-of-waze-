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
import java.util.LinkedList;
import utils.*;
import dataStructure.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class graph_gui extends JFrame implements ActionListener, MouseListener
//JFrame implements ActionListener, MouseListener
//extends JFrame implements ActionListener, MouseListener
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

	public void paint(Graphics g)
	{
		super.paint(g);


		for (node_data d : gr.getV()) 
		{
			g.setColor(Color.BLUE);
			int k = d.getKey();
			int x = d.getLocation().ix();
			int y = d.getLocation().iy();

			g.fillOval(x, y, 10, 10);
			g.drawString(""+k , x, y-6);
			for(edge_data e :  gr.getE(k))
			{
				g.setColor(Color.RED);
				int dest = e.getDest();
				node_data n = gr.getNode(dest);
				int x1 = n.getLocation().ix();
				int y1 = n.getLocation().iy();
				g.drawLine(x, y, x1, y1);
				g.setColor(Color.BLACK);
				g.drawString(""+ e.getWeight(),(int)(x+x1)/2,(int)(y+y1)/2);
				g.setColor(Color.YELLOW);
				int a,b;
				a=(int)((x+x1)*0.9);
				b=(int)((y+y1)*0.9);

				g.fillOval(a, b, 9, 9);
				//repaint();


			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		if(str.equals("shortest path"))
		{
			
			//repaint();
		}
		if(str.equals("tsp"))
		{
		  	
			//repaint();
		}
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		DNode d = new DNode();
		Point3D p = new Point3D(x,y);
		d.setLocation(p);
		gr.addNode(d);
		repaint();
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
		
		Point3D p= new Point3D(100, 100);
		Point3D p1= new Point3D(50, 300);
//		Point3D p2= new Point3D(400, 150);
//		Point3D p3= new Point3D(150,400);

		DNode n = new DNode();
		DNode n1 = new DNode();
//		DNode n2 = new DNode();
//		DNode n3 = new DNode();
       
		n.setLocation(p);
        n1.setLocation(p1);
//        n2.setLocation(p2);
//        n3.setLocation(p3);

		DGraph DGrahp1 = new DGraph();

		DGrahp1.addNode(n);
		DGrahp1.addNode(n1);
//		DGrahp1.addNode(n2);
//		DGrahp1.addNode(n3);

		DGrahp1.connect(0, 1, 1128);
//		DGrahp1.connect(0, 2, 22);
//		DGrahp1.connect(1, 0, 22);	
//		DGrahp1.connect(1, 2, 22);
//		DGrahp1.connect(2, 0, 23);
//		DGrahp1.connect(2, 1, 23);
//		DGrahp1.connect(3, 0, 24);
//		DGrahp1.connect(0, 3, 21);
//        DGrahp1.connect(2, 1, 2);
//		
        graph_gui g = new graph_gui(DGrahp1);
		//paint();
		g.setVisible(true);

	}
}
