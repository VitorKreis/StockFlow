package DarkCode.StockFlow.Domain.Fornecedor.DTO;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;

public record ResponseFornecedorDTO(Long id, String nome, String CNPJ, String telefone, String email, Endereco endereco_id, Categoria categoria) {
    public ResponseFornecedorDTO(Fornecedor fornecedor) {
        this(fornecedor.getId(), fornecedor.getNome(), fornecedor.getCNPJ(), fornecedor.getTelefone(), fornecedor.getEmail(), fornecedor.getEndereco(), fornecedor.getCategoria());
    }
}
