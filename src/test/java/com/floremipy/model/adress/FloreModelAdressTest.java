package com.floremipy.model.adress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Version;
import com.floremipy.model.adress.dao.AdressDao;
import com.floremipy.model.adress.dao.IAdressDao;
import com.floremipy.model.adress.dto.AdressDto;
import com.floremipy.model.article.dao.ArticleDao;
import com.floremipy.model.article.dao.IArticleDao;
import com.floremipy.model.article.dto.ArticleDto;

public class FloreModelAdressTest {
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
	
	@Test
	public void testFindAllAdresses() {
		IAdressDao modelDao = new AdressDao();
		List<AdressDto> resultAdress = modelDao.findAll();
		for(AdressDto a : resultAdress){
			System.out.println("result test FindAllAdresses : " +a);
		}	
		assertTrue(resultAdress.size() > 0);
		
	}
	
	@Test
	public void testFindAdressById() {
		int id = 2;
		IAdressDao modelDao = new AdressDao();
		AdressDto resultAdress = modelDao.findAdressById(id);
		System.out.println("result test FindAdressById : " +resultAdress.toString());
		assertEquals(id,resultAdress.getId());
	}
	
	@Test
	public void testCreateAdress() {
		IAdressDao modelDao = new AdressDao();
		AdressDto adressDto = new AdressDto();
		adressDto.setCity("City_Test");
		adressDto.setLocation("Location_TEST");
		adressDto.setZipCode("ZipCode_Test");
		adressDto = modelDao.createAdress(adressDto);
		System.out.println("result test CreateAdress : " +adressDto.toString());
		assertNotNull(adressDto.getId());
	}
	
	
	@Test
	public void testUpdateAdress() {
		LocalDateTime localDateTime = LocalDateTime.now();
		String city = "City_UpdateTest";
		
		IAdressDao modelDao = new AdressDao();
		AdressDto adressDto = new AdressDto();
		adressDto.setCity(city);
		adressDto.setLocation("Location_TEST");
		adressDto.setZipCode("ZipCode_Test");
		adressDto = modelDao.createAdress(adressDto);
		
		city = city + localDateTime.toString();
		adressDto.setCity(city);
		modelDao.updateAdress(adressDto);
		
		AdressDto verifyAdress = modelDao.findAdressById(adressDto.getId());
		System.out.println("result test UpdateAdress : " +verifyAdress.toString());
		assertEquals(verifyAdress.getCity(),city);
		
	}
	
}
