/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.endpoint;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.jobits.pos.client.rest.assembler.IndexEndpointAssembler;
import org.jobits.pos.client.rest.domain.EndpointMetadata;
import org.jobits.pos.client.rest.domain.IndexEndpointData;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public abstract class DefaultEndpoint {

    protected final IndexEndpointData index = new IndexEndpointData();

    public DefaultEndpoint() {
        var a = getClass().getAnnotation(RestController.class);
        if (a != null) {
            var space = getClass().getAnnotation(RequestMapping.class);
            for (Method m : getClass().getMethods()) {
                EndpointMetadata result = parseRequestAnnotation(m, space.path()[0]);
                if (result != null) {
                    index.addEndpoint(result);
                }
            }
        }
    }

    @GetMapping(UrlTemplate.INDEX_PATH)
    public EntityModel<IndexEndpointData> index() {
        return new IndexEndpointAssembler(getClass()).toModel(index);
    }

    private EndpointMetadata parseRequestAnnotation(Method m, String nameSpace) {
        var get = m.getAnnotation(RequestMapping.class);
        if (get != null) {
            if (get.value().length > 0) {
                return EndpointMetadata.from(get.name(),nameSpace, get.path()[0], get.method());
            }
        }
//        var post = m.getAnnotation(PostMapping.class);
//        if (post != null) {
//            return EndpointMetadata.from(nameSpace, post.value()[0], RequestMethod.POST);
//        }
//        var put = m.getAnnotation(PutMapping.class);
//        if (put != null) {
//            return EndpointMetadata.from(nameSpace, put.value()[0], RequestMethod.PUT);
//        }
        return null;
    }
       
    
    
}
