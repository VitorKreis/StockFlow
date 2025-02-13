package DarkCode.StockFlow.Domain.Produto;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "produto")
@Entity(name = "Produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
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

    @Embedded
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


}
