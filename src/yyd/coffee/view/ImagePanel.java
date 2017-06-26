package yyd.coffee.view;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ÏÔÊ¾Í¼Æ¬µÄÃæ°å
 * @author yyd
 *
 */
public class ImagePanel extends JPanel {

	private JLabel label;
	private ImageIcon imageIcon;
	
	public ImagePanel(String imgPath) {
		URL url = this.getClass().getResource(imgPath);
		imageIcon = new ImageIcon(url);
		label = new JLabel(imageIcon);
		
		this.add(label);
	}
}
