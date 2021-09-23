package main.controller;

import lombok.RequiredArgsConstructor;
import main.model.dto.response.HolderResponse;
import main.model.dto.response.ListResponse;
import main.service.HolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holder")
@RequiredArgsConstructor
public class HolderController {

  private final HolderService holderService;

  @GetMapping
  public ResponseEntity<ListResponse<HolderResponse>> getHolders() {

    return ResponseEntity.ok(holderService.getAllHolders());

  }

  @GetMapping("/{id}")
  public ResponseEntity<HolderResponse> getHolderById(@PathVariable int id) {

    return ResponseEntity.ok(holderService.getHolderById(id));

  }

}
