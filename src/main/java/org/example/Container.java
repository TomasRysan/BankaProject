package org.example;

import org.example.factories.BankAccountFactory;
import org.example.factories.PaymentCardFactory;
import org.example.card.PaymentCardCvvGenerator;
import org.example.card.PaymentCardExpireCalculator;
import org.example.card.PaymentCardNumberGenerator;
import org.example.services.AccountLogService;
import org.example.services.BankAccountService;
import org.example.data.GeneratorUUID;

public class Container {

    private final PaymentCardNumberGenerator paymentCardNumberGenerator;
    private final PaymentCardExpireCalculator paymentCardExpireCalculator;
    private final PaymentCardCvvGenerator paymentCardCvvGenerator;

    private final PaymentCardFactory paymentCardFactory;
    private final BankAccountFactory bankAccountFactory;
    private final AccountLogService logger;
    private final BankAccountService bankAccountService;
    private final GeneratorUUID generatorUUID;

    public Container() {
        this.generatorUUID = new GeneratorUUID();
        this.paymentCardNumberGenerator = new PaymentCardNumberGenerator();
        this.paymentCardExpireCalculator = new PaymentCardExpireCalculator();
        this.paymentCardCvvGenerator = new PaymentCardCvvGenerator();
        this.logger = new AccountLogService();

        this.paymentCardFactory = new PaymentCardFactory(
                paymentCardNumberGenerator,
                paymentCardExpireCalculator,
                paymentCardCvvGenerator
        );

        this.bankAccountFactory = new BankAccountFactory(this.generatorUUID);

        this.bankAccountService = new BankAccountService(this.logger);
    }

    public PaymentCardFactory getPaymentCardFactory() {
        return paymentCardFactory;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public AccountLogService getLogger() {
        return logger;
    }

    public BankAccountService getBankAccountService() {
        return bankAccountService;
    }

    public GeneratorUUID getGeneratorUUID() {
        return generatorUUID;
    }
}