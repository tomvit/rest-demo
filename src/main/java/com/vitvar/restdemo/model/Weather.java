/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitvar.restdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 *
 * @author janka
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    
    @JsonProperty(value="name")
    public String city;
        
    @JsonProperty(value="main")
    public Map<String, Float> measurements;
    
    @JsonProperty(value="dt")    
    public long updated;     
}
