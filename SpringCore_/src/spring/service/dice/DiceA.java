package spring.service.dice;

import java.util.Random;

/*
 * FileName : DiceA.java
 * �� �ֻ��� Object Modeling
 * �� 1 ~ 6 ���� �����ϰ�  ����
 */
public class DiceA {
	
	///Field
	private int value;

	///Constructor
	public DiceA() {
		System.out.println("::"+getClass().getName()+" ������....");
	}

	//Method (getter/setter)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//==> �ֻ����� ���� ���õǴ� ���ڸ� �����ϴ� ����(�������� ���� ����)
	public void selectedNumber(){
		value = new Random().nextInt(6) + 1;
	}
	
}//end of class




