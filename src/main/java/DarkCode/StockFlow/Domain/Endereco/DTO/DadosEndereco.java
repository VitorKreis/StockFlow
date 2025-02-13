package DarkCode.StockFlow.Domain.Endereco.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosEndereco(
        @NotNull
        String numero,
        @NotNull
        String rua,
        @NotNull
        String bairro,
        @NotNull
        @Size(min = 8, max = 8)
        String cep,
        @NotNull
        String uf,

        String complemento
        ) {}
