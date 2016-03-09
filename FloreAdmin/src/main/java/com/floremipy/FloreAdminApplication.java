package com.floremipy;


import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.floremipy.controller.FloreMipyController;

@Component
public class FloreAdminApplication {

	@Autowired
	FloreMipyController floreMipyController;
	
	/**
	 * Methode main ou commence le flux de l'application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Demarre le contexte de Spring
        ApplicationContext context = 
		new ClassPathXmlApplicationContext("applicationContext.xml",
				FloreAdminApplication.class);
		
        FloreAdminApplication p = context.getBean(FloreAdminApplication.class);
        p.start(args);
		
		//FloreMipyController f = new FloreMipyController();
		//floreMipyController.launch();

		//		JFrame f=new JFrame();
//		f.show();
		
		System.out.println("Démarre");
	}
	
	private void start(String[] args) {
		floreMipyController.launch();
    }
	



    
}
