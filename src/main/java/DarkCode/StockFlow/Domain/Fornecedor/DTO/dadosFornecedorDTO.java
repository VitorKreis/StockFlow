package DarkCode.StockFlow.Domain.Fornecedor.DTO;

import DarkCode.StockFlow.Domain.Categoria;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;

public record dadosFornecedorDTO(

        @NotNull
        String nome,

        @NotNull
        @Size(min = 14, max = 14)
        String CNPJ,

        @NotNull
        String telefone,

        @NotNull
        Categoria  produtosFornecidos,

        @NotNull
        String email,

        @NotNull
        Long endereco_id

) {
}
