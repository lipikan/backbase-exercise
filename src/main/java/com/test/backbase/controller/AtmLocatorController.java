package com.test.backbase.controller;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.backbase.entity.City;
import com.test.backbase.service.AtmLocatorService;

@RestController
@RequestMapping("/atmLocator")
public class AtmLocatorController {
	
	private AtmLocatorService service;

	@RequestMapping(method = RequestMethod.GET)
	public City getAtmLocationsByCity(@RequestParam(value = "city") String city) {
		SecurityContext context = SecurityContextHolder.getContext();
		System.out.println("User Name: " + context.getAuthentication().getName());
		service = new AtmLocatorService();
		try {
			return service.getAtmsByCity(city);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
