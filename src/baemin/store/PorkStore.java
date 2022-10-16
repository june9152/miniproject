package baemin.store;

import java.util.ArrayList;
import java.util.List;

import baemin.store.menu.Menu;

public class PorkStore extends Store{
    private final int MINPRICE = 15000;
    private List<Menu> menuList = new ArrayList<>();

	public PorkStore() {
		super();
		setMenuList("족발", 18000);
		setMenuList("보쌈", 20000);
		setMenuList("불족발", 21000);
		setMenuList("굴족발", 25000);
		setMenuList("막국수", 8000);
	}

	public PorkStore(String storeName, int minPrice, List<Menu> menuList) {
		super(storeName, minPrice, menuList);
		// TODO Auto-generated constructor stub
	}

	public PorkStore(String storeName, int minPrice) {
		super(storeName, minPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Menu> getMenuList() {
		return menuList;
	}

	@Override
	public void setMenuList(String menuName, int price) {
		this.menuList.add(new Menu(menuName, price));
	}

}
