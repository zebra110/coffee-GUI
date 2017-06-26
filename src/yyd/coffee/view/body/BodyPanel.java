package yyd.coffee.view.body;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.table.TableStringConverter;

import yyd.coffee.view.body.center.BodyCenter;
import yyd.coffee.view.body.left.BodyLeft;
import yyd.coffee.view.body.right.BodyRight;

public class BodyPanel extends JPanel {
	
	private BodyLeft bodyLeft;
	private BodyCenter bodyCenter;
	private BodyRight bodyRight;
	
	public BodyPanel() {
		bodyLeft = new BodyLeft();
		bodyCenter = new BodyCenter();
		bodyRight = new BodyRight();
		
		this.setLayout(new BorderLayout());
		this.add(bodyLeft, BorderLayout.WEST);
		this.add(bodyCenter, BorderLayout.CENTER);
		this.add(bodyRight, BorderLayout.EAST);
	}
}
