package org.example.serialization;

import org.example.customer.Customer;

public class BankAccountOwnerSerializationFactory {

    public BankAccountOwnerSerializationFactory (Customer customer) {

        BankAccountOwnerSerialization bankAccountSerialization = new BankAccountOwnerSerialization();

        bankAccountSerialization.uuid = customer.getUuid();
        bankAccountSerialization.FirstName = customer.getFirstName();
        bankAccountSerialization.LastName = customer.getLastName();

    }
}
