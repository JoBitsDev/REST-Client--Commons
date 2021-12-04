/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.endpoint;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.beans.PropertyChangeListener;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * JoBits
 *
 * @author Jorge
 * @param <Entity>
 *
 */
public abstract class CrudRestEndPointTemplate<Entity, UseCase extends CRUDUseCase<Entity>>
        extends DefaultEndpoint implements CRUDUseCase<Entity> {

    public CrudRestEndPointTemplate() {
        super();
    }

    public abstract UseCase getUc();

    @Override
    @PostMapping(UrlTemplate.CREATE_PATH)
    public Entity create(@RequestBody Entity t) throws RuntimeException {
        return getUc().create(t);
    }

    @Override
    @PutMapping(UrlTemplate.EDIT_PATH)
    public Entity edit(@RequestBody Entity t) throws RuntimeException {
        return getUc().edit(t);
    }

    @Override
    public Entity destroy(Entity t) throws RuntimeException {
        throw new UnsupportedOperationException("En desarrollo");
    }

    @Override
    @DeleteMapping(UrlTemplate.DESTROY_ID_PATH)
    public Entity destroyById(@PathVariable("id") Object o) throws RuntimeException {
        return getUc().destroyById(o);
    }

    @Override
    @GetMapping(UrlTemplate.FIND_BY_PATH)
    public Entity findBy(@PathVariable("id") Object o) throws RuntimeException {
        return getUc().findBy(o);
    }

    @Override
    @GetMapping(UrlTemplate.FIND_ALL_PATH)
    public List<Entity> findAll() throws RuntimeException {
        return getUc().findAll();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pl) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

}
