package followers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class Ballwindow extends JFrame implements MouseMotionListener,
		Runnable, KeyListener {
	private int mousex = 100;
	private int mousey = 100;
	private int edgetime = 0;
	private boolean isedged = false;
	private int keyspressed = 0;
	private boolean gameover;
	private int score;
	
	
	private followball mouse = new followball(500, 500, 0, 0);
	private boolean[] ispressed = new boolean[200];

	public Ballwindow() {
		setSize(1000, 1000);
		addMouseMotionListener(this);
		addKeyListener(this);
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect((int) mouse.getX(), (int) mouse.getY(), 10, 10);
		g.setColor(Color.WHITE);
		g.drawRect((int) mouse.getX(), (int) mouse.getY(), 10, 10);
		g.setColor(new Color(edgetime, 0, 0));
		g.fillRect(mousex, mousey, 10, 10);
		g.setColor(Color.WHITE);
		g.drawRect(mousex, mousey, 10, 10);
		if(gameover){
			g.setColor(Color.RED);
			g.setFont(new Font(Font.SERIF, 50, 50));
			g.drawString("you lose, you survived "+ score/100+" seconds.",getWidth()/2-275  , getHeight()/2+25);
		}
	}

	public static void main(String[] args) {
		Ballwindow b = new Ballwindow();
		new Thread(b).start();

	}

	public void run() {
		for (;;) {
			score++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			keyspressed = 0;
			for(int i = 0; i<200; i++){
				if(ispressed[i]){
					keyspressed++;
				}
				
			}
			if(keyspressed>1&&edgetime<240){
				edgetime = edgetime+2;
			}
			else if(edgetime>1){
				edgetime--;
			}
			if(edgetime>240){
				break;
			}
			if(Math.abs(Math.abs(mousex-mouse.getX())+Math.abs(mousey-mouse.getY()))<10){
				break;
			}
			mouse.tick(mousex, mousey);
			if (ispressed[KeyEvent.VK_W]) {
				mousey--;
			}
			if (ispressed[KeyEvent.VK_A]) {
				mousex--;
			}
			if (ispressed[KeyEvent.VK_S]) {
				mousey++;
			}
			if (ispressed[KeyEvent.VK_D]) {
				mousex++;
			}
			repaint();
		}
		gameover = true;
		repaint();
		

	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		// mousex=e.getX();
		// mousey=e.getY();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		ispressed[e.getKeyCode()] = true;

	}

	public void keyReleased(KeyEvent e) {
		ispressed[e.getKeyCode()] = false;

	}

}
