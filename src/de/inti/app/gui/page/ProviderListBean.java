package de.inti.app.gui.page;

import de.inti.app.domain.Provider;
import de.inti.app.service.ProviderService;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("providerListBean")
@Scope("request")
public class ProviderListBean {

    @Inject
    private ProviderService providerService;

    private List<Provider> providerList;

    @PostConstruct
    public void init() {
        providerList = providerService.findAll();
    }

    public List<Provider> getProviderList() {
        return providerList;
    }

    @SuppressWarnings("UnusedDeclaration")
    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
    }

}
