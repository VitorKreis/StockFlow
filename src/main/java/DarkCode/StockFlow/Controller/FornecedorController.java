package DarkCode.StockFlow.Controller;

import DarkCode.StockFlow.Domain.Fornecedor.DTO.ResponseFornecedorDTO;
import DarkCode.StockFlow.Domain.Fornecedor.DTO.dadosFornecedorDTO;
import DarkCode.StockFlow.Domain.Fornecedor.ForncedorRepository;
import DarkCode.StockFlow.Domain.Fornecedor.Fornecedor;
import DarkCode.StockFlow.Domain.Fornecedor.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Fornecedor>> getAll(){
        var fornecedores = repository.findAll();

        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable Long id){
        var fornecedores = repository.getReferenceById(id);

        return ResponseEntity.ok(fornecedores);
    }



}
