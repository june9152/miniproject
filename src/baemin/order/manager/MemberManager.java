package baemin.order.manager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import baemin.order.member.Member;
import baemin.order.member.MemberIO;
import baemin.store.Store;
import baemin.store.menu.Menu;

public class MemberManager {
	private MemberIO memberIO = new MemberIO();
	private HashMap<String, Member> memberMap;
	private String user = null;
	
	List<Store> stores = new ArrayList<>();
	List<Menu> menuList = new ArrayList<>();
	
	public void setMenu(String menuName, int price) {
		menuList.add(new Menu(menuName, price));
	}
	
	public List<Menu> getMenu() {
		return menuList;
	}
	
	
	public MemberManager() {
		this.memberMap = memberIO.loadMemberMap();
		if(this.memberMap == null) {
			this.memberMap = memberIO.loadMemberMap();
		}
	}
		
	// 회원추가
	public boolean memberPut(Member member) {
		String id =  member.getId();
		if(this.memberMap.containsKey(id)) {
			return false;
		}
		memberMap.put(member.getId(), member);
		memberIO.saveMemberMap(memberMap);
		return true;
		
		
//		Set<Map.Entry<String, Member>> memberSet = memberMap.entrySet();
//		Iterator<Map.Entry<String, Member>> iter = memberSet.iterator();
//		boolean bool = false;
//		
//		while(iter.hasNext()) {
//			Entry<String, Member> entry = iter.next();
//			if(member.getId().equals(entry.getKey())) {
//				bool =  false;
//			}else {
//				// 생성된 Member객체를 Map에 추가
//				memberMap.put(member.getId(), member);
//				// 실제 파일에도 실시간 기록
//				memberIO.saveMemberMap(memberMap);
//				bool = true;
//			}
//		}
//		return bool;	
	}
	
	// 회원탈퇴
	public boolean memberRemove(Member member) {
		// Map 열람 후 멤버 찾음
		Set<Map.Entry<String, Member>> memberSet = memberMap.entrySet();
		
		Iterator<Map.Entry<String, Member>> iter = memberSet.iterator();
		
		while(iter.hasNext()) {
			Entry<String, Member> entry = iter.next();
			if(member.equals(entry.getValue())) {
				memberMap.remove(entry.getKey());
				memberIO.saveMemberMap(memberMap);
				return true;
			}
		}
		return false;
	}
	
	// 로그인
	public boolean login(Member member) {
		if(memberMap.containsKey(member.getId())) {
			if(!member.getPassword().equals(memberMap.get(member.getId()).getPassword())) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				return false;
			}else {
				this.user = member.getId();
				return true;
			}
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
			return false;
		}
	}
	
	// 잔액확인
	public void status() {
        System.out.printf("[%s]님의 현재 잔액은 [%d]원입니다.\n", user, memberMap.get(user).getBalance());
    }
	
	// 계좌충전
	 public boolean deposit(long money) {
	        if(money>0) {
	        	long totalMoney = memberMap.get(user).getBalance() + money;
				memberMap.get(user).setBalance(totalMoney);
	    		memberIO.saveMemberMap(memberMap);
	            return true;
	        }
	        return false;
	    }
	 
	 // 장바구니 추가
	 public void addBasket(Menu menu) {
		 	int totalPrice = 0;
		 	menuList.add(menu);
			memberMap.get(user).setBasket(menuList); 
			totalPrice += menu.getPrice();
			System.out.println(memberMap.get(user).getBasket());
	 }
	 
	 public void removeBasket() {
		 menuList.removeAll(menuList);
		 memberMap.get(user).setBasket(null);
	 }
    
}
