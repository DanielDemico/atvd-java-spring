package application.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "Usuarios")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private int idade;

    private boolean estuda;

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return this.idade;
    }

    public void setEstuda(boolean estuda){
        this.estuda = estuda;
    }
    public boolean getEstuda(){
        return this.estuda;
    }

}
