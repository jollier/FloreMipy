package com.floremipy.model.articleinprogress;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.floremipy.model.Version;
import com.floremipy.model.articleinprogress.dao.ArticleInProgressDao;
import com.floremipy.model.articleinprogress.dao.IArticleInProgressDao;
import com.floremipy.model.articleinprogress.dto.ArticleInProgressDto;

public class FloreModelArticleinprogressTest {

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
	public void testCreateArticleInProgressForArticleId() {
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		int idArticle = 1;
		IArticleInProgressDao articleInProgressDao = new ArticleInProgressDao();
		ArticleInProgressDto articleinprogressDto = new ArticleInProgressDto();
		articleinprogressDto.setQuantity(1000);
		articleinprogressDto.setStartDate(date);
		articleinprogressDto.setReleaseDate(date);
		ArticleInProgressDto verifyArticle = articleInProgressDao.createArticleInProgressForArticleId(articleinprogressDto, idArticle);
		System.out.println("result test CreateArticleInProgressForArticleId : " +verifyArticle.toString());
		assertTrue(verifyArticle.getId() > 0);
	}

	@Test
	public void testFindArticleInProgressByArticleId() {
		int idArticle = 1;
		IArticleInProgressDao articleInProgressDao = new ArticleInProgressDao();
		ArticleInProgressDto articleInProgressDto = articleInProgressDao.findArticleInProgressById(idArticle);
		System.out.println("result test CreateArticleInProgressForArticleId : " +articleInProgressDto.toString());
		assertEquals(articleInProgressDto.getIdArticle(), idArticle);
	}

	@Test
	public void testFindArticleInProgressById() {
		int id = 1;
		IArticleInProgressDao articleInProgressDao = new ArticleInProgressDao();
		ArticleInProgressDto articleInProgressDto = articleInProgressDao.findArticleInProgressById(id);
		System.out.println("result test CreateArticleInProgressForArticleId : " +articleInProgressDto.toString());
		assertEquals(articleInProgressDto.getId(), id);
	}

	@Test
	public void testUpdateArticleInProgress() {
		int id = 1;
		IArticleInProgressDao articleInProgressDao = new ArticleInProgressDao();
		ArticleInProgressDto articleInProgressDto = articleInProgressDao.findArticleInProgressById(id);
		int quantity = articleInProgressDto.getQuantity()+10;
		articleInProgressDto.setQuantity(quantity);
		articleInProgressDao.updateArticleInProgress(articleInProgressDto);
		System.out.println("result test UpdateArticleInProgress : " +articleInProgressDto.toString());
		assertEquals(articleInProgressDto.getQuantity(), quantity);
	}

	@Test
	public void testDeleteArticleInProgress() {
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		int idArticle = 1;
		IArticleInProgressDao articleInProgressDao = new ArticleInProgressDao();
		ArticleInProgressDto articleinprogressDto = new ArticleInProgressDto();
		articleinprogressDto.setQuantity(1000);
		articleinprogressDto.setStartDate(date);
		articleinprogressDto.setReleaseDate(date);
		ArticleInProgressDto verifyArticle = articleInProgressDao.createArticleInProgressForArticleId(articleinprogressDto, idArticle);
		articleInProgressDao.deleteArticleInProgress(verifyArticle);
		System.out.println("result test DeleteArticleInProgress : " +verifyArticle.toString());
		assertNull(articleInProgressDao.findArticleInProgressById(verifyArticle.getId()));
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		em.close();
		emf.close();
	}
}
