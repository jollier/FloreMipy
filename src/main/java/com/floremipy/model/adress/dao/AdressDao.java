package com.floremipy.model.adress.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.floremipy.model.Adress;
import com.floremipy.model.Article;
import com.floremipy.model.adress.dto.AdressDto;

@Component
public class AdressDao implements IAdressDao {
	/**
	 * 
	 */
	private final static String PERSISTENCE_UNIT_NAME = "FloreMipyWeb";
	private static EntityManagerFactory emf;	
	private static EntityManager em;	

	public AdressDao(){
//		super();
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<AdressDto> findAll() {
		String requete = 
				"SELECT NEW com.floremipy.model.adress.dto.AdressDto(" + 
						"a.id, a.city, a.location, a.zipCode) " +
						"FROM Adress a ORDER BY a.city" ;
		Query query = null;
		query = em.createQuery(requete, AdressDto.class);
		List<AdressDto> result = null;
		try {
			result = (List<AdressDto>)query.getResultList(); 
		} catch (Exception e) {
			// TODO: handle exception
			result = null;
		}
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.adress.dao.IAdressDao#findAdressById(int)
	 */
	@Override
	public AdressDto findAdressById(int id) {
		em.getTransaction().begin();
		Adress adress = em.find(Adress.class, id);
		AdressDto adressDto = new AdressDto();
		adressDto.setCity(adress.getCity());
		adressDto.setId(adress.getId());
		adressDto.setLocation(adress.getLocation());
		adressDto.setZipCode(adress.getZipCode());
		return adressDto;
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.adress.dao.IAdressDao#createAdress(com.floremipy.model.adress.dto.AdressDto)
	 */
	@Override
	public AdressDto createAdress(AdressDto adressDto) {
		em.getTransaction().begin();
		Adress adress = new Adress();
		adress.setCity(adressDto.getCity());
		adress.setLocation(adressDto.getLocation());
		adress.setZipCode(adressDto.getZipCode());
		em.persist(adress);
		em.getTransaction().commit();
		adressDto.setId(adress.getId());
		return adressDto;
	}
	
	/* (non-Javadoc)
	 * @see com.floremipy.model.adress.dao.IAdressDao#createAdress(com.floremipy.model.adress.dto.AdressDto)
	 */
	@Override
	public void updateAdress(AdressDto adressDto) {
		em.getTransaction().begin();
		Adress adress = em.find(Adress.class, adressDto.getId());
		adress.setCity(adressDto.getCity());
		adress.setLocation(adressDto.getLocation());
		adress.setZipCode(adressDto.getZipCode());
		em.getTransaction().commit();
	}
	
}
