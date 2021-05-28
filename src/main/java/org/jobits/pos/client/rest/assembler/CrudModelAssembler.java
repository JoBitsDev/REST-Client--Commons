/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.assembler;

import org.jobits.pos.client.rest.endpoint.CrudRestServiceTemplate;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public abstract class CrudModelAssembler<T> implements RepresentationModelAssembler<T, EntityModel<T>> {

    protected Class<? extends CrudRestServiceTemplate<T>> serviceClass;

    public CrudModelAssembler(Class<? extends CrudRestServiceTemplate<T>> serviceClass) {
        this.serviceClass = serviceClass;
    }

    public abstract Object getId(T entity);

    @Override
    public EntityModel<T> toModel(T entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(serviceClass).count()).withRel("count"),
                linkTo(methodOn(serviceClass).findAll()).withRel("list"),
                linkTo(methodOn(serviceClass).create(entity)).withRel("create"),
                linkTo(methodOn(serviceClass).destroy(entity)).withRel("destroy"),
                linkTo(methodOn(serviceClass).destroyById(getId(entity))).withRel("destroyById"),
                linkTo(methodOn(serviceClass).edit(entity)).withRel("edit"),
                linkTo(methodOn(serviceClass).findBy(getId(entity))).withRel("findBy"));

    }

}
