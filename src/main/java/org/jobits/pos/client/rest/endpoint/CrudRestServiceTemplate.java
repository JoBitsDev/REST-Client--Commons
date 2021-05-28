/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.endpoint;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.beans.PropertyChangeListener;
import java.util.List;
import org.jobits.pos.client.rest.assembler.CrudModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * JoBits
 *
 * @author Jorge
 * @param <T>
 *
 */
public abstract class CrudRestServiceTemplate<T> {

    public CrudRestServiceTemplate() {
    }

    public abstract CRUDUseCase<T> getUc();

    public abstract CrudModelAssembler<T> getAssembler();

    @PostMapping(path = UrlTemplate.CREATE_PATH)
    public EntityModel<T> create(@RequestBody T t) throws RuntimeException {
        return getAssembler().toModel(getUc().create(t));
    }

    @PostMapping(UrlTemplate.EDIT_PATH)
    public EntityModel<T> edit(@RequestBody T t) throws RuntimeException {
        return getAssembler().toModel(getUc().edit(t));
    }

    @PostMapping(UrlTemplate.DESTROY_PATH)
    public EntityModel<T> destroy(@RequestBody T t) throws RuntimeException {
        return getAssembler().toModel(getUc().destroy(t));
    }

    @PostMapping(UrlTemplate.DESTROY_ID_PATH)
    public EntityModel<T> destroyById(@RequestBody Object id) throws RuntimeException {
        return getAssembler().toModel(getUc().destroyById(id));
    }

    @GetMapping(UrlTemplate.FIND_ALL_PATH)
    public CollectionModel<EntityModel<T>> findAll() throws RuntimeException {
        return getAssembler().toCollectionModel(getUc().findAll());
    }

    @GetMapping(UrlTemplate.FIND_BY_PATH)
    public EntityModel<T> findBy(@PathVariable(UrlTemplate.ID) Object id) throws RuntimeException {
        return getAssembler().toModel(getUc().findBy(Integer.parseInt(id.toString())));
    }

    @GetMapping(UrlTemplate.COUNT_PATH)
    public int count() throws RuntimeException {
        return getUc().count();
    }

}
