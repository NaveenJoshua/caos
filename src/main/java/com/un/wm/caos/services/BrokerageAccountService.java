 ,./4package com.un.wm.caos.services;

import com.un.wm.caos.domain.BrokerageAccount;
import com.un.wm.caos.repo.BrokerageAccountRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
* Commit B soft reset
*/
@Service
public class BrokerageAccountService {


    private BrokerageAccountRespository brokerageAccountRespository;

    @Autowired
    public BrokerageAccountService(BrokerageAccountRespository brokerageAccountRespository) {
        this.brokerageAccountRespository = brokerageAccountRespository;
    }

    public BrokerageAccount create(int account_id, String gsba_account_number, String account_name){

        if(!brokerageAccountRespository.existsById(account_id)){
            brokerageAccountRespository.save(new BrokerageAccount(account_id , gsba_account_number , account_name));
        }
        // ADDING THIS COMMENT FOR RETRIGGER
        
        return null;
    }

    public Iterable<BrokerageAccount> lookup(){
        return brokerageAccountRespository.findAll();
    }
}
