package spring.service.hello;

/*
 * FileName : Hello.java
 * �� package / private Field(property) / Constructor / getter,setter / �ʿ��� Method 
 * ���� ���� �� �Ծ��� ���� �Ϲ����� Bean ::  POJO(Plain Old Java Object)
 */
public class Hello{
	
	///Field
	private String message = "Container �� ?????";
	
	///Constructor Method
	public Hello() {
	}
	public Hello(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message �� ����ϴ� Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class