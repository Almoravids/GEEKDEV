package pack;

import javax.annotation.PostConstruct;

public class TEST {
	{
		System.out.println("BLock");
	}
	
	public TEST() {
		System.out.println("Const");	}
	@PostConstruct
	void init(){
		System.out.println("pConst");
	}
public static void main(String[] args) {
new TEST();
	}
}
                            