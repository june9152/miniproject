package baemin.order.member;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class MemberIO {
	
	public MemberIO() {
		super();
		File memberFile = new File("memberFile.ser");
		try {
			boolean exist = memberFile.exists();
			
			if(exist) {
				  if(loadMemberMap() == null) {
		               FileOutputStream fos = new FileOutputStream(memberFile);
		               loadMemberMap();
		            }
			}else{
				FileOutputStream fos = new FileOutputStream(memberFile);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Member> loadMemberMap(){
		
		try(FileInputStream fis = new FileInputStream("memberFile.ser"); 
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);){
				
			HashMap<String, Member> memberMap = (HashMap<String,Member>) ois.readObject();
			
			return memberMap;
		}
		catch (EOFException e) {
			System.out.println("File 비어있음 파일 재생성 ");
			HashMap<String, Member> tmp = new HashMap<>();
			saveMemberMap(tmp);
			//e.printStackTrace();
		}
		catch (IOException | ClassNotFoundException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void saveMemberMap(HashMap<String, Member> memberMap) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("memberFile.ser")))) {
			oos.writeObject(memberMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
