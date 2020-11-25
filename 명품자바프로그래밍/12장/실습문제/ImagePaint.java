import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImagePaint extends JFrame {
	private MyPanel panel = new MyPanel();
	
	public ImagePaint() {
		setTitle("이미지 위에 원 드로잉하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		panel.setFocusable(true);
		panel.requestFocus();
		setSize(420, 300);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("nature.jpeg");
		private Image img = icon.getImage();
		int x = 0; 
		int y = 0;
		
		public MyPanel() {
			addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e) {
					x = e.getX();
					y = e.getY();
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img,  0,  0, this);
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 20, 20);
		}
		
	}
	
	public static void main(String[] args) {
		new ImagePaint();
	}

}
