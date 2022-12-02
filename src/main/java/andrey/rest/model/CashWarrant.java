package andrey.rest.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class CashWarrant {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private OrderType orderType;
    @Column
    private Long sumOrder;
    @Column
    private Long idClientAccount;
    @Column
    private ResultCashWarrant resultCashWarrant;
    @Column
    private Date dateOfCreationCashWarrant;


    public CashWarrant() {
    }

    public CashWarrant(Long id, OrderType orderType, Long sumOrder, Long idClientAccount, ResultCashWarrant resultCashWarrant, Date dateOfCreationCashWarrant) {
        this.id = id;
        this.orderType = orderType;
        this.sumOrder = sumOrder;
        this.idClientAccount = idClientAccount;
        this.resultCashWarrant = resultCashWarrant;
        this.dateOfCreationCashWarrant = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Long getSumOrder() {
        return sumOrder;
    }

    public void setSumOrder(Long sumOrder) {
        this.sumOrder = sumOrder;
    }

    public Long getIdClientAccount() {
        return idClientAccount;
    }

    public void setIdClientAccount(Long idClientAccount) {
        this.idClientAccount = idClientAccount;
    }

    public ResultCashWarrant getResultCashWarrant() {
        return resultCashWarrant;
    }

    public void setResultCashWarrant(ResultCashWarrant resultCashWarrant) {
        this.resultCashWarrant = resultCashWarrant;
    }

    public Date getDateOfCreation() {
        return dateOfCreationCashWarrant;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreationCashWarrant = dateOfCreation;
    }

    @Override
    public String toString() {
        return "CashWarrant{" +
                "id=" + id +
                ", orderType=" + orderType +
                ", sumOrder=" + sumOrder +
                ", idClientAccount=" + idClientAccount +
                ", resultCashWarrant=" + resultCashWarrant +
                ", dateOfCreationCashWarrant=" + dateOfCreationCashWarrant +
                '}';
    }
}
