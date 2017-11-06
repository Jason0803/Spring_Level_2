package main.java.spring.service.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.spring.service.domain.User;
import main.java.spring.service.user.UserDao;

/* 
 * FileName : JdbcUserDaoImpl.java  ( Data Access Object ) 
 * :: Persistence(?) Layer �������̽� ���� �� RDBMS ����  CRUD ���� Ŭ����
 *    
 *  [[ �Ʒ��� ������ ����Ͽ� ���캸��...]]  
 * �� �� Method �� �ݺ���( ������(?) ) �� �κ��� ?
 * �� �� Method ��  �������� �κ��� ?
 * �� SQLException�� �߻��Ѵٸ�, ��������� ?
 *     - Connection �ν��Ͻ� ������ SQLException�� �߻� �Ѵٸ� ���� ���డ���Ѱ�
 *     - SQLException �߻��� Checked Exception ���� �ݵ�� try-catch 
 *    		::  ���� �Ұ����� SQLException ���� ���� try-catch �� �ݵ�� ����ؾ��Ѵ�.
 *    		
*/ 
public class JdbcUserDaoImpl implements UserDao{

	///Field
	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuser ="hr";
	private String dbpwd = "hr";

	///Constructor
	public JdbcUserDaoImpl() {
		System.out.println("::==>"+getClass().getName()+".UserDAO Default Constructor");
	}
	
	
	///Method
	//==> ȸ������ ::  INSERT ( ȸ������ )
	public int addUser(User user)  throws Exception{
		//::JDBC ������ ���� instance ����
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try{		
			//1�ܰ� connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			//2�ܰ� INSERT ���� ������ ���� 
			StringBuffer  insertQuery = new StringBuffer();
			insertQuery.append("INSERT ");
			insertQuery.append("INTO USERS( user_id,user_name,password,age,reg_date) ");
			insertQuery.append("VALUES( ? , ? , ? , ? , ? )");
			
			pStmt = con.prepareStatement( insertQuery.toString() );
			pStmt.setString(1,user.getUserId());
			pStmt.setString(2,user.getUserName());
			pStmt.setString(3,user.getPassword());
			pStmt.setInt(4, user.getAge());
			pStmt.setTimestamp(5, user.getRegDate());

			//3�ܰ� INSERT ����
			return pStmt.executeUpdate();
			
		}catch(ClassNotFoundException e){		
			throw new RuntimeException(e.getMessage(), e);
		}catch(SQLException e){		
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			//4. ������ DB�� ���õ� instance close
			if(pStmt != null){
				try{	
					pStmt.close();	
				}catch(Exception e2){  }
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception e3){  }
			}
		}
	}//end of method
	
	
	//==> ȸ������ ::  SELECT  ( ȸ������ �˻� ) 
	public User getUser(String userId) throws Exception {
		//::JDBC ������ ���� instance ����
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet result = null;
		
		try{		
			//1�ܰ� connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			//2�ܰ� SELECT �� ���� �� ���� 
			StringBuffer  userSelect = new StringBuffer();
			userSelect.append("SELECT ");
			userSelect.append("user_id, user_name, password, age, reg_date ");
			userSelect.append("FROM USERS ");
			userSelect.append("WHERE user_id = ?");
			
			pStmt = con.prepareStatement( userSelect.toString() );
			pStmt.setString(1,userId);

			//3�ܰ� SELECT ����
			 result = pStmt.executeQuery();
			
			 //4�ܰ� SELECT ��� ó��( ? ) ::  Domain Object �� ȸ������ set(Binding) 
			 User user = null;
			 if( result.next() ){
				 user = new User();
				 user.setUserId( result.getString("user_id") );
				 user.setUserName( result.getString("user_name") );
				 user.setPassword( result.getString("password") );
				 user.setAge( result.getInt("age"));
				 user.setRegDate( result.getTimestamp("reg_date"));
			 }
			 
			 return user;
			
		}catch(ClassNotFoundException e){		
			throw new RuntimeException(e.getMessage(), e);
		}catch(SQLException e){		
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			//5. ������ DB�� ���õ� instance close
			if(result != null){
				try{	
					result.close();
				}catch(Exception e1){  }
			}
			if(pStmt != null){
				try{	
					pStmt.close();
				}catch(Exception e2){  }
			}
			if(con != null){
				try{	
					con.close();
				}catch(Exception e3){  }
			}
		}
	}//end of method

	
	//==> ȸ������ ::  UPDATE  ( ȸ������ ����  )
	public int updateUser(User user) throws Exception {
		//::JDBC ������ ���� instance ����
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try{		
			//1�ܰ� connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			//2�ܰ� UPDATE �� ������ ����
			StringBuffer  userUpdate = new StringBuffer();
			userUpdate.append("UPDATE USERS ");
			userUpdate.append("SET  user_name = ?, password = ?,age = ? ");
			userUpdate.append("WHERE user_id = ?");
			
			pStmt = con.prepareStatement( userUpdate.toString() );
			pStmt.setString(1,user.getUserName());
			pStmt.setString(2,user.getPassword());
			pStmt.setInt(3, user.getAge());
			pStmt.setString(4,user.getUserId());

			//3�ܰ� UPDATE ����
			return pStmt.executeUpdate();
			
		}catch(ClassNotFoundException e){		
			throw new RuntimeException(e.getMessage(), e);
		}catch(SQLException e){		
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			//4. ������ DB�� ���õ� instance close
			if(pStmt != null){
				try{	
					pStmt.close();
				}catch(Exception e2){  }
			}
			if(con != null){
				try{
					con.close();		
				}catch(Exception e3){  }
			}
		}
	}
	
	
	//==> ȸ������ ::  DELETE  ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception{
		//::JDBC ������ ���� instance ����
		Connection con = null;
		PreparedStatement pStmt = null;
		
		try{		
			//1�ܰ� connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			//2�ܰ� DELETE �� ������ ���� 
			StringBuffer  userDelete = new StringBuffer();
			userDelete.append("DELETE ");
			userDelete.append("FROM USERS ");
			userDelete.append("WHERE user_id = ?");
			
			pStmt = con.prepareStatement( userDelete.toString() );
			pStmt.setString(1,userId);

			//3�ܰ� DELETE ����
			return pStmt.executeUpdate();
			
		}catch(ClassNotFoundException e){		
			throw new RuntimeException(e.getMessage(), e);
		}catch(SQLException e){		
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			//4. ������ DB�� ���õ� instance close
			if(pStmt != null){
				try{	pStmt.close();	}catch(Exception e2){  }
			}
			if(con != null){
				try{	con.close();		}catch(Exception e3){  }
			}
		}
	}//end of class
	
	
	//==> ȸ������ ::  SELECT  ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList() throws Exception {
		//::JDBC ������ ���� instance ����
		Connection con = null;
		PreparedStatement pStmt = null;
		ResultSet selectResult = null;
		
		try{		
			//1�ܰ� connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dburl,dbuser,dbpwd);
			
			//2�ܰ� SELECT �� ���� �� ���� 
			StringBuffer  userSelectAll = new StringBuffer();
			userSelectAll.append("SELECT ");
			userSelectAll.append("user_id, user_name, password, age, reg_date ");
			userSelectAll.append("FROM USERS ");
			
			pStmt = con.prepareStatement( userSelectAll.toString() );

			//3�ܰ� SELECT ����
			selectResult = pStmt.executeQuery();
			
			 //4�ܰ� SELECT ��� ó��( ? ) ::  Domain Object �� ȸ������ set(Binding) 
			//==> DB �� ����� ��� ȸ�������� ArrayList�� �����ϱ� ����....  
			ArrayList<User>arrayList = new ArrayList<User>();
			 
			 while( selectResult.next() ){
				 User user = new User();
				 user.setUserId( selectResult.getString("user_id") );
				 user.setUserName( selectResult.getString("user_name") );
				 user.setPassword( selectResult.getString("password") );
				 user.setAge( selectResult.getInt("age"));
				 user.setRegDate( selectResult.getTimestamp("reg_date"));
				 
				 arrayList.add(user);
			 }
			 
			 return arrayList;
			
		}catch(ClassNotFoundException e){		
			throw new RuntimeException(e.getMessage(), e);
		}catch(SQLException e){		
			throw new RuntimeException(e.getMessage(), e);
		}finally{
			//5. ������ DB�� ���õ� instance close
			if(selectResult != null){
				try{	
					selectResult.close();
				}catch(Exception e1){  }
			}
			if(pStmt != null){
				try{	
					pStmt.close();
				}catch(Exception e2){  }
			}
			if(con != null){
				try{	
					con.close();
				}catch(Exception e3){  }
			}
		}		
	}//end of Method
	
}//end of class