package web3j;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

public class Infura {
    public static void main(String[] args) throws Exception {
        //Connection
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/Z9u0QbMnyXbBNTCX0V6o"));
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        System.out.println("web3ClientVersion: " + web3ClientVersion.getWeb3ClientVersion());
        System.out.println("NetworkId: " + web3j.netVersion().send().getNetVersion());


        //Wallet
        String json = "C:\\Users\\Acer\\Documents\\BlockChain\\TestEthAcc\\UTC--2018-02-24T08-49-50.461263400Z--a6d20ef974d4200e8fd0a67661939f768e9ed4a1";
        Credentials credentials = WalletUtils.loadCredentials("q1w2e3r4", json);
        System.out.println("Address: " + credentials.getAddress());

        //Contract
//        Incrementor_sol_Incrementor contract = Incrementor_sol_Incrementor.deploy(
//                web3, credentials,
//                BigInteger.valueOf(1), BigInteger.valueOf(200000)).send();

        //For Existing SmartContract
        Incrementor_sol_Incrementor contract = Incrementor_sol_Incrementor.load(
               "0x0c7f2106b22eecb58cc0cf41adb33f2eb8a4dbf2", web3j, credentials, GAS_PRICE, BigInteger.valueOf(200000));

        System.out.println("isValid: " + contract.isValid());
        System.out.println("Contract Address:  " + contract.getContractAddress());

        //get owner address doesn't work
        //System.out.println("Contract Owner Address: " + contract.getDeployedAddress(ROPSTEN));

        //Increment and Get From Contract
        //System.out.println("Calling Increment: " + contract.increment(BigInteger.valueOf(5)).send());
        BigInteger x = contract.getX().send();
        System.out.println("Value: " + x);


        //Transaction Manager
        TransactionManager transactionManager = new RawTransactionManager(
                web3j, credentials, ChainId.ROPSTEN);
        System.out.println("getFromAddress: " + transactionManager.getFromAddress());

    }
}
