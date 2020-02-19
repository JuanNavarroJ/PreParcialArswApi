package edu.eci.arsw.exams.moneylaunderingapi;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/fraud-bank-accounts")
public class MoneyLaunderingController {

    @Autowired
    MoneyLaunderingService moneyLaunderingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<SuspectAccount> getAllOffendingAccounts() {
        return moneyLaunderingService.getSuspectAccounts();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> newSuspectAccount(@RequestBody SuspectAccount sa) {
        moneyLaunderingService.updateAccountStatus(sa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "{accountId}")
    public SuspectAccount getOffendingAccount(@PathVariable("accountId") String accountId) {
        return moneyLaunderingService.getAccountStatus(accountId);
    }
    
    @RequestMapping(method = RequestMethod.PUT, path = "{accountId}")
    public ResponseEntity<?> modifySuspectAccount(@PathVariable("accountId") String accountId, @RequestBody SuspectAccount sa) {
        moneyLaunderingService.updateAccountStatus(sa);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
