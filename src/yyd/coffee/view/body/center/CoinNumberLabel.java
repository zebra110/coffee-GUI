package yyd.coffee.view.body.center;


import javax.swing.JLabel;

import yyd.coffee.model.Coin;

public class CoinNumberLabel extends JLabel{
	
	private Coin coin;

	public CoinNumberLabel(){
		coin = new Coin();
		this.setText(""+coin.getNumber());
	}
	
	public CoinNumberLabel(String num){
		this.setText(num);
	}

	public Coin getCoin() {
		return coin;
	}

	public void setCoinText(int num){
		this.setText(num+"");
	}
}
