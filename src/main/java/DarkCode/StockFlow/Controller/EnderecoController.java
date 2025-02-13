package DarkCode.StockFlow.Controller;

import DarkCode.StockFlow.Domain.Endereco.DTO.DadosEndereco;
import DarkCode.StockFlow.Domain.Endereco.Endereco;
import DarkCode.StockFlow.Domain.Endereco.EnderecoRepository;
import DarkCode.StockFlow.Domain.Endereco.DTO.EnderecoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
    public ResponseEntity<List<Endereco>> getAll(){
        var enderecos = repository.findAll();

        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> getById(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new EnderecoResponse(endereco));
    }



}
