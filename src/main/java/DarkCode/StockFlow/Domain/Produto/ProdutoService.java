package DarkCode.StockFlow.Domain.Produto;

import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Endereco.EnderecoRepository;
import DarkCode.StockFlow.Domain.Fornecedor.ForncedorRepository;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import DarkCode.StockFlow.Domain.Produto.DTO.dadosProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ForncedorRepository forncedorRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto criarProduto(dadosProdutoDTO dados){

        Fornecedor fornecedor = forncedorRepository.findById(dados.fornecedor_id()).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));


        Produto produto = new Produto(dados, fornecedor);

        return produtoRepository.save(produto);

    }

    public Produto update(Long id, dadosProdutoDTO dados){
        var fornecedor = forncedorRepository.getReferenceById(dados.fornecedor_id());

        var produto = produtoRepository.getReferenceById(id);

        produto.update(dados, fornecedor);

        return produto;

    }




}
