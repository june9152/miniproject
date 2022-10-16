package baemin.order.member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import baemin.store.Store;
import baemin.store.menu.Menu;

public class Member implements Serializable {

    private static final long serialVersionUID = 1L;
	private String id;
    private String password;
    private long balance;
    private List<Menu> basket = new ArrayList<>();
    
    public Member() {
        super();
    }
    
    public Member(String id, String password) {
    	super();
    	this.id = id;
    	this.password = password;
    	this.balance = 0;
    	this.basket = null;
    }

    public Member(String id, String password, long balance, List<Menu> basket) {
        super();
        this.id = id;
        this.password = password;
        this.balance = balance;
        this.basket = basket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Menu> getBasket() {
        return basket;
    }

    public void setBasket(List<Menu> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Member [id=" + id + ", password=" + password + ", balance=" + balance + ", basket=" + basket + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, basket, id, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        return balance == other.balance && Objects.equals(basket, other.basket) && Objects.equals(id, other.id)
                && Objects.equals(password, other.password);
    }
    

}