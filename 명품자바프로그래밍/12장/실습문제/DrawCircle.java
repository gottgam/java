import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class DrawCircle extends JFrame {
	private MyPanel panel = new MyPanel();
	
	
	public DrawCircle() {
		setTitle("마우스로 원 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);

		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		
		class Circle {
			int x;
			int y;
			int w;
			int h;
			
			public Circle(int x, int y, int w, int h) {
				this.x = x;
				this.y = y;
				this.w = w;
				this.h = h;
			}
		}
		private Vector<Circle> v = new Vector<Circle>();
		
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;
		
		public MyPanel() {
			setLayout(null);
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					x1 = e.getX();
					y1 = e.getY();
				}
				public void mouseReleased(MouseEvent e) {
					x2 = e.getX();
					y2 = e.getY();
					
					if (x2 > x1 && y2 > y1) // 우측 하단 방향으로 드래그할 때  
						v.add(new Circle(x1, y1, x2 - x1, y2 - y1));
					else if (x2 < x1 && y2 < y1) // 좌측 상단 방향으로 드래그할 때 
						v.add(new Circle(x2, y2, x1 - x2, y1 - y2));
					else if (x2 < x1 && y2 > y1) // 좌측 하단 방향으로 드래그할 때  
						v.add(new Circle(x2, y1, x1 - x2, y2 - y1));
					else if (x2 > x1 && y2 < y1) // 우측 상단 방향으로 드래그할 때  
						v.add(new Circle(x1, y2, x2 - x1, y1 - y2));
					repaint();
				}
			});
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.magenta);
			for (int i = 0; i < v.size(); i++) {
				Circle c = v.get(i);
				g.drawOval(c.x, c.y, c.w, c.h);
			}
		}
	}

	public static void main(String[] args) { // 메인 함수
		new DrawCircle();
	}

}
