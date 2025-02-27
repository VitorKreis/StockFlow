package DarkCode.StockFlow.Domain.Endereco.DTO;

import DarkCode.StockFlow.Domain.Endereco.Endereco;

public record EnderecoPageable(Long id, String rua, String numero, String bairro, String cep, String uf) {

    public EnderecoPageable(Endereco dados){
        this(dados.getId(), dados.getRua(), dados.getNumero(), dados.getBairro(), dados.getCep(), dados.getUf());
    }

}
