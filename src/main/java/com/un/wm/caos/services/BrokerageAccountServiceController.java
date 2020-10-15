package com.un.wm.caos.services;

import com.un.wm.caos.domain.BrokerageAccount;
import com.un.wm.caos.dto.BrokerageAccountDto;
import com.un.wm.caos.repo.BrokerageAccountRespository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping(path = "/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class BrokerageAccountServiceController {

    private BrokerageAccountRespository brokerageAccountRespository;

    @Autowired
    public BrokerageAccountServiceController(BrokerageAccountRespository brokerageAccountRespository) {
        super();
        this.brokerageAccountRespository = brokerageAccountRespository;
    }

    protected BrokerageAccountServiceController() {
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getBrokerageAccount/byId/{accountId}")
    public BrokerageAccount getBrokerageAccount(@PathVariable(value = "accountId") int account_id) {
        BrokerageAccount brokerageAccount = brokerageAccountRespository.findById(account_id).orElseThrow(()-> new NoSuchElementException("Account Id Not Found"));
        return brokerageAccount;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getBrokerageAccount/byAccountNumber")
    public BrokerageAccount getBrokerageAccountByNumber(@QueryParam("accountNumber") String accountNumber) {
        BrokerageAccount brokerageAccount = brokerageAccountRespository.findByAccountNumber(accountNumber)
                .orElseThrow(()-> new NoSuchElementException("Account Number Not Found"));
        return brokerageAccount;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getBrokerageAccount/byAccountName")
    public BrokerageAccount getBrokerageAccountByName(@QueryParam("accountName") String accountName) {
        BrokerageAccount brokerageAccount = brokerageAccountRespository.findByAccountName(accountName)
                .orElseThrow(()-> new NoSuchElementException("Account Not Found By Name " + accountName ));
        return brokerageAccount;
    }

    @RequestMapping(method = RequestMethod.POST , path = "/createBrokerageAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBrokerageAccount(@RequestBody BrokerageAccountDto brokerageAccountDto){
        brokerageAccountRespository.save(new BrokerageAccount(brokerageAccountDto.getAccountId()
                , brokerageAccountDto.getAccountNumber() , brokerageAccountDto.getAccountName()));
    }

    @RequestMapping(method = RequestMethod.PUT , path = "/updateBrokerageAccount/{accountNumber}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBrokerageAccount(@PathVariable(value = "accountNumber") String acct_number, @RequestBody BrokerageAccountDto brokerageAccountDto){
        BrokerageAccount brokerageAccount = brokerageAccountRespository.findByAccountNumber(acct_number)
                .orElseThrow(()-> new NoSuchElementException("Account Number Not Found"));
        brokerageAccount.setAccountName(brokerageAccountDto.getAccountName());
        brokerageAccount.setAccountNumber(brokerageAccountDto.getAccountNumber());
        brokerageAccountRespository.save(brokerageAccount);
    }

    @RequestMapping(method = RequestMethod.DELETE , path = "/deleteBrokerageAccount/{accountNumber}")
    public void deleteBrokerageAccount(@PathVariable(value = "accountNumber") String accountNumber){
        Optional<BrokerageAccount> optBrokerageAccount = brokerageAccountRespository.findByAccountNumber(accountNumber);
        brokerageAccountRespository.delete(optBrokerageAccount.get());
    }
}


