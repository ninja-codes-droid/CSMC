package canteen;


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 * @author Sunirmal Khatua
 *
 */
public class MainFrame extends JFrame{

	DisplayCanvas canvas = new DisplayCanvas();	

	public MainFrame() {
		setTitle("CU Canteen");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(canvas);
		FoodBuffer foods = new FoodBuffer(10);
		canvas.foods = foods;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		canvas.producer = new Producer(50, (int)(d.getHeight()/2-35), foods);
		canvas.consumer = new Consumer((int)d.getWidth()-100, (int)(d.getHeight()/2-35), foods);
		canvas.foods.p = canvas.producer;
		canvas.foods.c = canvas.consumer;
		canvas.producer.start();
		canvas.consumer.start();
	}
	
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);		
		//Code for animation that refreshes the canvas every 2 seconds
		while(true) {			
			f.canvas.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
