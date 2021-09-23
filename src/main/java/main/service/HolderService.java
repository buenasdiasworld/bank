package main.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import main.model.dto.response.HolderResponse;
import main.model.dto.response.ListResponse;
import main.model.entity.Holder;
import main.model.entity.Transaction;
import main.repository.HolderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@RequiredArgsConstructor
public class HolderService {

  private final HolderRepository holderRepository;

  public ListResponse<HolderResponse> getAllHolders() {

    List<Holder> all = holderRepository.findAll();
    List<HolderResponse> holderResponses = new ArrayList<>();
    all.forEach(h -> holderResponses.add(new HolderResponse(h)));
    ListResponse<HolderResponse> response = new ListResponse(holderResponses);

    return response;

  }

  public HolderResponse getHolderById(int id) {

    Holder holder = holderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"));

    return new HolderResponse(holder);

  }

}
