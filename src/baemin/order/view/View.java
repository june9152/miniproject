package baemin.order.view;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import baemin.order.manager.MemberManager;
import baemin.order.member.Member;
import baemin.store.FishStore;
import baemin.store.PorkStore;
import baemin.store.SoupStore;
import baemin.store.Store;
import baemin.store.menu.Menu;

public class View {
	private MemberManager memberManager = new MemberManager();
	private Scanner sc = new Scanner(System.in);
	int index;
	List<Store> storeList = new ArrayList<>();
	PorkStore porkstore = new PorkStore();
	SoupStore soupstore = new SoupStore();
	FishStore fishstore = new FishStore();
	
	public View() {
		storeList.add(porkstore);
		storeList.add(soupstore);
		storeList.add(fishstore);
	}

	public void firstView() {
		String firstView = "==================================\n"
						 + "\t로그인을 해주세요\n"
						 + "==================================\n"
						 + "1. 로그인\n"
						 + "2. 회원가입\n"
						 + "3. 회원탈퇴 \n"
						 + "4. 종료하기\n"
						 + "==================================\n"
						 + "선택 : ";
		
		while(true) {
			System.out.print(firstView);
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1" : boolean bool = memberManager.login(inputMember());
					   System.out.println(bool == true ? "정상적으로 로그인됐습니다." : "다시 시도해주세요.");
					   if(bool == true) {
					   afterLoginMenu(); 
					   }else {
						   break;
					   }
					   break;
			case "2" : System.out.println(memberManager.memberPut(inputMember()) == true ? "정상적으로 가입 완료됐습니다." : "이미 존재하는 ID입니다."); break;
			case "3" : System.out.println(memberManager.memberRemove(inputMember()) == true ? "정상적으로 탈퇴됐습니다." : "존재하지 않는 회원정보 입니다."); break;
			case "4" : System.out.println("이용해주셔서 감사합니다.");return;
			default : System.out.println("잘못 입력하셨습니다.");break;
			}
		}
	}
	
	public void afterLoginMenu() {
        String afterLoginMenu = "==================================\n"
                              + "\t회원메뉴\n"
                              + "==================================\n" 
                              + "1. 계좌 메뉴(잔액확인/충전)\n" 
                              + "2. 주문 메뉴\n"
                              + "3. 로그아웃\n"
                              + "==================================\n"
                              + "선택 : ";

        while (true) {
        	System.out.print(afterLoginMenu);
            String choice = sc.nextLine();
            switch (choice) {
            case "1": accountMenu(); break;
            case "2": order(); break;
            case "3": memberManager.removeBasket(); return;
            default : System.out.println("잘못 입력하셨습니다."); break;

            }
        }
    }
	
	public void accountMenu() {
		
		String menu = "==================================\n" +
					  "\t계좌 메뉴\n"+
				 	  "==================================\n" +
					  "1. 잔액 확인\r\n" +
					  "2. 충전\r\n" +
					  "3. 뒤로가기\r\n" +
					  "==================================\n" +
					  "선택 : ";
		
		while(true) {
			System.out.print(menu);
			
			String choice = sc.next();
			
			switch(choice) {
			case "1" : memberManager.status(); break;
			case "2" : System.out.println(memberManager.deposit(inputMoney()) == true ? "정상적으로 충전되었습니다." : "올바른 금액을 입력해주세요.");break;
			case "3" : System.out.println("뒤로가기를 선택하셨습니다."); return;
			default : System.out.println("잘못입력하셨습니다.");break;
			}
		}
				
	}

	
	public void order() {
		String orderView = "==================================\n"
				 		 + "\t음식점을 선택해주세요.\n"
				 		 + "==================================\n"
				 		 + "1. 족발, 보쌈집\n"
				 		 + "2. 찜, 탕, 찌개집\n"
				 		 + "3. 돈까스, 회, 일식집\n"
				 		 + "4. 뒤로가기\n"
				 		 + "==================================\n"
				 		 + "선택 : ";
		
		while(true) {
			System.out.print(orderView);
			String choice = sc.nextLine();
			int i = Integer.parseInt(choice);
			switch(choice) {
			case "1" : pork(); this.index = i-1; break;
			case "2" : soup(); this.index = i-1;  break;
			case "3" : fish(); this.index = i-1; break;
			case "4" : return;
			default : System.out.println("잘못 입력하셨습니다.");break;
			}
			
		}
	}
	
	public void pork() {

		while(true) {
			System.out.print("==================================\n"
							  + "\t족발 보쌈을 선택하셨습니다.\n"
							  + "\t메뉴를 선택해주세요.\n"
							  + "==================================\n");
			List<Menu>porkMenu = new ArrayList<>();
			porkMenu = porkstore.getMenuList();
			for(int i = 0; i < porkMenu.size(); i++) {
				System.out.println((i+1) + ". " + porkMenu.get(i).toString());
			}
			System.out.print("6. 뒤로가기\n"
							 + "==================================\n"
							 + "선택 : ");
			String choice = sc.nextLine();
			int i = Integer.parseInt(choice);
			switch(choice) {
			case "1" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "2" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "3" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "4" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "5" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "6" : return;
			default : System.out.println("잘못 입력하셨습니다.");break;
			}
		}
	}
	

	public void soup() {
		
		while(true) {
			System.out.print("==================================\n"
							  + "\t찜 탕 찌개를 선택하셨습니다.\n"
							  + "\t메뉴를 선택해주세요.\n"
							  + "==================================\n");
			List<Menu>soupMenu = new ArrayList<>();
			soupMenu = soupstore.getMenuList();
			for(int i = 0; i < soupMenu.size(); i++) {
				System.out.println((i+1) + ". " + soupMenu.get(i).toString());
			}
			System.out.print("6. 뒤로가기\n"
							 + "==================================\n"
							 + "선택 : ");
			String choice = sc.nextLine();
			int i = Integer.parseInt(choice);
			switch(choice) {
			case "1" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "2" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "3" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "4" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "5" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "6" : return;
			default : System.out.println("잘못 입력하셨습니다.");break;
			}
		}
    }
	
	public void fish() {
		
		while(true) {
			System.out.print("==================================\n"
							  + "\t돈가스 회 일을 선택하셨습니다.\n"
							  + "\t메뉴를 선택해주세요.\n"
							  + "==================================\n");
			List<Menu>fishMenu = new ArrayList<>();
			fishMenu = fishstore.getMenuList();
			for(int i = 0; i < fishMenu.size(); i++) {
				System.out.println((i+1) + ". " + fishMenu.get(i).toString());
			}
			System.out.print("6. 뒤로가기\n"
							 + "==================================\n"
							 + "선택 : ");
			String choice = sc.nextLine();
			int i = Integer.parseInt(choice);
			switch(choice) {
			case "1" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "2" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "3" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "4" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "5" : memberManager.addBasket(storeList.get(index).getMenuList().get(i)); break;
			case "6" : return;
			default : System.out.println("잘못 입력하셨습니다.");break;
			}
		}
	}
	
	public Member inputMember() {
		System.out.print("아이디를 입력해주세요 : ");
		String id = sc.nextLine();
		System.out.print("패스워드를 입력해주세요 : ");
		String password = sc.nextLine();
		
		return new Member(id, password);
	}
	
	public long inputMoney() {
        System.out.print("충전금액을 입력해주세요 : ");
        long money  = sc.nextLong();
        
        return money;
    }
	
}