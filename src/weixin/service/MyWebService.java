package weixin.service;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-09-05T15:16:40.457+08:00
 * Generated source version: 3.1.12
 * 
 */
@WebService(targetNamespace = "http://webservice.com/", name = "MyWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface MyWebService {

    @WebMethod
    @RequestWrapper(localName = "say", targetNamespace = "http://webservice.com/", className = "weixin.service.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://webservice.com/", className = "weixin.service.SayResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String say();
}