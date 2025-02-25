package DarkCode.StockFlow.Controller;

import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import DarkCode.StockFlow.Domain.Produto.DTO.ProdutoPagableDTO;
import DarkCode.StockFlow.Domain.Produto.DTO.ResponseProdutoDTO;
import DarkCode.StockFlow.Domain.Produto.DTO.dadosProdutoDTO;
import DarkCode.StockFlow.Domain.Produto.Produto;
import DarkCode.StockFlow.Domain.Produto.ProdutoRepository;
import DarkCode.StockFlow.Domain.Produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produto")

public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    public ResponseEntity<ResponseProdutoDTO> store(@RequestBody @Valid dadosProdutoDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var produto = service.criarProduto(dados);

        var uri = UriComponentsBuilder.fromPath("produto/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new ResponseProdutoDTO(produto));

    }

    @GetMapping
    public ResponseEntity<Page<ProdutoPagableDTO>> getAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var produtos = repository.findAllAtivo(pageable).map(ProdutoPagableDTO::new);


        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        var produtos = repository.getReferenceById(id);

        return ResponseEntity.ok(produtos);
    }


    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<ResponseProdutoDTO> updateById(@PathVariable Long id, @RequestBody  dadosProdutoDTO dados){

        Produto produto = repository.getReferenceById(id);

        produto.update(dados);

        return ResponseEntity.ok(new ResponseProdutoDTO(produto));

    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity.HeadersBuilder disableById(@PathVariable Long id){

        var produto = repository.getReferenceById(id);

        produto.disable();

        return ResponseEntity.noContent();
    }




}
