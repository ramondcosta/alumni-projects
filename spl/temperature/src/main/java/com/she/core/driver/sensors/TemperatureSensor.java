package com.she.core.driver.sensors;

import org.json.JSONObject;

public class TemperatureSensor extends Sensor {

	public TemperatureSensor(String name, String type) {
		super(name, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String transformation(String value) {
		// TODO Auto-generated method stub
		
		
		return value.toString();
	}

}
