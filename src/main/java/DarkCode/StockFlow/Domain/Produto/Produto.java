package DarkCode.StockFlow.Domain.Produto;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import DarkCode.StockFlow.Domain.Produto.DTO.dadosProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;


@Table(name = "produto")
@Entity(name = "Produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private String codigo;

    private int preco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Embedded
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    private boolean ativo;


    public Produto(dadosProdutoDTO dados, Fornecedor fornecedor) {
         this.nome = dados.nome();
         this.descricao = dados.descricao();
         this.codigo = dados.codigo();
         this.preco = dados.preco();
         this.categoria = dados.categoria();
         this.fornecedor = fornecedor;
         this.ativo = true;
    }

    public void update(dadosProdutoDTO dados, Fornecedor fornecedor){
        Optional.ofNullable(dados.categoria()).ifPresent(this::setCategoria);
        Optional.ofNullable(dados.nome()).ifPresent(this::setNome);
        Optional.ofNullable(dados.codigo()).ifPresent(this::setCodigo);
        Optional.ofNullable(dados.descricao()).ifPresent(this::setDescricao);
        Optional.of(dados.preco()).ifPresent(this::setPreco);
        Optional.ofNullable(fornecedor).ifPresent(this::setFornecedor);

    }

    public void disable(){
        this.setAtivo(false);
    }

}
