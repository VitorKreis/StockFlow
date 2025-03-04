package DarkCode.StockFlow.Controller;

import DarkCode.StockFlow.Domain.Endereco.DTO.DadosEndereco;
import DarkCode.StockFlow.Domain.Endereco.DTO.EnderecoPageable;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Endereco.EnderecoRepository;
import DarkCode.StockFlow.Domain.Endereco.DTO.EnderecoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoRepository  repository;



    @PostMapping
    public ResponseEntity<EnderecoResponse> story(@RequestBody @Valid  DadosEndereco dados, UriComponentsBuilder uriComponentsBuilder){
        var enderecos = new Endereco(dados);

        repository.save(enderecos);

        var uri = UriComponentsBuilder.fromPath("/endereco/{id}").buildAndExpand(enderecos.getId()).toUri();

        return ResponseEntity.created(uri).body(new EnderecoResponse(enderecos));
    }


    @GetMapping
    public ResponseEntity<Page<EnderecoPageable>> getAll(@PageableDefault(size = 10, sort = {"rua"})Pageable pageable){
        var enderecos = repository.findAll(pageable).map(EnderecoPageable::new);

        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> getById(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new EnderecoResponse(endereco));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EnderecoResponse> updateById(@PathVariable Long id, @RequestBody DadosEndereco dados){

        Endereco endereco = repository.getReferenceById(id);

        endereco.update(dados);

        repository.save(endereco);

        return ResponseEntity.ok(new EnderecoResponse(endereco));

    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity.HeadersBuilder deleteById(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent();
    }




}
