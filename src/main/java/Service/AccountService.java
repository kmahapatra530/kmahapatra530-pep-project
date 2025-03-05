package Service;

import Model.Account;
import DAO.AccountDAO;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account registerUser(Account account) {
        if (account.getUsername().isBlank() || account.getPassword().length() < 4 ||
            accountDAO.doesUsernameExist(account.getUsername()))
            return null;
        return accountDAO.registerUser(account);
    }

    public Account loginUser(String username, String password) {
        return accountDAO.loginUser(username, password);
    }
}
