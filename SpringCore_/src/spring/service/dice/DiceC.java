package spring.service.dice;

import java.util.Random;

/*
 * FileName : DiceC.java
 * �� �ֻ��� Object Modeling
 * �� 1 ~ 6 ���� �����ϰ�  ����
 */
public class DiceC {
	
	///Field
	private int value;

	///Constructor
	public DiceC() {
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