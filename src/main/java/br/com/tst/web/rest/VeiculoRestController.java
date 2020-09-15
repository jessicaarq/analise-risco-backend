package br.com.tst.web.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.tst.domain.Veiculo;
import br.com.tst.service.VeiculoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/rest/veiculo")
public class VeiculoRestController {

    @Autowired
    private VeiculoService service;

//    @RequestMapping(method= RequestMethod.GET)
//    public ResponseEntity<List<Veiculo>> findAll() {
//        List<Veiculo> listVeiculos = service.findAll();
//        return ResponseEntity.ok().body(listVeiculos);
//    }

    @CrossOrigin
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Veiculo>> listByRisco() {
        return ResponseEntity.ok().body(service.listByRisco());
    }

    @CrossOrigin
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Veiculo> find(@PathVariable Integer id) {
        Veiculo obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> insert(@RequestBody Veiculo obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Veiculo obj){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
