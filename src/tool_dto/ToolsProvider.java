package tool_dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ToolsProvider implements Serializable
{
	int id;
	String name;
	long mobileno;
	ToolAddress addr;
	String password;
	
	ArrayList<Tools> tools=new ArrayList<Tools>();
	ArrayList<Manpower>manPowerCategory=new ArrayList<Manpower>();		
	public ToolsProvider(String name,String pass, long mobileno) {
		super();
	
		this.name = name;
		this.mobileno = mobileno;
		password=pass;
		
	}
	
	

	public ToolsProvider(int id, String name, long mobileno, ToolAddress addr,
			String password, ArrayList<Tools> tools,
			ArrayList<Manpower> manPowerCategory) {
		super();
		this.id = id;
		this.name = name;
		this.mobileno = mobileno;
		this.addr = addr;
		this.password = password;
		this.tools = tools;
		this.manPowerCategory = manPowerCategory;
	}



	public ToolsProvider(int id2, String name2, long mobileno2,
			ToolAddress taddr, String password2) {
		
		id=id2;
		name=name2;
		mobileno=mobileno2;
		addr=taddr;
		password=password2;
		
		
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
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public ToolAddress getAddr() {
		return addr;
	}
	public void setAddr(ToolAddress addr) {
		this.addr = addr;
	}

	
	public void setTools(Tools tool)
	{
		tools.add(tool);
	}
	public ArrayList<Tools> getTools()
	{
		return tools;
	}
	
	
	public void setManpowers(Manpower manpower)
	{
		manPowerCategory.add(manpower);
	}
	public ArrayList<Manpower> getManpowers()
	{
		
		return this.manPowerCategory;
	}



	@Override
	public String toString() {
		return "ToolsProvider [id=" + id + ", name=" + name + ", mobileno="
				+ mobileno + ", addr=" + addr + ", password=" + password
				+ ", tools=" + tools + ", manPowerCategory=" + manPowerCategory
				+ "]";
	}
}