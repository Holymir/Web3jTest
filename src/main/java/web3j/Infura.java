package web3j;

import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;
import static org.web3j.tx.Transfer.GAS_LIMIT;

public class Infura {
    public static void main(String[] args) throws Exception {
        //Connection
        Web3j web3 = Web3j.build(new HttpService("https://ropsten.infura.io/Z9u0QbMnyXbBNTCX0V6o"));
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().send();
        System.out.println("web3ClientVersion:");
        System.out.println(web3ClientVersion.getWeb3ClientVersion());


        //Wallet
        String json = "C:\\Users\\Acer\\Documents\\BlockChain\\TestEthAcc\\UTC--2018-02-24T08-49-50.461263400Z--a6d20ef974d4200e8fd0a67661939f768e9ed4a1";
        Credentials credentials = WalletUtils.loadCredentials("q1w2e3r4", json);
        System.out.println("Address:");
        System.out.println(credentials.getAddress());

        //Contract
        Incrementor_sol_Incrementor contract = Incrementor_sol_Incrementor.deploy(
                web3, credentials,
                GAS_PRICE, GAS_LIMIT).send();

        System.out.println();
    }
}
