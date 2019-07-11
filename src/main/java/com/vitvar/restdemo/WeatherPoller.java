/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitvar.restdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitvar.restdemo.model.Student;
import com.vitvar.restdemo.model.Weather;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janka
 */
public class WeatherPoller implements Runnable {

    private static final String OPENWEATHER_KEY="OPENWEATHER_KEY";

    @Override
    public void run() {
       try {
           ObjectMapper mapper = new ObjectMapper();
           String key = System.getProperty(WeatherPoller.OPENWEATHER_KEY);
           if (key == null || key.equals("")) {
               Logger.getLogger(WeatherPoller.class.getName()).log(Level.SEVERE,
                       String.format("Cannot start the weather poller as the system property %s was not set. Please set this variable before running this service.",
                               WeatherPoller.OPENWEATHER_KEY));
               return;
           }

            while (!Thread.interrupted()) {
                for (Student s : Dataset.students.values()) {
                    if (s.updated() != -1 && (s.temperature() == null || System.currentTimeMillis() > s.updated() + 60000*10)) {
                        try {
                            Weather weather = mapper.readValue(
                                    new URL(String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s", s.city, key)),
                                    Weather.class);
                            s.setTemperature(weather.measurements.get("temp"));
                            s.setUpdated(System.currentTimeMillis());
                        } catch (FileNotFoundException ex) {
                            s.setTemperature(null);
                            s.setUpdated(-1);
                        } catch (IOException ex) {
                            Logger.getLogger(WeatherPoller.class.getName()).log(Level.SEVERE, "Error occured when retrieving weather data.", ex);
                        }
                    }
                }
                Thread.sleep(10000);
            }

       } catch (InterruptedException e) {
           // do nothing;
       }
        
    }
    
}
