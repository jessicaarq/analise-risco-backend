package br.com.tst.service;

import java.util.*;
import java.util.stream.Collectors;

import br.com.tst.service.dto.VeiculoDTO;
import br.com.tst.service.exception.ObjectNotFoundException;
import br.com.tst.service.helper.VeiculoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tst.domain.Veiculo;
import br.com.tst.repository.VeiculoRepository;

@Service
@Validated
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private VeiculoHelper helper;

    public Veiculo find(Integer id) {
        Optional<Veiculo> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
    }

    public Veiculo save(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public Veiculo insert (Veiculo obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Veiculo update (Veiculo obj){
        find(obj.getId());
        return repository.save(obj);
    }

    public void delete (Integer id){
        find(id);
        repository.delete(find(id));
    }

    public List<Veiculo> findAll() {
        return (List<Veiculo>) repository.findAll();
    }

    public List<Veiculo> listByRisco(){
        List<Veiculo> listVeiculos = repository.findAll();

        for (Veiculo v : listVeiculos){
            helper.calcRisco(v);
        }

        List<Veiculo> listVeiculosOrdered = listVeiculos.stream()
                .sorted(Comparator.comparingInt(Veiculo::getAno))
                .collect(Collectors.toList());

        return listVeiculosOrdered;
    }

}
