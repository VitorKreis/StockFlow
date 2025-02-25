package DarkCode.StockFlow.Controller;

import DarkCode.StockFlow.Domain.Fornecedor.DTO.FornecedorPagableDTO;
import DarkCode.StockFlow.Domain.Fornecedor.DTO.ResponseFornecedorDTO;
import DarkCode.StockFlow.Domain.Fornecedor.DTO.dadosFornecedorDTO;
import DarkCode.StockFlow.Domain.Fornecedor.ForncedorRepository;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import DarkCode.StockFlow.Domain.Fornecedor.FornecedorService;
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
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    ForncedorRepository repository;

    @Autowired
    FornecedorService service;


    @PostMapping
    public ResponseEntity<ResponseFornecedorDTO> store(@RequestBody @Valid dadosFornecedorDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var fornecedor = service.criarFornecedor(dados);

        var uri = UriComponentsBuilder.fromPath("fornecedor/{id}").buildAndExpand(fornecedor.getId()).toUri();

        return ResponseEntity.created(uri).body(new ResponseFornecedorDTO(fornecedor));

    }


    @GetMapping
    public ResponseEntity<Page<FornecedorPagableDTO>> getAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var fornecedores = repository.findAllAtivo(pageable).map(FornecedorPagableDTO::new);

        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long id){
        var fornecedores = repository.getReferenceById(id);

        return ResponseEntity.ok(fornecedores);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ResponseFornecedorDTO> updateById(@PathVariable Long id, @RequestBody dadosFornecedorDTO dados){

        Fornecedor forncedor = repository.getReferenceById(id);

        forncedor.update(dados);

        return ResponseEntity.ok(new ResponseFornecedorDTO(forncedor));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity.HeadersBuilder disableById(@PathVariable Long id){

        var fornercedor = repository.getReferenceById(id);

        fornercedor.disable();

        return ResponseEntity.noContent();
    }








}
