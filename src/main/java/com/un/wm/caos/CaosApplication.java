package com.un.wm.caos;

import com.un.wm.caos.services.BrokerageAccountService;
import com.un.wm.caos.utils.AccountsFileLoaderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaosApplication {

	@Autowired
	private BrokerageAccountService brokerageAccountService;

	@Autowired
	private AccountsFileLoaderUtils accountsFileLoaderUtils;

	public static void main(String[] args) {
		SpringApplication.run(CaosApplication.class, args);
	}

/*
	@Override
	public void run(String... args) throws Exception {
		*//*brokerageAccountService.create( 1001 , "096445774" , "Naveen Account");
		brokerageAccountService.create( 1002 , "096445775" , "Prince Account");
		brokerageAccountService.create( 1003 , "096445776" , "Usha Account");
		brokerageAccountService.create( 1004 , "096445777" , "Dharshana Account");
		brokerageAccountService.create( 1005 , "096445778" , "Reva Account");
		brokerageAccountService.create( 1006 , "096445779" , "Amar Account");
		brokerageAccountService.create( 1007 , "096445780" , "Sheeba Account");
		brokerageAccountService.create( 1008 , "096445781" , "Sam Account");*//*
		accountsFileLoaderUtils.fileReadFromJson().forEach(acct-> brokerageAccountService.create(acct.getAccount_id() ,  acct.getGsba_account_number() , acct.getAccount_name()));
		brokerageAccountService.lookup().forEach(brokerageAccount -> System.out.println(brokerageAccount.toString()));
	}*/


}
