package com.floremipy.model.customer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.floremipy.model.Adress;
import com.floremipy.model.Customer;
import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.service.ICustomerService;
import com.floremipy.user.dto.UserDto;
import com.floremipy.user.service.IUserService;


@Controller
public class ProfilController {

	Profil data = new Profil();
	boolean isNew = true;
	
	Adress adress = null;
	CustomerDto cust = null;
		
	@Autowired ICustomerService customerService;
	
	@Autowired IUserService userService;

	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public ModelAndView profilGet(Model model,HttpServletRequest request){
		Profil profil=data;
		profil.setBUpdate(false);
		
		/*
		 * test si session active 
		 * Si oui: recupe des informations de l'utilisateur connecté
		 */
        HttpSession session = request.getSession(true);
              
		String login = (String) session.getAttribute("Email"); 
		String pwd = (String) session.getAttribute("Password"); 
		
        if ((session.getAttribute("id") != null) && (login!=null) && (pwd!=null)) {
			// session active
		    cust = customerService.getCustomerByLoginAndPassword(login, pwd);
		    
		    if (cust!=null) {
		    	isNew = false;
		    	
		    	profil.setFirstName(cust.getFirstname());
		    	profil.setName(cust.getName());
		    	profil.setEmail(cust.getEmail());
		    	profil.setTel1(cust.getPhone());
		    	profil.setTel1(cust.getPhone());
		    	
		    	// Adress
		    	adress = cust.getAdress();
		    	
		    	profil.setCity(adress.getCity());
		    	profil.setCP(adress.getZipCode());
		    	profil.setAdresse(adress.getLocation());
		    	
		    	
		    	UserDto userDto =userService.getUserByName(login);
		    	if (userDto != null) {
		    		profil.setlogin(userDto.getUsername());
		    		profil.setPassword(userDto.getPassword());
		    		profil.setBUpdate(true);
		    	}
		    }
        } /*else {
		    cust = customerService.getCustomerByLoginAndPassword("user1","user1");
		    
		    	profil.setFirstName(cust.getFirstname());
		    	profil.setName(cust.getName());
		    	profil.setEmail(cust.getEmail());
		    	profil.setTel1(cust.getPhone());
		    	profil.setTel1(cust.getPhone());
		    	
		    	// Adress
		    	adress = cust.getAdress();
		    	
		    	profil.setCity(adress.getCity());
		    	profil.setCP(adress.getZipCode());
		    	profil.setAdresse(adress.getLocation());
		    	
        }*/
		
		model.addAttribute("profil", profil);
		return new ModelAndView("profil");
		
	}

	@RequestMapping(value = "/profil", method = RequestMethod.POST)
	public ModelAndView profilPOST(@ModelAttribute("profil") Profil profil, Model model){
		boolean bUdate = false;
		
		/*
		 *- crétaion d'un objet profil  (cf la clase à la fin de cette page).
		 * - passage de cet objet à une variable de profil.jsp appellée profil: @ModelAttribute("profil")
		 * - mapping automatique de SPRING avec les valeurs de l'objet
		 * 
		 */

				
		// *********************************************************
		// *** Controle que les saisies n'existent pas déjà      ***
		//**********************************************************
		
		//Verification que l'email n'existe pas déjà dans un customer
		CustomerDto newCustomer = null;
		newCustomer = customerService.getCustomerByEmail(profil.getEmail());
		
		if (!profil.getBUpdate()) {
			if (newCustomer != null) {
				model.addAttribute("message", "Compte déjà existant avec cet email !");
		    	return new ModelAndView("profil");
			}
		}
		
		//Verification que le name n'existe pas déjà dans un user
		UserDto newUserDto = null;
		newUserDto = userService.getUserByName(profil.getLogin());
		if (!profil.getBUpdate()) {
			if (newUserDto != null) {
				model.addAttribute("message", "Compte déjà existant pour ce user !");
		    	return new ModelAndView("profil");
			}
		}
			
		// *********************************************************
		// ***           Passage à l'enregistrement              ***
		// *********************************************************
		newCustomer = new CustomerDto();
		
		newCustomer.setEmail(profil.getEmail());
		newCustomer.setFirstname(profil.getFirstName());
		newCustomer.setName(profil.getName());
		newCustomer.setPhone(profil.getTel1());
		
		Adress adress = new Adress();
		adress.setLocation(profil.getAdresse());
		adress.setZipCode(profil.getCP());
		adress.setCity(profil.getCity());

		newCustomer.setAdress(adress);

		newUserDto = new UserDto();
		
		newUserDto.setUsername(profil.getLogin());
		newUserDto.setPassword(profil.getPassword());
		newUserDto.setUsertype("user");
		
		String message="";
		try {
			
			message = customerService.save(newCustomer, newUserDto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!message.equals("")) {
			model.addAttribute("message", message);
			return new ModelAndView("/profil");
		}
		return new ModelAndView("/accueil");
		
	}


}

class Profil {
	private String radios;
	private String nomEntreprise;
	private String raisonSociale;
	private String SIRET;
	private String juridique;
	private String name;
	private String firstName;
	private String adresse;
	private String CP;
	private String city;
	private String country;
	private String tel1;
	private String tel2;
	private String email;
	private String TVA;
	private String password;
	private String login;
	private boolean bUpdate = false;


	public Profil(String iRadios, String nomEntreprise, String raisonSociale,
			String sIRET, String iJuridique, String name, String firstName, String adresse, String cP, String city,
			String country, String tel1, String tel2, String email, String tVA, String password, String login,boolean bUpdate) {
		this.radios = iRadios;
		this.nomEntreprise = nomEntreprise;
		this.raisonSociale = raisonSociale;
		this.SIRET = sIRET;
		this.juridique = iJuridique;
		this.name = name;
		this.firstName = firstName;
		this.adresse = adresse;
		this.CP = cP;
		this.city = city;
		this.country = country;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email = email;
		this.TVA = tVA;
		this.login = login;
		this.password = password;
		this.bUpdate = bUpdate;

	}
	
	
	
	 public Profil(){
		super(); 
	 }
	public String getRadios() {
		return radios;
	}

	public void setRadios(String iRadios) {
		this.radios = iRadios;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getSIRET() {
		return SIRET;
	}

	public void setSIRET(String sIRET) {
		SIRET = sIRET;
	}

	public String getJuridique() {
		return juridique;
	}

	public void setJuridique(String  iJuridique) {
		this.juridique = iJuridique;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTVA() {
		return TVA;
	}

	public void setTVA(String tVA) {
		TVA = tVA;
	}
	
	public String getLogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getBUpdate() {
		return bUpdate;
	}
	
	public void setBUpdate(boolean bUpdate) {
		this.bUpdate = bUpdate;
	}

}
