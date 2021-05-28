/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jobits.pos.client.rest.endpoint;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * JoBits
 *
 * @author Jorge
 *
 */
public class UrlTemplate {
    
    public static final String ID = "id";

    public static final String CREATE_PATH = "/create";
    public static final RequestMethod CREATE_METHOD = RequestMethod.POST;

    public static final String EDIT_PATH = "/edit";
    public static final RequestMethod EDIT_METHOD = RequestMethod.POST;

    public static final String DESTROY_PATH = "/destroy";
    public static final RequestMethod DESTROY_METHOD = RequestMethod.POST;

    public static final String DESTROY_ID_PATH = "/destroy/{" + ID + "}";

    public static final RequestMethod DESTROY_ID_METHOD = RequestMethod.POST;

    public static final String FIND_ALL_PATH = "/list";
    public static final RequestMethod DFIND_ALL_METHOD = RequestMethod.GET;

    public static final String FIND_BY_PATH = "/find/{" + ID + "}";
    public static final RequestMethod FIND_BY_METHOD = RequestMethod.GET;

    public static final String COUNT_PATH = "/count";
    public static final RequestMethod COUNT_METHOD = RequestMethod.GET;
}
