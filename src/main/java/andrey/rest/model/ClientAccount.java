package andrey.rest.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client_accounts")
public class ClientAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "account_sum")
    private Long sumOnAccountClient;
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name = "date_of_create")
    private Date dateOpen = new Date();
    @Column(name = "validity")
    private Long validity;
    @ManyToOne
    @JoinColumn(name = "client_id",insertable=false, updatable=false)
    private Client client;
    @OneToMany(mappedBy = "clientAccount")
    private List<Transaction> transactionList;
    @OneToMany(mappedBy = "clientAccount")
    private List<CashWarrant> cashWarrantList;

    public ClientAccount() {
    }

    public ClientAccount(Long id, Long clientId, Long accountNumber, Long sumOnAccountClient, AccountType accountType, Long validity) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.sumOnAccountClient = sumOnAccountClient;
        this.accountType = accountType;
        this.validity = validity;
    }

    public ClientAccount(Date dateOpen) {
        this.dateOpen = dateOpen;
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
        return accountNumber;
    }

    public void setNumberAccount(Long accountNumber) {
        this.accountNumber = accountNumber;
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
    public Long getValidity() {
        return validity;
    }
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setValidity(Long validity) {
        this.validity = validity;
    }
    @Override
    public String toString() {
        return "ClientAccount{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber=" + accountNumber +
                ", sumOnAccountClient=" + sumOnAccountClient +
                ", accountType=" + accountType +
                ", dateOpen=" + dateOpen +
                ", validity=" + validity +
                '}';
    }


}
