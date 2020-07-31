package com.un.wm.caos.services;

import com.un.wm.caos.domain.BrokerageAccount;
import com.un.wm.caos.dto.BrokerageAccountDto;
import com.un.wm.caos.repo.BrokerageAccountRespository;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/accounts")
public class BrokerageAccountServiceController {

    private BrokerageAccountRespository brokerageAccountRespository;

    @Autowired
    public BrokerageAccountServiceController(BrokerageAccountRespository brokerageAccountRespository) {
        super();
        this.brokerageAccountRespository = brokerageAccountRespository;
    }

    protected BrokerageAccountServiceController() {
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getBrokerageAccount/{account_id}")
    public BrokerageAccount getBrokerageAccount(@PathVariable(value = "account_id") int account_id) {
        BrokerageAccount brokerageAccount = brokerageAccountRespository.findById(account_id).orElseThrow(()-> new NoSuchElementException("Account Id Not Found"));
        return brokerageAccount;
    }

    @RequestMapping(method = RequestMethod.POST , path = "/createBrokerageAccount")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBrokerageAccount(@RequestBody BrokerageAccountDto brokerageAccountDto){
        brokerageAccountRespository.save(new BrokerageAccount(brokerageAccountDto.getAccount_id()
                , brokerageAccountDto.getGsba_account_number() , brokerageAccountDto.getAccount_name()));
    }

    @RequestMapping(method = RequestMethod.PUT , path = "/updateBrokerageAccount/{account_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBrokerageAccount(@PathVariable(value = "account_id") int account_id, @RequestBody BrokerageAccountDto brokerageAccountDto){
        Optional<BrokerageAccount> optBrokerageAccount = brokerageAccountRespository.findById(account_id);
        BrokerageAccount brokerageAccount = optBrokerageAccount.get();
        brokerageAccount.setAccount_name(brokerageAccountDto.getAccount_name());
        brokerageAccount.setGsba_account_number(brokerageAccountDto.getGsba_account_number());
        brokerageAccountRespository.save(brokerageAccount);
    }

    @RequestMapping(method = RequestMethod.DELETE , path = "/deleteBrokerageAccount/{account_id}")
    public void deleteBrokerageAccount(@PathVariable(value = "account_id") int account_id){
        Optional<BrokerageAccount> optBrokerageAccount = brokerageAccountRespository.findById(account_id);
        brokerageAccountRespository.delete(optBrokerageAccount.get());
    }



}


