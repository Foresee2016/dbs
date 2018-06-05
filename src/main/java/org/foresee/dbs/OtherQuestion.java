package org.foresee.dbs;

public class OtherQuestion {
	public static void main(String[] args) {
		int i=0;
		while(i<100000){
			if(i%2==1){
				if(i%3==0){
					if(i%4==1){
						if(i%5==1){
							if(i%6==3){
								if(i%7==0){
									if(i%8==1){
										if(i%9==0){
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			i++;
		}
		if(i<100000){
			System.out.println("The number is: "+i);
		}else {
			System.out.println("Not found this number");
		}
	}
}
