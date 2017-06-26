package yyd.coffee.util;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AudioPlayer {

	private String audioPath;
	private AudioClip audioClip;

	public AudioPlayer(String audioPath) {
		this.audioPath = audioPath;
		URL url = this.getClass().getResource(this.audioPath);
		audioClip = Applet.newAudioClip(url);
	}

	public void playAudio() {
		audioClip.play();
	}
	
	public void stopAudio() {
		audioClip.stop();
	}
}
