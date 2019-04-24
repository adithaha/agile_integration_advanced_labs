package org.fuse.usecase.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.11.fuse-710022-redhat-00001
 * 2019-04-24T10:06:35.332+08:00
 * Generated source version: 3.1.11.fuse-710022-redhat-00001
 * 
 */
@WebService(targetNamespace = "http://service.usecase.fuse.org/", name = "CustomerWS")
@XmlSeeAlso({ObjectFactory.class})
public interface CustomerWS {

    @WebMethod
    @RequestWrapper(localName = "updateAccount", targetNamespace = "http://service.usecase.fuse.org/", className = "org.fuse.usecase.service.UpdateAccount")
    @ResponseWrapper(localName = "updateAccountResponse", targetNamespace = "http://service.usecase.fuse.org/", className = "org.fuse.usecase.service.UpdateAccountResponse")
    @WebResult(name = "return", targetNamespace = "")
    public org.fuse.usecase.service.CorporateAccount updateAccount(
        @WebParam(name = "arg0", targetNamespace = "")
        org.fuse.usecase.service.Account arg0
    );
}
