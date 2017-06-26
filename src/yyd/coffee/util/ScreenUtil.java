package yyd.coffee.util;

import java.awt.Toolkit;

public class ScreenUtil {
	public static int getScreenHeight(){
		return Toolkit.getDefaultToolkit().getScreenSize().height;
	}
	
	public static int getScreenWidth(){
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
}
