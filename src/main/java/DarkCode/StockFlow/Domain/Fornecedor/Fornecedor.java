package DarkCode.StockFlow.Domain.Fornecedor;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Fornecedor.DTO.dadosFornecedorDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;


@Table(name = "fornecedor")
@Entity(name = "Fornecedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    public void update(dadosFornecedorDTO dados, Endereco endereco) {
        Optional.ofNullable(dados.produtosFornecidos()).ifPresent(this::setCategoria);
        Optional.ofNullable(dados.nome()).ifPresent(this::setNome);
        Optional.ofNullable(dados.telefone()).ifPresent(this::setTelefone);
        Optional.ofNullable(dados.CNPJ()).ifPresent(this::setCNPJ);
        Optional.ofNullable(dados.email()).ifPresent(this::setEmail);
        Optional.ofNullable(endereco).ifPresent(this::setEndereco);

    }

    public void disable(){
        this.setAtivo(false);
    }

}
