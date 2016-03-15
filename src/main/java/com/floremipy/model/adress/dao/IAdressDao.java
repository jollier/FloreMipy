package com.floremipy.model.adress.dao;

import java.util.List;

import com.floremipy.model.adress.dto.AdressDto;

public interface IAdressDao {

	List<AdressDto> findAll();
	
	AdressDto findAdressById(int id);

	AdressDto createAdress(AdressDto adressDto);
	
	void updateAdress(AdressDto adressDto);

}