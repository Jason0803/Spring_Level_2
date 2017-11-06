package spring.service.hello.test;

import spring.service.hello.Hello;

/*
 * FileName : HelloTestApp01.java
 * �� Hello.class ����ϴ� Application
 */
public class HelloTestApp01 {
	
	///main method
	public static void main(String[] args) {
		//==>1. instance ���� 
		Hello hello = new Hello();
		//==> 2. printMessage() method ȣ��
		hello.printMessage();
	}
	
}//end of class

/*
 * [ ����� ���� :: �ٸ� Bean ��� �� ��� Message ���� ��... ]
 * 
 * 1. new Hello() �� instance ���� �ϵ��ڵ�
 * 		-  Hello.class, ���� class �Ǵ� �ٸ� class ����� �� ��� 
 * 			==>  �ٽ� �ڵ� �� ������ ���� ����
 * 
 * 2. ����� message �ϵ� �ڵ� 
 *		-  �ٸ� message �� ������� �Ѵٸ� 
 *			==> �ٽ� �ڵ� �� ������ ���� ���� ( :: setter Method �� ������� ���� ���� ���� )
 *
 *  ==> ���� �ϵ��ڵ��� �κ�(1.instance ����, 2.��� message)�� 
 *  		text file(�ΰ�����,Meta Data) �� �����ϰ�  Application �� runtime ��  text �� ����� ������ 
 *  		�о� �����ϴ� �������,  ��� �� instance/message ��  ��������� �߻��ϸ� text�� ����
 *  		Application ��  text �� ���� ���޵� ������ ��� ������ Bean �� ���� �� �ʿ䰡 ����
 *         ( text/��Ÿ�������� Ȱ�� )
 */