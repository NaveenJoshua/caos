package com.un.wm.caos.repo;

import com.un.wm.caos.domain.BrokerageAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface BrokerageAccountRespository extends CrudRepository<BrokerageAccount , Integer> {

    /*@Override
    @RestResource(exported = false)
    <S extends BrokerageAccount> S save(S s);*/

    /*@RestResource(exported = false)
    <S extends BrokerageAccount> Iterable<S> save(Iterable<S> iterable);

    //Not exposed by Spring Data REST
    @RestResource(exported = false)
    void delete(String s);

    //Not exposed by Spring Data REST
    @RestResource(exported = false)
    void delete(BrokerageAccount tourPackage);

    //Not exposed by Spring Data REST
    @RestResource(exported = false)
    void delete(Iterable<? extends BrokerageAccount> iterable);

    //Not exposed by Spring Data REST
    @RestResource(exported = false)
    void deleteAll();*/
}
