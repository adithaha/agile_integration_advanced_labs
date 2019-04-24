package org.fuse.usecase;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.cxf.message.MessageContentsList;
import org.globex.Account;
import org.globex.Company;
import org.globex.Contact;
import org.globex.CorporateAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Aggregator implementation which extract the id and salescontact
 * from CorporateAccount and update the Account
 */
public class AccountAggregator implements AggregationStrategy {

	private final static Logger LOGGER = LoggerFactory.getLogger(AccountAggregator.class);
	
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

    	LOGGER.info("entering aggregator");
    	LOGGER.info("new exchange: " + newExchange.getIn().getBody());
    	
    	Account oldAcc = null;
    			
    	if (oldExchange == null) {
    		Account newAcc = newExchange.getIn().getBody(Account.class);
    		LOGGER.info("geo: " + newAcc.getCompany().getGeo());
    		
    		return newExchange;
    	}
    	else {
    		oldAcc = oldExchange.getIn().getBody(Account.class);
    		CorporateAccount newAcc = newExchange.getIn().getBody(CorporateAccount.class);
        	LOGGER.info("sales: " + newAcc.getSalesContact());
        	oldAcc.setSalesRepresentative(newAcc.getSalesContact());
        	
            return oldExchange;
    	}
    	
    	
    	
    }
    
    public Account dummyAccount() {
    	Company company = new Company();
    	company.setActive(true);
    	company.setGeo("NA");
    	company.setName("office1");
    	
    	Contact contact = new Contact();
    	contact.setCity("jakarta");
    	
    	
    	Account account = new Account();
    	account.setClientId(1);
    	account.setCompany(company);
    	account.setContact(contact);
    	
    	return account;
    }
    
}