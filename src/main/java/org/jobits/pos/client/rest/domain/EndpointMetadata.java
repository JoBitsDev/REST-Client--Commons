/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.domain;

import java.util.Arrays;
import java.util.Objects;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class EndpointMetadata {

    private final String name;
    //private final String description;
    private final String namespace;
    private final String path;
    //private String urlfull;
    //private String description;
    private final RequestMethod[] method;

    public static EndpointMetadata from(String name, String namespace, String path, RequestMethod... method) {
        return new EndpointMetadata(name, namespace, path, method);
    }

    private EndpointMetadata(String name, String namespace, String path, RequestMethod[] method) {
        this.namespace = namespace;
        this.name = name;
        this.path = path;
        this.method = method;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }

    public RequestMethod[] getMethod() {
        return method;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EndpointMetadata other = (EndpointMetadata) obj;
        if (!Objects.equals(this.namespace, other.namespace)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Arrays.deepEquals(this.method, other.method)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EndpointMetadata{" + "namespace=" + namespace + ", path=" + path + ", method=" + method + '}';
    }

}
