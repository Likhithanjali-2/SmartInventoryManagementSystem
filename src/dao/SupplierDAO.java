package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import service.SupplierDaoInterface;
import utility.ConnectionManager;

public class SupplierDAO implements SupplierDaoInterface {

	public void displayProductsFromSuppliers() throws Exception {
		Connection con=ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement("select * from supplierproducts");
		ResultSet rs = pstmt.executeQuery();
		System.out.printf("ID             Category         ProductName           Quantity        Price %n");
		System.out.println("__________________________________________________________________________________");
		while(rs.next()) {
			System.out.printf("%-6d %15s %20s %15d %15d %n",rs.getInt("id"),rs.getString("category"),rs.getString("productname"),rs.getInt("quantity"),rs.getInt("price"));
		}
		System.out.println("__________________________________________________________________________________");
	}

	public void removeSupplier(int supplierId) throws Exception {
		Connection con=ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from supplierproducts where id="+supplierId);
		pstmt.executeUpdate();
	}
}
