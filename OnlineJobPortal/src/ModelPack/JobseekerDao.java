package ModelPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JobseekerDao {
	
	public static boolean applyJob(String jobid,String jobcompany,String username,String firstname,String lastname){  
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"insert into appliedjobs(jobid,companyname,username,firstname,lastname) values (?,?,?,?,?)");
		ps.setString(1,jobid);
		ps.setString(2,jobcompany);
		ps.setString(3,username);  
		ps.setString(4,firstname);  
		ps.setString(5,lastname);
		int i = ps.executeUpdate();
		if(i>0) return true;
		}
		catch(Exception e)
		{System.out.println(e);}  
		return false;
	}
	
	public static boolean checkApplied(String jobid,String jobcompany,String username){
		try
		{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");  
		      
		PreparedStatement ps=con.prepareStatement(  
		"select * from appliedjobs where jobid=? and companyname=? and username=?");   
		ps.setString(1,jobid);
		ps.setString(2,jobcompany);
		ps.setString(3,username);
		ResultSet rs = ps.executeQuery();
		      
		if(rs.next()){
			if(jobid.equals(rs.getString("jobid"))) return false;            
		}
		}
		catch(Exception e)
		{System.out.println(e);}  
		return true;
	}
	
	public static boolean cancelApplyJob(int id){  
		try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal?zeroDateTimeBehavior=convertToNull","root","root");
        PreparedStatement ps= con.prepareStatement("delete from appliedjobs where ajid=?");
        ps.setInt(1, id);
        
        int i = ps.executeUpdate();
        if(i>0) return true;
        }catch(Exception e)
		{System.out.println(e);}  
		return false;
	}

}
