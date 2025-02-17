package DarkCode.StockFlow.Domain.Produto.DTO;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import DarkCode.StockFlow.Domain.Produto.Produto;

public record ResponseProdutoDTO(String nome, String descricao, String codigo, int preco, Categoria categoria, Fornecedor fornecedor ) {

    public ResponseProdutoDTO(Produto produto){
        this(produto.getNome(), produto.getDescricao(), produto.getCodigo(), produto.getPreco(), produto.getCategoria(), produto.getFornecedor());
    }


}
