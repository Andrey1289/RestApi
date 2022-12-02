package andrey.rest.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long clientId;
    @Column
    private Long numberAccount;
    @Column
    private Long sumOnAccountClient;
    @Column
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column
    private Date dateOpen;
    @Column
    private Long validity;
    // one to many
    private List<Transaction> transactionList;
    //one to many
    private List<CashWarrant> cashWarrantList;

    public ClientAccount() {
    }

    public ClientAccount(Long id, Long clientId, Long numberAccount, Long sumOnAccountClient, AccountType accountType, Date dateOpen, Long validity) {
        this.id = id;
        this.clientId = clientId;
        this.numberAccount = numberAccount;
        this.sumOnAccountClient = sumOnAccountClient;
        this.accountType = accountType;
        this.dateOpen = new Date();
        this.validity = 1L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Long getSumOnAccountClient() {
        return sumOnAccountClient;
    }

    public void setSumOnAccountClient(Long sumOnAccountClient) {
        this.sumOnAccountClient = sumOnAccountClient;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", numberAccount=" + numberAccount +
                ", sumOnAccountClient=" + sumOnAccountClient +
                ", accountType=" + accountType +
                ", dateOpen=" + dateOpen +
                ", validity=" + validity +
                '}';
    }
}
