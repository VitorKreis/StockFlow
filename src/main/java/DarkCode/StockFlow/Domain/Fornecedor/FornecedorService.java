package DarkCode.StockFlow.Domain.Fornecedor;

import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Endereco.EnderecoRepository;
import DarkCode.StockFlow.Domain.Fornecedor.DTO.dadosFornecedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    ForncedorRepository forncedor_repository;

    @Autowired
    EnderecoRepository endereco_repository;


    public Fornecedor criarFornecedor(dadosFornecedorDTO dados){
        Endereco endereco = endereco_repository.findById(dados.endereco_id()).orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        Fornecedor fornecedor = new Fornecedor(dados, endereco);


        return forncedor_repository.save(fornecedor);

    }


}
