package com.test.backbase.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.backbase.dao.AtmLocatorDao;
import com.test.backbase.entity.AtmAddress;
import com.test.backbase.entity.AtmLocation;
import com.test.backbase.entity.Bank;
import com.test.backbase.entity.City;

public class AtmLocatorService {
	
	public City getAtmsByCity(String city) throws JsonParseException, JsonMappingException, IOException {
		City cityResponse = new City();
		AtmLocatorDao dao = new AtmLocatorDao();
		List<AtmLocation> atmLocations = dao.getLocationsByCity(city);
		cityResponse.setCityName(city);
		
		if(!atmLocations.isEmpty() && atmLocations.size() > 0) {
			List<Bank> banks = new ArrayList<>();
			Bank bank = new Bank();
			bank.setBankName(atmLocations.get(0).getType());
			List<AtmAddress> addressList = new ArrayList<>();
			for(AtmLocation atmLoc: atmLocations) {
				AtmAddress addr = new AtmAddress();
				addr.setGeoLocation(atmLoc.getAddress().getGeoLocation());
				addr.setHouseNumber(atmLoc.getAddress().getHousenumber());
				addr.setPostalCode(atmLoc.getAddress().getPostalcode());
				addr.setStreet(atmLoc.getAddress().getStreet());
				addressList.add(addr);
			}
			bank.setAtmAddress(addressList);
			banks.add(bank);
			cityResponse.setBanks(banks);
		}
		return cityResponse;
	}

}
