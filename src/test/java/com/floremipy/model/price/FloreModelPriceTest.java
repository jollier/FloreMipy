package com.floremipy.model.price;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Price;
import com.floremipy.model.Version;
import com.floremipy.model.price.dao.IPriceDao;
import com.floremipy.model.price.dao.PriceDao;
import com.floremipy.model.price.dto.PriceDto;

public class FloreModelPriceTest {


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
	public void testCreatePriceForArticleId() {
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		int idArticle = 1;
		
		IPriceDao priceDao = new PriceDao();
		int listSizeAvant =  priceDao.findPriceByArticleId(idArticle).size();
		PriceDto priceDto = new PriceDto();
		
		priceDto.setDate(date);
		priceDto.setValue(new BigDecimal("999999"));
		PriceDto newPriceDto = priceDao.createPriceForArticleId(priceDto, idArticle);
		int listSizeApres =  priceDao.findPriceByArticleId(idArticle).size();
		System.out.println("result test testCreatePriceForArticleId : " +newPriceDto.toString());
		assertTrue(listSizeApres == listSizeAvant + 1);
	}
	
	@Test
	public void testFindPriceByArticleId() {
		int articleId = 2;
		IPriceDao modelDao = new PriceDao();
		List<PriceDto> resultPrices = modelDao.findPriceByArticleId(articleId);
		for(PriceDto a : resultPrices){
			System.out.println("result test FindPriceByArticleId : " +a);
		}
		assertTrue(resultPrices.size() > 0);
	}
	
	@Test
	public void testFindPriceById() {
		int idPrice = 2;
		IPriceDao priceDao = new PriceDao();
		PriceDto priceDto = priceDao.findPriceById(idPrice);
		assertEquals(priceDto.getId(), idPrice);
	}
	
	@Test
	public void testUpdatePrice() {
		
		IPriceDao priceDao = new PriceDao();
		int idArticle = 1;
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		PriceDto priceDto = new PriceDto();
		priceDto.setDate(date);
		priceDto.setValue(new BigDecimal(0));
		PriceDto newPriceDto = priceDao.createPriceForArticleId(priceDto, idArticle);
		
		DecimalFormat df = new DecimalFormat("#.00"); 
		BigDecimal value = new BigDecimal(999);
		newPriceDto.setValue(value);
		priceDao.updatePrice(newPriceDto);
		
		System.out.println("result test testUpdatePrice : " +newPriceDto.toString());
		List<PriceDto> verifyPriceDto = priceDao.findPriceByArticleId(idArticle);
		assertEquals(df.format(verifyPriceDto.get(verifyPriceDto.size()-1).getValue()), df.format(value));
	}
	@Test
	public void testDeletePrice() {
		IPriceDao priceDao = new PriceDao();
		int idArticle = 1;
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		PriceDto priceDto = new PriceDto();
		priceDto.setDate(date);
		priceDto.setValue(new BigDecimal(9876543.21));
		PriceDto newPriceDto = priceDao.createPriceForArticleId(priceDto, idArticle);
		int priceId = newPriceDto.getId();
		priceDao.deletePrice(newPriceDto);
		Price verifyPrice = em.find(Price.class, priceId);
		assertNull(verifyPrice);
	}
	
}
