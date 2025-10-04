package org.example.serialization;

import org.example.accounts.BankAccount;
import org.example.customer.Customer;
import org.example.people.BankAccountOwner;

import java.io.Serializable;

public class BankAccountOwnerSerializationService implements Serialization {

    @Override
    public String Serialization(Object obj) {
        if (!(obj instanceof BankAccountOwner)) {
            throw new IllegalArgumentException("Object není BankAccountOwner");
        }

        BankAccountOwner owner = (BankAccountOwner) obj;
        Customer customer = owner.setCustomer();

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"uuid\":\"").append(customer.getUuid()).append("\",");
        sb.append("\"firstName\":\"").append(customer.getFirstName()).append("\",");
        sb.append("\"lastName\":\"").append(customer.getLastName()).append("\"");
        sb.append("}");

        return sb.toString();
    }


    @Override
    public Object Deserialization(String str) {
        str = str.trim();
        if (str.startsWith("{")) str = str.substring(1);
        if (str.endsWith("}")) str = str.substring(0, str.length() - 1);

        String[] parts = str.split(",");

        String uuid = null, firstName = null, lastName = null;

        for (String part : parts) {
            String[] keyValue = part.split(":");
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();

            switch (key) {
                case "uuid": uuid = value; break;
                case "firstName": firstName = value; break;
                case "lastName": lastName = value; break;
            }
        }

        Customer customer = new Customer(uuid, firstName, lastName);
        return new BankAccountOwner(customer);
    }
}
