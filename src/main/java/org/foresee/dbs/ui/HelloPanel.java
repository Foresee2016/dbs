package org.foresee.dbs.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 在鼠标移到HelloPanel上时会有一个字符串跟着鼠标。
 * @author Foresee
 *
 */
public class HelloPanel extends JPanel implements MouseMotionListener, ActionListener{
	public static void main(String[] args) {
		JFrame frame=new JFrame("hover text");
		frame.setVisible(true);
		frame.setSize(400, 400);
		frame.setLayout(null);
		HelloPanel hoverPanel=new HelloPanel("hover panel");
		hoverPanel.setBounds(0, 0, 200, 200);
		frame.add(hoverPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static final long serialVersionUID = -7383608411167229385L;
	protected static final int HOVER_TIME_MILLIS=600;
	protected String panelName;
	Point mousePoint=new Point(100, 100);
	Point lastMousePoint=new Point(100,100);
	protected long lastHoverTimestamp=0;
	protected JButton changeColorBtn;
	public HelloPanel(String panelName) {
		this.panelName=panelName;
		addMouseMotionListener(this);
		setBackground(Color.BLACK);
		changeColorBtn=new JButton("改变颜色");
		changeColorBtn.addActionListener(this);
		add(changeColorBtn);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePoint=e.getPoint();
		if (isPointInRect(mousePoint, getBounds())) {
			repaint();					
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		Rectangle rect=getBounds();
		g.clearRect((int)rect.getMinX(), (int)rect.getMinY(), rect.width, rect.height);
		g.drawString("Hello "+panelName, (int)mousePoint.getX(), (int)mousePoint.getY());
	}
	protected static boolean isPointInRect(Point point, Rectangle rect) {
		if(point.x>rect.getMinX() && point.x<rect.getMaxX() && point.y>rect.getMinY() && point.y<rect.getMaxY()){
			return true;
		}
		return false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==changeColorBtn){
			changeColor();
		}
	}
	protected int colorIndex=0;
	protected Color[] colors={Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN};
	// synchronized关键字让多个线程不能同时运行这个方法
	synchronized protected void changeColor() {
		if(colorIndex == colors.length){
			colorIndex=0;
		}
		setBackground(colors[colorIndex++]);
		if(colorIndex == colors.length){
			colorIndex=0;
		}
		setForeground(colors[colorIndex++]);
		repaint();
	}
}
