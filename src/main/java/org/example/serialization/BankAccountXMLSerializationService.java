package org.example.serialization;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.customer.Customer;
import org.example.people.BankAccountOwner;

public class BankAccountXMLSerializationService implements Serialization {

    private final XmlMapper xmlMapper;

    public BankAccountXMLSerializationService() {
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public String Serialization(Object obj) {
        if (!(obj instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("Object není BankAccountOwner");
        }

        try {
            return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při serializaci do XML", e);
        }
    }

    @Override
    public Object Deserialization(String xml) {
        try {
            return xmlMapper.readValue(xml, BankAccountOwner.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při deserializaci z XML", e);
        }
    }
}

