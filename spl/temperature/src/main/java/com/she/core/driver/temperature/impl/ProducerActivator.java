package com.she.core.driver.temperature.impl;

import com.she.core.driver.temperature.DriverMqtt;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ProducerActivator implements BundleActivator {

    DriverMqtt driver;

    public void start(BundleContext bundleContext) throws Exception {
  
    	driver = new DriverMqtt.DriverMqttBuilder().topicListener("dev/TemperatureSensor").build("Temperature");
    	
    }

    public void stop(BundleContext bundleContext) throws Exception {
        driver.disconnect();
    }

}

