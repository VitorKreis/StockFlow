package DarkCode.StockFlow.Domain.Endereco.DTO;

import DarkCode.StockFlow.Domain.Endereco.Endereco;

import java.util.Optional;

public record EnderecoResponse(Long id, String rua, String numero, String bairro, String cep, String uf) {
    public EnderecoResponse(Endereco dados){
        this(dados.getId(), dados.getRua(), dados.getNumero(), dados.getBairro(), dados.getCep(), dados.getUf());
    }


}
