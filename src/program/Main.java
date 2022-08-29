package program;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller find by id ===");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller find by department ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: seller find all ===");
		list = sellerDao.findAll();
		
		for(Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4: insert seller ===");
		Seller newSeller = new Seller(null,"greg","greg@gmail.com",new Date(),4000,department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! new id = " + newSeller.getId());
	}

}
