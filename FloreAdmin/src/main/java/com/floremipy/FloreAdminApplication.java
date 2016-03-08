package com.floremipy;


import javax.swing.JFrame;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.floremipy.controller.FloreMipyController;

public class FloreAdminApplication {

	/**
	 * Methode main ou commence le flux de l'application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Demarre le contexte de Spring
		new ClassPathXmlApplicationContext("applicationContext.xml",
				FloreAdminApplication.class);
		
		
		FloreMipyController f = new FloreMipyController();

		//		JFrame f=new JFrame();
//		f.show();
		
		System.out.println("Démarre");
	}
}
