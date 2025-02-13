package DarkCode.StockFlow.Domain.Endereco.DTO;

import DarkCode.StockFlow.Domain.Endereco.Endereco;

import java.util.Optional;

public record EnderecoResponse(String rua, String numero, String bairro, String cep, String uf) {
    public EnderecoResponse(Endereco dados){
        this(dados.getRua(), dados.getNumero(), dados.getBairro(), dados.getCep(), dados.getUf());
    }


}
