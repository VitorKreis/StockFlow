package DarkCode.StockFlow.Domain.Endereco;


import DarkCode.StockFlow.Domain.Endereco.DTO.DadosEndereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Table(name = "endereco")
@Entity(name = "Endereco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;

    private String numero;

    private String bairro;

    private String cep;

    private String uf;

    private String complemento;

    public Endereco(DadosEndereco dados) {
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
    }

    public void update(DadosEndereco dados) {
        Optional.ofNullable(dados.rua()).ifPresent(this::setRua);
        Optional.ofNullable(dados.cep()).ifPresent(this::setCep);
        Optional.ofNullable(dados.numero()).ifPresent(this::setNumero);
        Optional.ofNullable(dados.uf()).ifPresent(this::setUf);
        Optional.ofNullable(dados.bairro()).ifPresent(this::setBairro);
        Optional.ofNullable(dados.complemento()).ifPresent(this::setComplemento);
    }
}
