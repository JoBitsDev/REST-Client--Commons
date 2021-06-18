/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class IndexEndpointData {

    private final List<EndpointMetadata> endpoints = new ArrayList<>();

    public IndexEndpointData() {
    }

    public List<EndpointMetadata> getEndpoints() {
        return new ArrayList<>(endpoints);
    }
    
    public void addEndpoint(EndpointMetadata endpoint){
        endpoints.add(endpoint);
    }

}
