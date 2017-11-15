package ModelPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployerDao {

	public static boolean addNewJob(String jobid,String cmpname,String contactname,String jobtitle,String workexp,String education,
			String category,String keyskills,String jobdesp,String city,String state){  
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"insert into jobs(jobid,companyname,contactname,jobtitle,workexp,education,jobcategory,jobskills,jobdescription,city,state) values (?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1,jobid);
		ps.setString(2,cmpname);
		ps.setString(3,contactname);  
		ps.setString(4,jobtitle);  
		ps.setString(5,workexp);
		ps.setString(6,education);
		ps.setString(7,category);  
		ps.setString(8,keyskills);
		ps.setString(9,jobdesp);
		ps.setString(10,city);
		ps.setString(11,state);
		int i = ps.executeUpdate();
		if(i>0) return true;
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean deleteJob(int jid){  
		try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");
        PreparedStatement ps= con.prepareStatement("delete from jobs where jid=?");
        ps.setInt(1, jid);
        
        int i = ps.executeUpdate();
        if(i>0) return true;
        }catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean updateJob(String jobid,String cmpname,String contactname,String jobtitle,String workexp,String education,
			String category,String keyskills,String jobdesp,String city,String state,int id){  
		try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");
        PreparedStatement ps= con.prepareStatement("update jobs set jobid=?,companyname=?,contactname=?,jobtitle=?,workexp=?,education=?,jobcategory=?,jobskills=?,jobdescription=?,city=?,state=? where jid=?");
        ps.setString(1,jobid);
		ps.setString(2,cmpname);
		ps.setString(3,contactname);  
		ps.setString(4,jobtitle);  
		ps.setString(5,workexp);
		ps.setString(6,education);
		ps.setString(7,category);  
		ps.setString(8,keyskills);
		ps.setString(9,jobdesp);
		ps.setString(10,city);
		ps.setString(11,state);
		ps.setInt(12,id);
        
        int i = ps.executeUpdate();
        if(i>0) return true;
        
        }catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean checkJobId(String jobid,String cmpname){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from jobs where jobid=? and companyname=?");   
		ps.setString(1,jobid);
		ps.setString(2,cmpname); 
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(jobid.equals(rs.getString("jobid"))) return false;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return true;
	}
	
}
