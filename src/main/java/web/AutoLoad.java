package web;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.web3j.crypto.CipherException;
import web3j.ContractLoader;
import web3j.Credential;
import web3j.Web3Connection;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class AutoLoad {
    private final static Logger LOGGER = Logger.getLogger(Web3Connection.class.getName());

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws IOException, CipherException {
        Web3Connection connection = new Web3Connection();
        Credential credential = new Credential();
        ContractLoader contractLoader = new ContractLoader(connection, credential);
        LOGGER.info("Contract Address: " + contractLoader.getContract().getX());
    }
}
