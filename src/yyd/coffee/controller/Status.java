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


//1.实体类：如银行系统中的银行顾客、帐户、帐号交易等，与实现技术无关；

//2.控制类：控制整个业务的流程和执行次序；

//3.边界类：处理系统的输入与输出。
/**
 * 状态控制与信息更新
 * @author yyd
 *
 */
public class Status {
	
	//饮品种类
	public static final int WEAKCOFFEE = 1;	//淡咖啡
	public static final int ESPRESSO = 2;	//浓咖啡
	public static final int MILKTEA = 3;	//奶茶

	private Water water = new Water();
	private Sugar sugar = new Sugar();
	private PowderCoffee powderCoffee = new PowderCoffee();
	private PowderMilktea powderMilktea = new PowderMilktea();
	private Cup cup = new Cup();
	private Coin coin = new Coin();
	
	/**
	 * isMaking：正在制作的状态。
	 * true则不能退币，不能购买任何饮品，不能添加材料；
	 * false则不能取饮品。
	 */
	private static boolean isMaking = false;
	public static boolean isMaking() { return isMaking; }
	public static void setIsMaking(boolean isMaking) { Status.isMaking = isMaking; }

	
	/**
	 * 根据数据判断并更新滚动信息
	 */
	public void updateMessage(){
		if (water.isNone() && sugar.isNone() && powderCoffee.isNone() && powderMilktea.isNone()
				&& cup.isNone() && (!coin.hasCoin())) {
			MovingMessagePanel.getAnInstance().setMessage("欢迎使用咖啡机！请加入材料");
		} else {
			isEnough(0);
		}
	}

	/**
	 * 在购买不同种类咖啡时判断料是否充足
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
	 * 更新左侧数据面板的信息
	 */
	public void updateMonitoringWarnPanel() {
		MonitoringWarnPanel.getAnInstance().getWaterWarn().getIndicatorLabel().setLabel("水："+water.getVolumn());
		MonitoringWarnPanel.getAnInstance().getPowderCoffeeWarn().getIndicatorLabel().setLabel("咖啡："+powderCoffee.getWeight());
		MonitoringWarnPanel.getAnInstance().getPowderMilkteaWarn().getIndicatorLabel().setLabel("奶茶："+powderMilktea.getWeight());
		MonitoringWarnPanel.getAnInstance().getSugarWarn().getIndicatorLabel().setLabel("糖："+sugar.getWeight());
		MonitoringWarnPanel.getAnInstance().getCupWarn().getIndicatorLabel().setLabel("杯子："+cup.getQuantity());
		MonitoringShowPanel.getAnInstance().getCoinNumber().setCoinText(coin.getNumber());
	}
	
	/**
	 * 判断并提示准备是否充足
	 * @param type 饮品类型，默认0则为通用判断
	 * @return
	 */
	public boolean isEnough(int type) {
		if (isMaking) {
			MovingMessagePanel.getAnInstance().setMessage(". . .制作中. . .");
		} else if (water.isNone()){
			MovingMessagePanel.getAnInstance().setMessage("请【加水】");
			return false;
		} else if (powderCoffee.isNone() || powderMilktea.isNone()) {
			MovingMessagePanel.getAnInstance().setMessage("请【加粉】");
			return false;
		} else if (type==ESPRESSO && powderCoffee.getNumber()<10) {
			MovingMessagePanel.getAnInstance().setMessage("请【加粉】");
			return false;
		} else if (sugar.isNone()) {
			MovingMessagePanel.getAnInstance().setMessage("请【加糖】");
			return false;
		} else if (cup.isNone()) {
			MovingMessagePanel.getAnInstance().setMessage("请【加杯】");
			return false;
		} else if (type==ESPRESSO && coin.getNumber()<2) {
			MovingMessagePanel.getAnInstance().setMessage("您需要【投币】哦");
			return false;
		} else if (!coin.hasCoin()) {
			MovingMessagePanel.getAnInstance().setMessage("继续购买请【投币】");
			return false;
		} else {
			MovingMessagePanel.getAnInstance().setMessage("— 欢迎选购 —");
		}
		return true;
	}
}
