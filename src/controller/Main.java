package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import bussinessLogic.RegistrationValidation;
import dao.CustomerDAO;
import dao.StoreDAO;
import dao.SupplierDAO;
import dao.UserDAO;

public class Main {
	public static void main(String[] args) throws Exception {
		int choice ,supplierId;
		String username,password,confirmPassword,name,email;
		int quantity;
		boolean validate = false;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		//begin the process 
		System.out.println("Welcome To Smart Inventory Management System!");
		System.out.println("1.Admin");
		System.out.println("2.SignUp");
		System.out.println("3.Login");
		//take choice from the console
		choice = Integer.parseInt(br.readLine());
		
		//cretae objects for dao classes
		UserDAO userdao = new UserDAO();
		StoreDAO storedao = new StoreDAO();
		SupplierDAO supplierdao = new SupplierDAO();
		CustomerDAO customerdao = new CustomerDAO();
		
		//perform operations based the user choice
		switch(choice){
		case 1: do{
				System.out.println("Enter Username: ");
				username = br.readLine();
				System.out.println("Enter Password: ");
				password = br.readLine();
				//check the crededtials of admin 
				if(userdao.checkAdminCredentials(username, password)) {
					validate = true;
					System.out.println("Successfully Logged in as Admin");
					String adminDecision;
					do {
						System.out.println("1.Add products to store");
						System.out.println("2.Remove suppliers");
						System.out.println("3.View all products in store");
						System.out.println("4.View all customer purchases");
						
						//take the admin choice to perform some operation
						int adminChoice = Integer.parseInt(br.readLine());
						switch(adminChoice) {
							case 1:
								System.out.println("Products From Suppliers :");
								supplierdao.displayProductsFromSuppliers();
								System.out.println("Give supplier Id to add :");
								supplierId = Integer.parseInt(br.readLine());
								System.out.println("How many items you want to add :");
								quantity = Integer.parseInt(br.readLine());
								storedao.addProductsToStore(supplierId,quantity);
								break;
							case 2:
								System.out.println("To Remove suppliers enter the supplierId");
								supplierdao.displayProductsFromSuppliers();
								//take supplier id as input to remove suppliers
								System.out.println("Give supplier Id to remove :");
								supplierId = Integer.parseInt(br.readLine());
								supplierdao.removeSupplier(supplierId);
								System.out.println("Successully removed supplier");
								break;
							case 3:
								System.out.println("Products In store :");
								storedao.displayProductsInStore();
								break;	
							case 4:
								System.out.println("All customer purchases");
								storedao.displayCustomerPurchases();
								break;
							default:
								System.out.println("Invalid Input");
						}
						
						System.out.println("Do you want to continue : yes/no");
						adminDecision=br.readLine();		
					}while(adminDecision.equals("yes"));
				}
				else
					System.out.println("Invalid username/password");
				}while(!validate);
				break;
				
		case 2: //Signup user
				do{
					System.out.println("Enter your name: ");
					name = br.readLine();
					System.out.println("Enter Password: ");
					password = br.readLine();
					System.out.println("Confirm password: ");
					confirmPassword = br.readLine();
					System.out.println("Enter your email: ");
					email = br.readLine();
					RegistrationValidation regVal = new RegistrationValidation();
					
					if(regVal.checkUserDetails(name,password, confirmPassword,email)) {
						validate = true;
						userdao.addUserDetails(name, password,confirmPassword, email);
						System.out.println("Successufully registered");
					}
					else
						System.out.println("Invalid Data!");
				}while(!validate);
				
		case 3: //Login user
				do{
					System.out.println("Enter email :");
					email = br.readLine(); 
					System.out.println("Enter password :");
					password = br.readLine();
					if(userdao.checkUserCredentials(email, password)) {
						validate = true;
						System.out.println("Successfully logged in!");
						storedao.displayProductsInStore();
						String userDecision;
						do {
							System.out.println("Enter product Id to buy that product");
							int productId = Integer.parseInt(br.readLine());
							System.out.println("How much quantity you want to buy");
							quantity = Integer.parseInt(br.readLine());
							customerdao.temp(email, productId, quantity);
							customerdao.displayCustomerPurchases(email);
							System.out.println("Do you want to buy one more product : yes/no");
							userDecision=br.readLine();		
						}while(userDecision.equals("yes"));
					}
					
					else
						System.out.println("Invalid username/password");
				}while(!validate);
				break;
		}
	}

}
