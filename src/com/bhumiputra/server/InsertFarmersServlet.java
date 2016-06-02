package com.bhumiputra.server;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import sun.misc.BASE64Decoder;

import com.google.gson.Gson;

import dao.DBConnection;
import dao.DataBaseManager;
import dto.Farmer;




@WebServlet("/FarmerRegisterServlet")
public class InsertFarmersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InsertFarmersServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In do get");
		doPost(request, response);
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int id=0;
			PrintWriter writer=response.getWriter();
			Gson g=new Gson();
			String image=request.getParameter("image"); 
			Farmer farmer=g.fromJson(request.getParameter("json"),Farmer.class);
			System.out.println(farmer.toString());
			Boolean flag=DataBaseManager.insertfarmer(farmer); 
			if(flag)
			{
				System.out.println(farmer.getMobileno());
				id=DataBaseManager.getMaxFarmerId(farmer.getMobileno());
				if(id!=0)
				{
					DataBaseManager.addImageToDb(image, id);
				}
				
			}
			
			System.out.println(id);
			
	writer.write(id);
	}
	

}


