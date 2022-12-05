package andrey.rest.model;


public class CreateCashWarrantRequest {

    private OrderType orderType;
    private Long sumOrder;
    private Long accountNumber;
    private String secretWord;
    private Long numberAccountForTransfer;

    public CreateCashWarrantRequest(OrderType orderType, Long sumOrder, Long accountNumber) {
        this.orderType = orderType;
        this.sumOrder = sumOrder;
        this.accountNumber = accountNumber;
    }

    public CreateCashWarrantRequest(String secretWord) {
        this.secretWord = secretWord;
    }

    public CreateCashWarrantRequest(Long numberAccountForTransfer) {
        this.numberAccountForTransfer = numberAccountForTransfer;
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

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }


    public Long getNumberAccountForTransfer() {
        return numberAccountForTransfer;
    }

    public void setNumberAccountForTransfer(Long numberAccountForTransfer) {
        this.numberAccountForTransfer = numberAccountForTransfer;
    }

    @Override
    public String toString() {
        return "CreateCashWarrantRequest{" +
                "orderType=" + orderType +
                ", sumOrder=" + sumOrder +
                ", accountNumber=" + accountNumber +
                ", secretWord='" + secretWord + '\'' +
                '}';
    }

}
