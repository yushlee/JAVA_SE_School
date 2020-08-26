package com.training.session4.drink;

public class DrinkMachineReturn {
	
	// 飲料類型(EX:可樂、芬達、雪碧)
	private String drinkType;
	// 販賣機找零
	private int changeCoin;
	
	public String getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}
	public int getChangeCoin() {
		return changeCoin;
	}
	public void setChangeCoin(int changeCoin) {
		this.changeCoin = changeCoin;
	}
	@Override
	public String toString() {
		return "DrinkMachineReturn [drinkType=" + drinkType + ", changeCoin="
				+ changeCoin + "]";
	}
	
	

}
