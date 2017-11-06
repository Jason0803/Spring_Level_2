package spring.service.hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
 * FileName : HelloFactory.java
 * �� hello.properties file(�ΰ�����,Meta-Data) �� ������ �о� Hello instance �� ���� return.
 */
public class HelloFactory {
	///Field
	private Hello hello;
	private Properties properties;
	private static HelloFactory helloFactory;
	
	///Constructor Method
	private HelloFactory(){
	}
	
	///Method
	//==> HelloFactory instance ��  return �ϴ� static method(SingleTon) 
	public synchronized static  HelloFactory getInstance() {
		if( helloFactory == null){
			helloFactory = new HelloFactory();
		}
		return helloFactory;
	}
	
	//==> properties file �� �߻�ȭ,ĸ��ȭ��  java.util.Properties instance ���� 
	public void setConfigResource(String configResource) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configResource);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("1. hello.proerties ������ ã���� ����.");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("2. hello.proerties ���� �ʱ�ȭ �� ���� �߻�.");
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();	
				}
			}
		}
	}	

  	//==> name �� �ش��ϴ� instance ����:: default constructor  
	private void newInstanceHello(String name){
		
		String className = properties.getProperty(name).trim();  //==> trim() �յ� ���� trim
		System.out.println("!! debug=>hello.properties ���� ������ className : "+className);

		try {
			Class  cls = Class.forName(className);
			Object obj = cls.newInstance();
			//==> Hello Instance Ȯ��
			if( obj instanceof Hello){
				this.hello = (Hello)obj;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("1. "+className +"�� �̸��� ���� class�� ����.");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("2. "+className +"�� instance ������ ���� �߻�.");
		}
	}
	
  	//==> Hello instance �����ϴ� newInstanceHello() ȣ�� �� Hello instance �� return
	public Hello getBean(String name){
		this.newInstanceHello(name);
		return hello;
	}
	
}//end of class