package com.floremipy.model;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

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
		int versionBaseUser = 5;
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em =  emf.createEntityManager();
		Version version = em.find(Version.class, 1);

		if (version.getVersion() != versionBaseUser) {
			System.out.println("");
			System.out.println("");
			System.out.println("********************************");
			System.out.println("**Version de la BDD floremipi incorrecte**");
			System.out.println("********************************");
			System.out.println("Veuillez l'importer depuis srv-dev/PARTAGES/FloreMipy-2016-02-29/FloreMipy/FloreMipiInit.sql");

			System.exit(1);
		}

	}

	@Test
	public void testFindPriceByArticleId() {
		int articleId = 1;
		IPriceDao modelDao = new PriceDao();
		List<PriceDto> resultPrices = modelDao.findPriceByArticleId(articleId);
		for(PriceDto a : resultPrices){
			System.out.println("result test FindPriceByArticleId : " +a);
		}
		assertTrue(resultPrices.size() > 0);

	}


}
