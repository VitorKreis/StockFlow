package DarkCode.StockFlow.Controller;

import DarkCode.StockFlow.Domain.Produto.DTO.ResponseProdutoDTO;
import DarkCode.StockFlow.Domain.Produto.DTO.dadosProdutoDTO;
import DarkCode.StockFlow.Domain.Produto.Produto;
import DarkCode.StockFlow.Domain.Produto.ProdutoRepository;
import DarkCode.StockFlow.Domain.Produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Produto>> getAll(){
        var produtos = repository.findAll();


        return ResponseEntity.ok(produtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id){
        var produtos = repository.getReferenceById(id);


        return ResponseEntity.ok(produtos);
    }



}
