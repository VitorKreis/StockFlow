package DarkCode.StockFlow.Domain.Fornecedor;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "fornecedor")
@Entity(name = "Fornecedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String CNPJ;

    private int telefone;

    private String email;

    @Embedded
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Categoria produtosFornecidos;

    private Boolean ativo;
}
