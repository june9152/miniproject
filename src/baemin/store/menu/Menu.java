package baemin.store.menu;

import java.io.Serializable;

public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;
	private String menuName;
	private int price;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(String menuName, int price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return menuName + "\t\t" + price + "원";
	}
	
}
