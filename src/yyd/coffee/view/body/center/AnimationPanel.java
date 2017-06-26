package yyd.coffee.view.body.center;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JPanel;

import yyd.coffee.controller.Status;
import yyd.coffee.util.AudioPlayer;

public class AnimationPanel extends JPanel implements ActionListener {

	private	static final int SHIFT_STEP = 2;
	private static final int MAX_HEIGHT = 100;
	private static final int LACK_HEIGHT = 15;
	private static final int SPEED = 70;

	private static AnimationPanel animationPanel = null;
	private AudioPlayer audioPlayer;

	private boolean out;
	private int type;
	private int shift = 0;

	private Timer timer;

	public static AnimationPanel getAnInstance() {
		if (animationPanel == null) {
			animationPanel = new AnimationPanel();
		}
		return animationPanel;
	}

	private AnimationPanel() {
		audioPlayer = new AudioPlayer("/resource/audio/waterFlow.wav");
		this.out = true;
		timer = new Timer(SPEED,this);
		this.setBackground(new Color(188,222,222));
	}

	public void setTypeAndPlay(int type) {
		this.type = type;
		this.out = false;
		startAnimation();
	}

	public void takeOut(){
		this.out = true;
		this.repaint();
	}

	private void startAnimation(){
		shift = 0;
		timer.start();
		audioPlayer.playAudio();
	}

	private void stopAnimation(){
		timer.stop();
		audioPlayer.stopAudio();
	}

	private Color getColor() {
		Color color = null;

		switch (this.type) {
		case Status.WEAKCOFFEE:
			color = Color.decode("#C5691E");
			break;
		case Status.ESPRESSO:
			color = Color.decode("#9A3710");
			break;
		case Status.MILKTEA:
			color = Color.decode("#DEBC98");
			break;
		default:
			break;
		}

		return color;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(!this.out){
			g.setColor(Color.decode("#D8F5F5"));
			g.fill3DRect(70, 89, 80, 110, true);

			g.setColor(getColor());
			g.fill3DRect(70, 89+MAX_HEIGHT-shift, 80, shift+10, true);
		} else {
			g.setColor(Color.decode("#D8F5F5"));
			g.fill3DRect(70, 89, 80, 110, true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(shift < (MAX_HEIGHT-LACK_HEIGHT)){
			shift+=SHIFT_STEP;
		}else{
			stopAnimation();
			Status.setIsMaking(true);
			MovingMessagePanel.getAnInstance().setMessage("Çë¡¾È¡³ö¡¿ÂýÓÃÅ¶~");
		}
		this.repaint();
	}
}
