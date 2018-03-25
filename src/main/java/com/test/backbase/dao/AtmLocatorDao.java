package com.test.backbase.dao;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.test.backbase.entity.AtmLocation;

public class AtmLocatorDao {
	
	private static final String URI_LOCATION = "https://www.ing.nl/api/locator/atms/";
	
	private String readData() throws IOException {
		URL obj = new URL(URI_LOCATION);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + URI_LOCATION);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			if(! ")]}',".equalsIgnoreCase(inputLine))
				response.append(inputLine);
		}
		in.close();

		return response.toString();
	}
	
	private List<AtmLocation> convertResponseToOjbect(String response) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		CollectionType javaType = mapper.getTypeFactory()
			      .constructCollectionType(List.class, AtmLocation.class);
		List<AtmLocation> atmLocations = mapper.readValue(response, javaType);
		return atmLocations;
	}
	
	public List<AtmLocation> getLocationsByCity(String city) throws JsonParseException, JsonMappingException, IOException {
		List<AtmLocation> atmLocations;
		String response = readData();
		List<AtmLocation> allLocations = convertResponseToOjbect(response);
		atmLocations = allLocations.stream().filter(x -> city.equals(x.getAddress().getCity())).collect(Collectors.toList());
		return atmLocations;
	}

	public static void main(String[] args) {
		AtmLocatorDao dao = new AtmLocatorDao();
		try {
			List<AtmLocation> locations = dao.getLocationsByCity("Amsterdam");
			System.out.println(locations.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
