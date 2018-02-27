package web3j;

import web3j.contracts.Incrementor_sol_Incrementor;
import java.math.BigInteger;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

public class test {
    public static void main(String[] args) throws Exception {
        Web3Connection web3Connection = new Web3Connection();
        Credential credential = new Credential();
        Incrementor_sol_Incrementor contract = new Incrementor_sol_Incrementor("0x0c7f2106b22eecb58cc0cf41adb33f2eb8a4dbf2", web3Connection.getWeb3j(),
                credential.getCredentials(), GAS_PRICE, BigInteger.valueOf(200000));

        //System.out.println(contract.getX().send());
        BigInteger x = contract.getX().send();
        System.out.println("Value: " + x);
        System.out.println(x);
    }
}
