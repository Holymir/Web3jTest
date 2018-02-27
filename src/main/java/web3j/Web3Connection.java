package web3j;

import org.springframework.stereotype.Component;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class Web3Connection {

    private final static Logger LOGGER = Logger.getLogger(Web3Connection.class.getName());
    private Web3j web3j;

    public Web3Connection() throws IOException {
        this.web3j = connectToRopsten();
    }

    public Web3j getWeb3j() {
        return web3j;
    }

    private static Web3j connectToRopsten() {
        LOGGER.info("Connecting To Ropsten");
        return Web3j.build(new HttpService("https://ropsten.infura.io/Z9u0QbMnyXbBNTCX0V6o"));
    }
}
