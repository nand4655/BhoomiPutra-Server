package dao;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialException;

import sun.misc.BASE64Decoder;
import tool_dto.ToolAddress;
import tool_dto.Tools;
import tool_dto.ToolsProvider;
import tool_dto.ToolsProviderAssets;

import com.google.gson.Gson;

import dto.Address;
import dto.Cattles;
import dto.Farmer;
import dto.FarmersAsset;



public class DataBaseManager 
{
public static String getfarmerbyId(int id)
	{
	String name;
	long mobileno;
	int id1;
	String password;
	String house_no_block;
	String village;
	String tehsil;
	String district;
	String state;
	int pincode;
	double totalLand;
	ArrayList<String> maincrops;
	
	
	Farmer farmer=null;
	Address addr=null;
	FarmersAsset asset=null;
	
	String query1="select * from  farmers,addresses, personal_assets where  farmers.f_id=? and addresses.f_id =? and personal_assets.f_id =?";
	Connection con=DBConnection.connect();
	
	try
		{
			PreparedStatement pst=con.prepareStatement(query1);
			pst.setInt(1, id);
			pst.setInt(2, id);
			pst.setInt(3, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
						village=rs.getString("village");
						house_no_block=rs.getString("house_no_block");
						tehsil=rs.getString("tehsil");
						district=rs.getString("district");
						state=rs.getString("state");
						//pincode=rs.getInt("pincode");
						addr=new Address(village,house_no_block,tehsil, district, state,1223);
						totalLand=rs.getDouble("total_Land");
					// maincrops=rs.getString("maincrop");
					//	int count=rs.getInt("animalcount");
						//	String animalname=rs.getString("animalname");
						//  Cattles animal=new Cattles(animalname, count);
						asset=new FarmersAsset(totalLand, null, null,null);
						id1=rs.getInt("f_id");
						name=rs.getString("name");
						mobileno=rs.getLong("mobile_no");
						
						farmer=new Farmer(id1, name, mobileno, addr, asset);						
				}
				rs.close();
				pst.close();
				con.close();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	Gson g=new Gson();
	String json=g.toJson(farmer);
	return json;
}

public static String getAllFarmer()
{
	String name;
	long mobileno;
	int id1;
	String password;
	String house_no_block;
	String village;
	String tehsil;
	String district;
	String state;
	int pincode;
	double totalLand;
	String maincrops;
	
	ArrayList<Farmer> farmerArray=new ArrayList<Farmer>();
	Address addr=null;
	FarmersAsset asset=null;
	String query1="select f_id from  farmers";
	Connection con=DBConnection.connect();
	try
	{
		PreparedStatement pst1=con.prepareStatement(query1);
	
		ResultSet rs1=pst1.executeQuery();
		
		while(rs1.next())
		{
			int id=rs1.getInt("f_id");
			String query2="select * from  farmers,addresses, personal_assets where  farmers.f_id=? and addresses.f_id =? and personal_assets.f_id =?";
			PreparedStatement pst2=con.prepareStatement(query2);
			pst2.setInt(1, id);
			pst2.setInt(2, id);
			pst2.setInt(3, id);
			ResultSet rs2=pst2.executeQuery();
			if(rs2.next())
			{
				village=rs2.getString("village");
				house_no_block=rs2.getString("house_no_block");
				tehsil=rs2.getString("tehsil");
				district=rs2.getString("district");
				state=rs2.getString("state");
			// pincode=rs2.getInt("pincode");
				addr=new Address(village, house_no_block,tehsil, district, state,1223);
				totalLand=rs2.getDouble("total_Land");
		//	 maincrops=rs2.getString("maincrop");
		//		int count=rs2.getInt("animalcount");
					//String animalname=rs2.getString("animalname");
				  //Animals animal=new Animals(animalname, count);
				//asset=new FarmersAsset(totalLand, null, null);
				id1=rs2.getInt("f_id");
				name=rs2.getString("name");
			mobileno=rs2.getLong("mobile_no");
			Farmer farmer=new Farmer(id1, name, mobileno, addr, asset);						
			farmerArray.add(farmer);
			}
			rs2.close();
			pst2.close();
		}
				rs1.close();
				pst1.close();
				
				con.close();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
Gson g=new Gson();
String json=g.toJson(farmerArray);
return json;
}

public static Boolean insertfarmer(Farmer farmer)
{	
	String name=farmer.getName();
	long mobileno=farmer.getMobileno();
	String password=farmer.getPassword();
	
	
	
	Address address= farmer.getAddr();
	
	String  house_no_block=address.getHouseNo();
	String village=address.getVillage();
	String tehsil=address.getTehsil();
	String district=address.getDistrict();
	String state=address.getState();
	int pincode=address.getPincode();
	
	FarmersAsset asset= farmer.getAsset();
	
	double total_Land=12; //asset.getTotalLand();

	String maincrops;
	

	int	max_id=0;
	
	
	String query1="insert all into farmers (f_id,name,mobile_no,password) values (f_id_seq.nextval,?,?,?) into addresses(f_id,house_no_block,village,tehsil,district,state) values(f_id_seq.currval,?,?,?,?,?) into personal_assets(f_id,total_land) values(f_id_seq.currval,?) SELECT * FROM dual";
	Connection con=DBConnection.connect();
	try
	{
		PreparedStatement pst1=con.prepareStatement(query1);
		pst1.setString(1,name);
		pst1.setLong(2,mobileno);
		pst1.setString(3,password);
		pst1.setString(4, house_no_block);
	    pst1.setString(5, village);
	    pst1.setString(6, tehsil);
	    pst1.setString(7, district);
	    pst1.setString(8, state);
	    pst1.setDouble(9, total_Land);
	    ResultSet rs1=pst1.executeQuery();
		if(rs1.next())
		{
			
			
			
			return true;
			
			/*String query2="select max(f_id) from farmers";
			PreparedStatement pst2=con.prepareStatement(query2);
		    ResultSet rs2=pst2.executeQuery();
		    if(rs2.next())
			{
		    	max_id=rs2.getInt(0);
			
			}
			rs2.close();
			 pst2.close();*/
		}
			 
			
		   
			 rs1.close();
			 pst1.close();
				
				con.close();
		
	}
	 catch(Exception e)
	  {
		e.printStackTrace();
	  }
	return false;
}


public static Integer farmerLoginDetail(String fmobileno,String Fpassword)
{
	System.out.println("in function");
String password;

int f_id=0;
String query1="select f_id,password from  farmers where mobile_no=?";
Connection con=DBConnection.connect();

try
	{
	System.out.println("in try");
		PreparedStatement pst=con.prepareStatement(query1);
		pst.setString(1,fmobileno);
	
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			System.out.println("in if outer");
					password=rs.getString("password");
					if(password.equals(Fpassword))
					{
						f_id=rs.getInt("f_id");
						System.out.println("in if");
					}
					
									
			}
			rs.close();
			pst.close();
			con.close();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

return f_id;
}

public static Integer getMaxFarmerId(long mobile) {
	
	Connection con=DBConnection.connect();
	int f_id=9;
	String query2="select f_id from farmers where mobile_no=?";
try {
		PreparedStatement pst2=con.prepareStatement(query2);
		pst2.setLong(1,mobile);
		
		ResultSet rs2=pst2.executeQuery();
		if(rs2.next())
		{
	      f_id=rs2.getInt("f_id");
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	
	
	return f_id;
}

public static Integer toolLoginDetail(String tmobileno,String tpassword)
{

String password;

int t_id=0;
String query1="select t_id,password from  TOOL_PROVIDERS where mobile_no=?";
Connection con=DBConnection.connect();

try
	{
		PreparedStatement pst=con.prepareStatement(query1);
		pst.setString(1,tmobileno);
	
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
					password=rs.getString("password");
					if(password.equals(password))
					{
						t_id=rs.getInt("t_id");
						
					}
					
									
			}
			rs.close();
			pst.close();
			con.close();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

return t_id;
}

public static Integer vendorLoginDetail(String tmobileno,String tpassword)
{

String password;

int t_id=0;
String query1="select v_id,password from  vendors where mobile_no=?";
Connection con=DBConnection.connect();

try
	{
		PreparedStatement pst=con.prepareStatement(query1);
		pst.setString(1,tmobileno);
	
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
					password=rs.getString("password");
					if(password.equals(password))
					{
						t_id=rs.getInt("v_id");
						
					}
					
									
			}
			rs.close();
			pst.close();
			con.close();
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}

return t_id;
}



public static Boolean inserttoolsprovider(ToolsProvider toolsprovider)
{	
	String name=toolsprovider.getName();
	long mobileno=toolsprovider.getMobileno();
	String password=toolsprovider.getPassword();
	
	
	
	ToolAddress address= toolsprovider.getAddr();
	
	String  house_no_block=address.getHouseNo();
	String village=address.getVillage();
	String tehsil=address.getTehsil();
	String district=address.getDistrict();
	String state=address.getState();
	int pincode=address.getPincode();
	
	ArrayList<Tools> toolList= toolsprovider.getTools();
	
	int TOOL_COUNT=12; //asset.getTotalLand();

	String TOOL_NAME;
	double RATE_HR;

	int	max_id=0;
	
	
	String query1="insert all into TOOL_PROVIDERS (T_ID,name,mobile_no,password) values (T_ID_seq.nextval,?,?,?) into addresses(f_id,house_no_block,village,tehsil,district,state) values(f_id_seq.currval,?,?,?,?,?) into personal_assets(f_id,total_land) values(f_id_seq.currval,?) SELECT * FROM dual";
	Connection con=DBConnection.connect();
	try
	{
		PreparedStatement pst1=con.prepareStatement(query1);
		pst1.setString(1,name);
		pst1.setLong(2,mobileno);
		pst1.setString(3,password);
		pst1.setString(4, house_no_block);
	    pst1.setString(5, village);
	    pst1.setString(6, tehsil);
	    pst1.setString(7, district);
	    pst1.setString(8, state);
	    pst1.setDouble(9, TOOL_COUNT);
	    ResultSet rs1=pst1.executeQuery();
		if(rs1.next())
		{
			
			
			
			return true;
			
			/*String query2="select max(f_id) from farmers";
			PreparedStatement pst2=con.prepareStatement(query2);
		    ResultSet rs2=pst2.executeQuery();
		    if(rs2.next())
			{
		    	max_id=rs2.getInt(0);
			
			}
			rs2.close();
			 pst2.close();*/
		}
			 
			
		   
			 rs1.close();
			 pst1.close();
				
				con.close();
		
	}
	 catch(Exception e)
	  {
		e.printStackTrace();
	  }
	return false;
}



public static Boolean addImageToDb(String image,int id)
{
	
	
	
	try {
		
		BASE64Decoder decoder=new BASE64Decoder();
		byte[] arr;
		arr = decoder.decodeBuffer(image);
		Connection con=DBConnection.connect();
		Blob blob=null;
		
			//blob=new SerialBlob(arr);
			blob=con.createBlob();
			blob.setBytes(1, arr);

			String sql="insert into f_profile"+"(image,f_id)"+"values(?,?)";
			
			
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setBlob(1, blob);
			pst.setInt(2,id);
			int rows=pst.executeUpdate();
			if(rows>0)
			{
				
				return true;
			}
			else
			{
			
				return false;
			}
		
	
	
	} 
	catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	catch (SerialException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	return false;
}








}
	






