package com.hub.acchub.Service;

import com.hub.acchub.Models.LotsModel;
import com.hub.acchub.Repository.LotsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LotsService {

    private final LotsRepository lotsRepository;

    public LotsService(LotsRepository lotsRepository){
        this.lotsRepository = lotsRepository;
    }

    public Optional<LotsModel> LotsById(long id){
        return lotsRepository.findById(id);
    }
}
