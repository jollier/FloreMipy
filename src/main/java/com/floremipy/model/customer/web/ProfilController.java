package com.floremipy.model.customer.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProfilController {

	Profil data = new Profil("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");


	@RequestMapping(value = "/profil", method = RequestMethod.GET)
	public String profilGet(Model model){
		Profil profil=data;
		model.addAttribute("profil", profil);
		
		model.addAttribute("optParticulier",data.getOptParticulier());
		model.addAttribute("optEntreprise",data.getOptEntreprise());
		model.addAttribute("nomEntreprise",data.getNomEntreprise());
		model.addAttribute("raisonSociale",data.getRaisonSociale());
		model.addAttribute("SIRET",data.getSIRET());
		model.addAttribute("iJuridique",data.getiJuridique());
		model.addAttribute("TVA",data.getTVA());
		model.addAttribute("name",data.getOptEntreprise());
		model.addAttribute("optEntreprise",data.getName());
		model.addAttribute("firstName",data.getFirstName());
		model.addAttribute("adresse",data.getAdresse());
		model.addAttribute("CP",data.getCP());
		model.addAttribute("city",data.getCity());
		model.addAttribute("country",data.getCountry());
		model.addAttribute("tel1",data.getTel1());
		model.addAttribute("tel2",data.getTel2());
		model.addAttribute("email",data.getEmail());
		
		return "profil";
		
	}

	@RequestMapping(value = "/profil", method = RequestMethod.POST)
	public String profilPOST(@ModelAttribute("profil") Profil profil, Model model){
		
//		model.addAttribute("optParticulier",data.getOptParticulier());
//		model.addAttribute("optEntreprise",data.getOptEntreprise());
//		model.addAttribute("nomEntreprise",data.getNomEntreprise());
//		model.addAttribute("raisonSociale",data.getRaisonSociale());
//		model.addAttribute("SIRET",data.getSIRET());
//		model.addAttribute("iJuridique",data.getiJuridique());
//		model.addAttribute("TVA",data.getTVA());
//		model.addAttribute("name",data.getOptEntreprise());
//		model.addAttribute("optEntreprise",data.getName());
//		model.addAttribute("firstName",data.getFirstName());
//		model.addAttribute("adresse",data.getAdresse());
//		model.addAttribute("CP",data.getCP());
//		model.addAttribute("city",data.getCity());
//		model.addAttribute("country",data.getCountry());
//		model.addAttribute("tel1",data.getTel1());
//		model.addAttribute("tel2",data.getTel2());
//		model.addAttribute("email",data.getEmail());
		
		
				
		return "profil";
		
	}


}

class Profil {
	private String optParticulier;
	private String optEntreprise;
	private String nomEntreprise;
	private String raisonSociale;
	private String SIRET;
	private String iJuridique;
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

	public Profil(String optParticulier, String optEntreprise, String nomEntreprise, String raisonSociale,
			String sIRET, String iJuridique, String name, String firstName, String adresse, String cP, String city,
			String country, String tel1, String tel2, String email, String tVA) {
		this.optParticulier = optParticulier;
		this.optEntreprise = optEntreprise;
		this.nomEntreprise = nomEntreprise;
		this.raisonSociale = raisonSociale;
		SIRET = sIRET;
		this.iJuridique = iJuridique;
		this.name = name;
		this.firstName = firstName;
		this.adresse = adresse;
		CP = cP;
		this.city = city;
		this.country = country;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email = email;
		TVA = tVA;
	}

	public String getOptParticulier() {
		return optParticulier;
	}

	public void setOptParticulier(String optParticulier) {
		this.optParticulier = optParticulier;
	}

	public String getOptEntreprise() {
		return optEntreprise;
	}

	public void setOptEntreprise(String optEntreprise) {
		this.optEntreprise = optEntreprise;
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

	public String getiJuridique() {
		return iJuridique;
	}

	public void setiJuridique(String iJuridique) {
		this.iJuridique = iJuridique;
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
}
