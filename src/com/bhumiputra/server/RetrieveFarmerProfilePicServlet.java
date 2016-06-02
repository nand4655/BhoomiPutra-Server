package com.bhumiputra.server;


import java.awt.Graphics;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

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



/**
 * Servlet implementation class SearchServlet
 */
 @WebServlet("/getFarmerProfilePicServlet")
public class RetrieveFarmerProfilePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveFarmerProfilePicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
 
			
			
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*PrintWriter writer=response.getWriter();
		String id=request.getParameter("f_id");
		ArrayList<ImageRetrieve> imageArray=new ArrayList<ImageRetrieve>();
			
		System.out.println(""+id);
		
		String sql="select image from f_profile";
		PrintWriter pw=response.getWriter();
		Connection con=DBConnection.connect();
		PreparedStatement pst;
		byte[] imgbrr = null;
		ImageRetrieve imf=null;
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				imgbrr=rs.getBytes("image");
				String img=com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imgbrr);
				imf=new ImageRetrieve(img); 
				imageArray.add(imf);
				pw.println(imf);
				
			}
			Gson g=new Gson();
			String json=g.toJson(imageArray);
			pw.println(json);
			rs.close();
			pst.close();
			con.close();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

	
	*/
		
		String id=request.getParameter("f_id");
		
		System.out.println(""+id);
		String sql="select image from f_profile where f_id=?";
	
		
		
		
		ArrayList<Image2> listArray=new ArrayList<Image2>();
	
		PrintWriter pw=response.getWriter();
		Connection con=DBConnection.connect();
		PreparedStatement pst;
		byte[] imgbrr = null;
		Image2 imf = null;
		try {
			pst = con.prepareStatement(sql);
			
			
				
			
			pst.setInt(1, Integer.parseInt(id));
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				imgbrr=rs.getBytes("image");
				String img=com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imgbrr);
				imf=new Image2(img);
				listArray.add(imf);
			}
			rs.close();
			pst.close();
			con.close();
			Gson g=new Gson();
			String json=g.toJson(listArray);
			pw.println(json);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}		
	}}	
 

