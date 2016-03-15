package com.floremipy.model.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Adress;
import com.floremipy.model.Version;
import com.floremipy.model.customer.dao.IModelCustomerDao;
import com.floremipy.model.customer.dao.ModelCustomerDao;
import com.floremipy.model.customer.dto.CustomerDto;


public class FloreModelCustomerTest {

	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction transaction;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		Map<String, Object> propertiesMap = emf.getProperties();
		int versionBaseUser = Integer.parseInt(propertiesMap.get("database.version").toString());
		Version version = em.find(Version.class, 1);

		if (version.getVersion() != versionBaseUser) {
			System.out.println("");
			System.out.println("");
			System.out.println("********************************");
			System.out.println("**Version de la BDD floremipi incorrecte**");
			System.out.println("********************************");
			System.out.println("Veuillez l'importer depuis sql/FloreMipi.sql");

			System.exit(1);
		}

	}

	/*
       @Test
       public void testNameLastCustomer() {
             ModelCustomerDao modelCustomerDao = new ModelCustomerDao();
             String name;
             name = modelCustomerDao.FindNameLastCustomer();
             System.out.println("Nom : " + name);
             assertEquals(name,"Test");
       }
	 */

	@Test
	public void testCustomerDaoSave() {
		ModelCustomerDao modelCustomerDao = new ModelCustomerDao();
		Adress adress = new Adress();
		adress.setCity("Toulouse");
		adress.setLocation("rue du village");
		adress.setLocation("Toulouse");
		adress.setZipCode("31000");
		CustomerDto customerDto = new CustomerDto (0,"test.teste@mail.com","Teste","Test","(555)555-5555",adress);
		modelCustomerDao.CustomerDaoSave(customerDto);                        
	}


	@Test
	public void findAllCustomers(){
		IModelCustomerDao modelDao = new ModelCustomerDao();
		List<CustomerDto> result = modelDao.findAllCustomers();
		for(CustomerDto c : result){
			System.out.println("result test findAllCustomers "+ c);
		}
		assertTrue(result.size() > 0);    
	}

	@Test

	public void testFindArticleById() {
		int id = 1;
		IModelCustomerDao modelDao = new ModelCustomerDao();
		CustomerDto result = modelDao.findCustomerById(id);
		System.out.println("result test findCustomerById : " +result.toString());
		assertEquals(id,result.getId());

	}



	@AfterClass
	public static void setUpAfterClass() throws Exception {
		em.close();
		emf.close();

	}


}

