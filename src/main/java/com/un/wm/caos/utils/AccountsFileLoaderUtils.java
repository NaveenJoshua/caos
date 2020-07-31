package com.un.wm.caos.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.un.wm.caos.domain.BrokerageAccount;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AccountsFileLoaderUtils {

    private int account_id;

    private String gsba_account_number , account_name ;

    public List<BrokerageAccount> fileReadFromJson() throws IOException {
        return new ObjectMapper().setVisibility(PropertyAccessor.FIELD , JsonAutoDetect.Visibility.ANY).
                readValue(AccountsFileLoaderUtils.class.getResource("/Accounts.json"),
                        new TypeReference<List<BrokerageAccount>>(){
                        });

    }
}
