/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.assembler;

import org.jobits.pos.client.rest.domain.IndexEndpointData;
import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.jobits.pos.client.rest.endpoint.DefaultEndpoint;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class IndexEndpointAssembler implements RepresentationModelAssembler<IndexEndpointData, EntityModel<IndexEndpointData>> {

    protected Class<? extends DefaultEndpoint> serviceClass;

    public IndexEndpointAssembler(Class<? extends DefaultEndpoint> serviceClass) {
        this.serviceClass = serviceClass;

    }

    @Override
    public EntityModel<IndexEndpointData> toModel(IndexEndpointData entity) {
        return EntityModel.of(entity, linkTo(methodOn(serviceClass).index()).withSelfRel());
    }

}
