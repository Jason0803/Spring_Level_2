package spring.service.hello.test;

import spring.service.hello.Hello;
import spring.service.hello.HelloFactory;
/*
 * FileName : HelloTestApp02.java
 * �� Hello.class �� ����ϴ� Application 
 * �� [ HelloTestApp01�� �� ]
 * 		- �����  Bean �� hello.properties(meta-data)�� text �� ���� �ϰ�...
 * 		- instance �� ���� �������� ������, HelloFactory ���� return �Ǵ� instance ���.
 */
public class HelloTestApp02 {
	
	///main method
	public static void main(String[] args) {
		
		// 1. ����� Bean  ������ ����  hello.properties(meta-data)��
		//      parsing, Bean instance�� ������ HelloFactory  instance ����
		HelloFactory helloFactory =	HelloFactory.getInstance();
		
		// 2.  helloFactory instance �� parsing �� resource::meta-data(hello.properties) ����   
		helloFactory.setConfigResource("./src/main/resources/config/hello.properties");
		
		// 3. helloFactory instance �� ���� instance.one �̸��� ���� Hello instance Request  
		Hello hello = helloFactory.getBean("instance.one");
		
		// 4.  printMessage() ȣ��  
		hello.printMessage();
	}
	
}//end of class


/*
 * [[[[[[ HelloTestApp01 ����� ���� ]]]]]] �� ��
 * 
 * [ ����� ���� :: �ٸ� Bean ��� �� ��� Message ���� ��... ]
 * 
 * 1. new Hello() �� instance ���� �ϵ��ڵ�
 * 		-  Hello.class, ���� class �Ǵ� �ٸ� class ����� �� ��� 
 * 			==>  �ٽ� �ڵ� �� ������ ���� ����
 *     [[[[[[ HelloTestApp02 ���� ]]]]]] 
 *     		 : �ٸ� Bean ����� ��� hello.properties �� ������ �����Ѵٸ�....
 *          ==>[�ѹ��� ���...]
 *          ==> ����� Data Type  Hello ������ Hello �� ���� ���� ���� 
 *          ==> �ٸ� Data type �� ������....
 *                  (HelloFactory�� Hello Type �� ���� ���� �Ѵ�....)
 * 
 * 2. ����� message �ϵ� �ڵ� 
 *		-  �ٸ� message �� ������� �Ѵٸ� 
 *			==> �ٽ� �ڵ� �� ������ ���� ���� ( :: setter Method �� ������� ���� ���� ���� )
 *     [[[[[[ HelloTestApp02 ���� ]]]]]]
 *     		 : HelloTestApp02�� ������ ������������...
 *			 ==> hello.properties �� Message �� ���� �ҷ��� �� �ִٸ�....
 *
 *
 *  ==> ���� �ϵ��ڵ��� �κ�(1.instance ����, 2.��� message)�� 
 *  		text file(�ΰ�����,Meta Data) �� �����ϰ�  Application �� runtime ��  text �� ����� ������ 
 *  		�о� �����ϴ� �������,  ��� �� instance/message ��  ��������� �߻��ϸ� text �� ����
 *  		Application ��  text �� ���� ���޵� ������ ��� ������ Bean �� ���� �� �ʿ䰡 ����
 *         ( text/��Ÿ�������� Ȱ�� )
 */