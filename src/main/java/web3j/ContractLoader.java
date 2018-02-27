package web3j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web3j.contracts.Incrementor_sol_Incrementor;

import java.math.BigInteger;

import static org.web3j.tx.ManagedTransaction.GAS_PRICE;

@Component
public class ContractLoader {

    private Incrementor_sol_Incrementor contract;
    private Web3Connection web3Connection;
    private Credential credential;

    @Autowired
    public ContractLoader(Web3Connection web3Connection, Credential credential) {
        this.web3Connection = web3Connection;
        this.credential = credential;
        this.contract = loadContract();
    }

    public Incrementor_sol_Incrementor getContract() {
        return contract;
    }

    private Incrementor_sol_Incrementor loadContract() {
        return Incrementor_sol_Incrementor.load(
                "0x0c7f2106b22eecb58cc0cf41adb33f2eb8a4dbf2", web3Connection.getWeb3j(), credential.getCredentials(), GAS_PRICE, BigInteger.valueOf(200000));

    }
}
