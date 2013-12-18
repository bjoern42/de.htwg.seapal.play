package de.htwg.seapal.web.controllers.secure;

import de.htwg.seapal.utils.observer.IObservable;
import de.htwg.seapal.web.controllers.secure.impl.Account;
import play.data.Form;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.UUID;

public interface IAccountController
        extends IObservable {

    String AUTHN_COOKIE_KEY = "id";

    String getAccountName(UUID id);

    void setAccountName(UUID id, String AccountName);

    String getAccountPassword(UUID id);

    void setAccountPassword(UUID id, String Password)
            throws InvalidKeySpecException, NoSuchAlgorithmException;

    String getString(UUID id);

    UUID newAccount();

    void deleteAccount(UUID id);

    void closeDB();

    List<UUID> getAccounts();

    IAccount getAccount(UUID AccountId);

    List<IAccount> getAllAccounts();

    boolean saveAccount(IAccount Account);

    IAccount authenticate(Form<Account> form)
            throws Exception;

    boolean accountExists(String accountName)
            throws Exception;

    List<? extends IAccount> queryView(String viewName, String key);
}
