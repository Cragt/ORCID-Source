package org.orcid.utils.jersey.unmarshaller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.orcid.jaxb.model.v3.release.record.Membership;

import javax.ws.rs.Consumes;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes({ "application/xml", "application/json" })
public class V3MembershipBodyReader implements MessageBodyReader<Membership> {

    private final Unmarshaller unmarshaller;

    public V3MembershipBodyReader() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Membership.class);
            unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException jaxbException) {
            throw new ProcessingException("Error deserializing a " + Membership.class, jaxbException);
        }
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Membership.class;
    }

    @Override
    public Membership readFrom(Class<Membership> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
            InputStream entityStream) throws IOException, WebApplicationException {
        try {
            return (Membership) unmarshaller.unmarshal(entityStream);
        } catch (JAXBException e) {
            throw new ProcessingException("Error deserializing a " + Membership.class, e);
        }
    }

}