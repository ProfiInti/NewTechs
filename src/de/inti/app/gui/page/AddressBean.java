package de.inti.app.gui.page;

import de.inti.app.domain.Address;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

@Named("addressBean")
@Scope("session")
public class AddressBean {
	private Address address;

    public String edit(Address address) {
        this.address = address;
        return "/editAddress.xhtml";
    }

	public String save() {
		return "/showCustomer.xhtml";
	}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}