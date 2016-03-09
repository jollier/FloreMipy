package com.floremipy.service;

import java.util.ArrayList;
import java.util.List;

import com.floremipy.model.Article;

public class AccueilService {

	private static List<Article> articleList;
	
	static {
		Article art1 = new Article();
		art1.setName("Arbuste 1");
		art1.setDescription("Description de l'arbuste 1");
		art1.setImgsrc("img/Arbuste persistant 1.jpg");
		Article art2 = new Article();
		art2.setName("Arbuste 2");
		art2.setDescription("Description de l'arbuste 2");
		art2.setImgsrc("img/Arbuste persistant 2.jpg");
		Article art3 = new Article();
		art3.setName("Arbuste 3");
		art3.setDescription("Description de l'arbuste 3");
		art3.setImgsrc("img/Arbuste persistant 3.jpg");
		Article art4 = new Article();
		art4.setName("Arbuste 4");
		art4.setDescription("Description de l'arbuste 4");
		art4.setImgsrc("img/Arbuste couvre-sol 1.jpg");
		Article art5 = new Article();
		art5.setName("Arbuste 5");
		art5.setDescription("Description de l'arbuste 5");
		art5.setImgsrc("img/Arbuste couvre-sol 2.jpg");
		Article art6 = new Article();
		art6.setName("Arbuste 6");
		art6.setDescription("Description de l'arbuste 6");
		art6.setImgsrc("img/Bambou1.jpg");
		
		articleList = new ArrayList<Article>();
		articleList.add(art1);
		articleList.add(art2);
		articleList.add(art3);
		articleList.add(art4);
		articleList.add(art5);
		articleList.add(art6);
	}

	public List<Article> findAllDto() {
		return articleList;
	}
}
