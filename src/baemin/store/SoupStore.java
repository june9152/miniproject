package baemin.store;

import java.util.ArrayList;
import java.util.List;

import baemin.store.menu.Menu;

public class SoupStore extends Store{
	private final int MINPRICE = 20000;
    private List<Menu> menuList = new ArrayList<>();

    public SoupStore() {
        super();
		setMenuList("갈비찜", 32000);
		setMenuList("아구찜", 28000);
		setMenuList("닭볶음탕", 25000);
		setMenuList("김치찌개", 15000);
		setMenuList("된장찌개", 12000);
    }

    public SoupStore(String storeName, int minPrice, List<Menu> menuList) {
        super(storeName, minPrice, menuList);
        // TODO Auto-generated constructor stub
    }

    public SoupStore(String storeName, int minPrice) {
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
