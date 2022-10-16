package baemin.store;

import java.util.ArrayList;
import java.util.List;

import baemin.store.menu.Menu;

public class FishStore extends Store{
    private final int MINPRICE = 30000;
    private List<Menu> menuList = new ArrayList<>();

    public FishStore() {
        super();
		setMenuList("안심돈까스", 15000);
		setMenuList("모둠회", 27000);
		setMenuList("치즈돈가스", 17000);
		setMenuList("연어덮밥", 13000);
		setMenuList("마제소바", 9000);
    }

    public FishStore(String storeName, int minPrice, List<Menu> menuList) {
        super(storeName, minPrice, menuList);
        // TODO Auto-generated constructor stub
    }

    public FishStore(String storeName, int minPrice) {
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