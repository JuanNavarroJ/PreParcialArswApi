package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

@Service
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {
    
    List<SuspectAccount> suspectAccountList;
    
    public MoneyLaunderingServiceStub (){
        suspectAccountList = new CopyOnWriteArrayList<>();
        
        SuspectAccount sa1 = new SuspectAccount();
        sa1.setAccountId("juan10");
        sa1.setAmountOfSmallTransactions(10000);
        suspectAccountList.add(sa1);
        SuspectAccount sa2 = new SuspectAccount();
        sa2.setAccountId("david10");
        sa2.setAmountOfSmallTransactions(2030);
        suspectAccountList.add(sa2);
        SuspectAccount sa3 = new SuspectAccount();
        sa3.setAccountId("navarro10");
        sa3.setAmountOfSmallTransactions(2144);
        suspectAccountList.add(sa3);
        SuspectAccount sa4 = new SuspectAccount();
        sa4.setAccountId("jimenez10");
        sa4.setAmountOfSmallTransactions(32140);
        suspectAccountList.add(sa4);
        
        
    }
    
    @Override
    public void updateAccountStatus(SuspectAccount suspectAccount) {
        boolean update = false;
        for(SuspectAccount sa:suspectAccountList){
            if(sa.getAccountId().equals(suspectAccount.getAccountId())){
                sa.setAmountOfSmallTransactions(suspectAccount.getAmountOfSmallTransactions());
                update = true;
            }
        }
        if(!update){
            suspectAccountList.add(suspectAccount);
        }
    }

    @Override
    public SuspectAccount getAccountStatus(String accountId) {
        SuspectAccount ans = null;
        for(SuspectAccount sa:suspectAccountList){
            if(sa.getAccountId().equals(accountId)){
                ans = sa;
            }
        }
        return ans;
    }

    @Override
    public List<SuspectAccount> getSuspectAccounts() {
        return suspectAccountList;
    }
}
