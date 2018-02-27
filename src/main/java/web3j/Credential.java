package web3j;

import org.springframework.stereotype.Component;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class Credential {

    private final static Logger LOGGER = Logger.getLogger(Web3Connection.class.getName());
    private Credentials credentials;

    public Credential() throws IOException, CipherException {
        this.credentials = loadWallet();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    private Credentials loadWallet() throws IOException, CipherException {
        String json = "C:\\Users\\Acer\\Documents\\BlockChain\\TestEthAcc\\UTC--2018-02-24T08-49-50.461263400Z--a6d20ef974d4200e8fd0a67661939f768e9ed4a1";
        Credentials credentials = WalletUtils.loadCredentials("q1w2e3r4", json);
        LOGGER.info("Credential Loaded: " + credentials.getAddress());
        return credentials;
    }
}
