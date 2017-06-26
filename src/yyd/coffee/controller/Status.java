package yyd.coffee.controller;

import yyd.coffee.model.Coin;
import yyd.coffee.model.Cup;
import yyd.coffee.model.PowderCoffee;
import yyd.coffee.model.PowderMilktea;
import yyd.coffee.model.Sugar;
import yyd.coffee.model.Water;
import yyd.coffee.view.body.center.AnimationPanel;
import yyd.coffee.view.body.center.MonitoringShowPanel;
import yyd.coffee.view.body.center.MovingMessagePanel;
import yyd.coffee.view.body.left.MonitoringWarnPanel;


//1.ʵ���ࣺ������ϵͳ�е����й˿͡��ʻ����ʺŽ��׵ȣ���ʵ�ּ����޹أ�

//2.�����ࣺ��������ҵ������̺�ִ�д���

//3.�߽��ࣺ����ϵͳ�������������
/**
 * ״̬��������Ϣ����
 * @author yyd
 *
 */
public class Status {
	
	//��Ʒ����
	public static final int WEAKCOFFEE = 1;	//������
	public static final int ESPRESSO = 2;	//Ũ����
	public static final int MILKTEA = 3;	//�̲�

	private Water water = new Water();
	private Sugar sugar = new Sugar();
	private PowderCoffee powderCoffee = new PowderCoffee();
	private PowderMilktea powderMilktea = new PowderMilktea();
	private Cup cup = new Cup();
	private Coin coin = new Coin();
	
	/**
	 * isMaking������������״̬��
	 * true�����˱ң����ܹ����κ���Ʒ��������Ӳ��ϣ�
	 * false����ȡ��Ʒ��
	 */
	private static boolean isMaking = false;
	public static boolean isMaking() { return isMaking; }
	public static void setIsMaking(boolean isMaking) { Status.isMaking = isMaking; }

	
	/**
	 * ���������жϲ����¹�����Ϣ
	 */
	public void updateMessage(){
		if (water.isNone() && sugar.isNone() && powderCoffee.isNone() && powderMilktea.isNone()
				&& cup.isNone() && (!coin.hasCoin())) {
			MovingMessagePanel.getAnInstance().setMessage("��ӭʹ�ÿ��Ȼ�����������");
		} else {
			isEnough(0);
		}
	}

	/**
	 * �ڹ���ͬ���࿧��ʱ�ж����Ƿ����
	 */
	public void prepareMaking(int type){
		switch (type) {
			case WEAKCOFFEE:
				if (isEnough(WEAKCOFFEE)) {
					Status.isMaking = true;
					powderCoffee.useOneCupOfWeakPower();
					water.useOneCupOfWater();
					sugar.useOneCupOfSugar();
					coin.useOneCoin();
					this.updateMonitoringWarnPanel();
					AnimationPanel.getAnInstance().setTypeAndPlay(WEAKCOFFEE);
				}
				break;

			case ESPRESSO:
				isEnough(ESPRESSO);
				if (isEnough(ESPRESSO)) {
					Status.isMaking = true;
					powderCoffee.useOneCupOfEspressPowder();
					water.useOneCupOfWater();
					sugar.useOneCupOfSugar();
					coin.useOneCoin();
					coin.useOneCoin();
					this.updateMonitoringWarnPanel();
					AnimationPanel.getAnInstance().setTypeAndPlay(ESPRESSO);
				}
				break;

			case MILKTEA:
				if (isEnough(MILKTEA)) {
					Status.isMaking = true;
					powderMilktea.useOneCupOfMilkteaPowder();
					water.useOneCupOfWater();
					sugar.useOneCupOfSugar();
					coin.useOneCoin();
					this.updateMonitoringWarnPanel();
					AnimationPanel.getAnInstance().setTypeAndPlay(MILKTEA);
				}
				break;

			default:
				break;
		}
	}

	/**
	 * �����������������Ϣ
	 */
	public void updateMonitoringWarnPanel() {
		MonitoringWarnPanel.getAnInstance().getWaterWarn().getIndicatorLabel().setLabel("ˮ��"+water.getVolumn());
		MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().getIndicatorLabel().setLabel("���ȣ�"+powderCoffee.getWeight());
		MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().getIndicatorLabel().setLabel("�̲裺"+powderMilktea.getWeight());
		MonitoringWarnPanel.getAnInstance().getSugarWarn().getIndicatorLabel().setLabel("�ǣ�"+sugar.getWeight());
		MonitoringWarnPanel.getAnInstance().getCupWarn().getIndicatorLabel().setLabel("���ӣ�"+cup.getQuantity());
		MonitoringShowPanel.getAnInstance().getCoinNumber().setCoinText(coin.getNumber());
	}
	
	/**
	 * �жϲ���ʾ׼���Ƿ����
	 * @param type ��Ʒ���ͣ�Ĭ��0��Ϊͨ���ж�
	 * @return
	 */
	public boolean isEnough(int type) {
		if (isMaking) {
			MovingMessagePanel.getAnInstance().setMessage(". . .������. . .");
		} else if (water.isNone()){
			MovingMessagePanel.getAnInstance().setMessage("�롾��ˮ��");
			return false;
		} else if (powderCoffee.isNone() || powderMilktea.isNone()) {
			MovingMessagePanel.getAnInstance().setMessage("�롾�ӷۡ�");
			return false;
		} else if (type==ESPRESSO && powderCoffee.getNumber()<10) {
			MovingMessagePanel.getAnInstance().setMessage("�롾�ӷۡ�");
			return false;
		} else if (sugar.isNone()) {
			MovingMessagePanel.getAnInstance().setMessage("�롾���ǡ�");
			return false;
		} else if (cup.isNone()) {
			MovingMessagePanel.getAnInstance().setMessage("�롾�ӱ���");
			return false;
		} else if (type==ESPRESSO && coin.getNumber()<2) {
			MovingMessagePanel.getAnInstance().setMessage("����Ҫ��Ͷ�ҡ�Ŷ");
			return false;
		} else if (!coin.hasCoin()) {
			MovingMessagePanel.getAnInstance().setMessage("���������롾Ͷ�ҡ�");
			return false;
		} else {
			MovingMessagePanel.getAnInstance().setMessage("�� ��ӭѡ�� ��");
		}
		return true;
	}
}
