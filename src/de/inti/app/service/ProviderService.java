package de.inti.app.service;

import de.inti.app.domain.Provider;

import java.util.List;

public interface ProviderService {

    Provider createNew();

    boolean save(Provider entity);

    void delete(Provider entity);

    List<Provider> findAll();

    Provider findById(long id);

}
