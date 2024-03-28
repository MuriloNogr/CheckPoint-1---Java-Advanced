package jacp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "TDS_TB_PRODUTOCS")
public class Produto {
    @Id
    @Column(name = "ID_PRODUTO")
    private Integer id;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "VL_PRODUTO")
    private Float preco;

    @Column(name = "DT_VALIDADE")
    private Date validade;

    @Column(name = "TM_PRODUTO")
    private Float tamanho;

    @Column(name = "DS_PRODUTO")
    private String descricao;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", validade=" + validade +
                ", tamanho=" + tamanho +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

