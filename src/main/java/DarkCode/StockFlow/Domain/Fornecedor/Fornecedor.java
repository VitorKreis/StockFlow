package DarkCode.StockFlow.Domain.Fornecedor;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Fornecedor.DTO.dadosFornecedorDTO;
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

    private String telefone;

    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private Boolean ativo;

    public Fornecedor(dadosFornecedorDTO dados, Endereco endereco) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.CNPJ = dados.CNPJ();
        this.email = dados.email();
        this.endereco = endereco;
        this.categoria = dados.produtosFornecidos();
        this.ativo = true;
    }
}
