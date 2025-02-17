package DarkCode.StockFlow.Domain.Produto.DTO;

import DarkCode.StockFlow.Domain.Categoria;

public record dadosProdutoDTO(
        String nome,

        String descricao,

        String codigo,

        int preco,

        Categoria categoria,

        Long fornecedor_id,

        Long endereco_id
) {
}
