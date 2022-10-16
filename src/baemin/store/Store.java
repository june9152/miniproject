package baemin.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import baemin.store.menu.Menu;

public abstract class Store {
    private String storeName;
    private int minPrice;
    private List<Menu> menuList = new ArrayList<>();

    public abstract List<Menu> getMenuList();

	public abstract void setMenuList(String menuName, int price);

	public Store() {
        super();
    }

    public Store(String storeName, int minPrice) {
        super();
        this.storeName = storeName;
        this.minPrice = minPrice;
    }

    public Store(String storeName, int minPrice, List<Menu> menuList) {
		super();
		this.storeName = storeName;
		this.minPrice = minPrice;
		this.menuList = menuList;
	}

	public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    @Override
    public String toString() {
        return "Store [storeName=" + storeName + ", minPrice=" + minPrice + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(minPrice, storeName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Store other = (Store) obj;
        return minPrice == other.minPrice && Objects.equals(storeName, other.storeName);
    }

}