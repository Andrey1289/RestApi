package andrey.rest.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Date dateOfCreationTransaction;
    @Column(name ="sum_transaction")
    private Long sumTransaction;
    @Column
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    @Column
    private Long idClientAccount;
    @Column
    private Long idCashWarrant;
    @Column
    private Long idClientAccountFromTransfer;
    @Column
    @Enumerated(EnumType.STRING)
    private ResultTransaction resultTransaction;

    public Transaction() {
    }

    public Transaction(Long id, Date dateOfCreationTransaction, Long sumTransaction, OrderType orderType, Long idClientAccount, Long idCashWarrant, Long idClientAccountFromTransfer, ResultTransaction resultTransaction) {
        this.id = id;
        this.dateOfCreationTransaction = new Date();
        this.sumTransaction = sumTransaction;
        this.orderType = orderType;
        this.idClientAccount = idClientAccount;
        this.idCashWarrant = idCashWarrant;
        this.idClientAccountFromTransfer = idClientAccountFromTransfer;
        this.resultTransaction = resultTransaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfCreationTransaction() {
        return dateOfCreationTransaction;
    }

    public void setDateOfCreationTransaction(Date dateOfCreationTransaction) {
        this.dateOfCreationTransaction = dateOfCreationTransaction;
    }

    public Long getSumTransaction() {
        return sumTransaction;
    }

    public void setSumTransaction(Long sumTransaction) {
        this.sumTransaction = sumTransaction;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Long getIdClientAccount() {
        return idClientAccount;
    }

    public void setIdClientAccount(Long idClientAccount) {
        this.idClientAccount = idClientAccount;
    }

    public Long getIdCashWarrant() {
        return idCashWarrant;
    }

    public void setIdCashWarrant(Long idCashWarrant) {
        this.idCashWarrant = idCashWarrant;
    }

    public Long getIdClientAccountFromTransfer() {
        return idClientAccountFromTransfer;
    }

    public void setIdClientAccountFromTransfer(Long idClientAccountFromTransfer) {
        this.idClientAccountFromTransfer = idClientAccountFromTransfer;
    }

    public ResultTransaction getResultTransaction() {
        return resultTransaction;
    }

    public void setResultTransaction(ResultTransaction resultTransaction) {
        this.resultTransaction = resultTransaction;
    }
}
