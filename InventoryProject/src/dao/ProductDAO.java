package dao;

import java.sql.*;
import connectionManager.ConnectionManager;

import model.Product;
public class ProductDAO {

	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		//java JDBC connect
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection();
		
		String sql_query ="insert into product(productId,productName,minsellQuantity,price,quantity) values(?,?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql_query);
		ps.setInt(1, product.getProductId());
		ps.setString(2,product.getProductName());
		ps.setInt(3,product.getMinsellQuantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5, product.getQuantity());
		
		
		ps.executeUpdate();
		
		conm.closeConnection();
		
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection();
		
		//Statement class declare
				Statement st=con.createStatement();
				
		//ResultSet class
				ResultSet rt=st.executeQuery("select * from product");
				
				while(rt.next())
				{
				System.out.println(rt.getInt("productId")+"|"+rt.getString("productName")+"|"+rt.getInt("MinsellQuantity")+"|"+rt.getInt("price")+"|"+rt.getInt("quantity"));	
				}
				conm.closeConnection();
	}
}
