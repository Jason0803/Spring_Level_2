package spring.service.dice;

import java.util.Random;

/*
 * FileName : DiceB.java
 * �� �ֻ��� Object Modeling
 * �� 1 ~ 6 ���� �����ϰ�  ����
 */
public class DiceB {
	
	///Field
	private int value;

	///Constructor
	public DiceB() {
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