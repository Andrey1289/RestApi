package andrey.rest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="last_name")
    private String lastName;
    @Column(name = "name")
    private String name;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "secret_word")
    private String secretWord;
    @OneToMany(mappedBy = "client")
    private List<ClientAccount> accountList;

    public Client() {
    }

    public Client(String lastName, String name, String middleName, String secretWord) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.secretWord = secretWord;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecretWord() {
        return secretWord;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", secretWord='" + secretWord + '\'' +
                '}';
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }
}
