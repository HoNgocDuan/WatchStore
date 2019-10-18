package watch.store.mnm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import watch.store.mnm.domain.Account;
import watch.store.mnm.service.AccountService;

import java.util.List;

@RestController
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/all")
    public @ResponseBody
    List<Account> getAll(){
        return accountService.findAll();
    }
}
