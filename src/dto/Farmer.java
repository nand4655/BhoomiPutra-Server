package dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Farmer implements Serializable
{
	int id;
	String name;
	long mobileno;
	Address addr=null;
	String password;
	FarmersAsset asset=null;
	double totalLand;
	ArrayList<Cattles> cattles=new ArrayList<Cattles>();
	public Farmer(String name,String pass, long mobileno2) {
		super();
	
		this.name = name;
		this.mobileno = mobileno2;
		password=pass;
		
	}
	
	public Farmer(int id, String name,long mobileno, Address addr,
			String password, FarmersAsset asset,ArrayList<Cattles> cattles) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.addr = addr;
		this.password = password;
		this.asset = asset;
		this.cattles=cattles;
	}

	
	public Farmer(int id1, String name2, long mobileno2, Address addr2,
			FarmersAsset asset2) {
		
		id=id1;
		name=name2;
		mobileno=mobileno2;
		addr=addr2;
		asset=asset2;
		
		// TODO Auto-generated constructor stub
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public double getTotalLand() {
		return totalLand;
	}

	public void setTotalLand(double totalLand) {
		this.totalLand = totalLand;
	}

	public ArrayList<Cattles> getCattles() {
		return cattles;
	}

	public void setCatles(ArrayList<Cattles> cattles) {
		this.cattles = cattles;
	}

	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long
			
			mobileno) {
		this.mobileno = mobileno;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public FarmersAsset getAsset() {
		return asset;
	}
	public void setAsset(FarmersAsset asset) {
		this.asset = asset;
	}
	
	public void setCattle(Cattles cattle)
	{
		this.cattles.add(cattle);
	}

	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", mobileno=" + mobileno
				+ ", addr=" + addr + ", password=" + password + ", asset="
				+ asset + ", cattles=" + cattles + "]";
	}
	
	

}
