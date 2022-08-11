package fpt.aptech.apicrud.api;

import fpt.aptech.apicrud.entity.TblClass;
import fpt.aptech.apicrud.service.TblClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/rooms")
@RequiredArgsConstructor
public class TblClassRestApi {
    final TblClassService tblClassService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(tblClassService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Optional<TblClass> tblClassOptional = tblClassService.findById(id);
        if(!tblClassOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Class doesn't not exist");
        }
        return ResponseEntity.ok(tblClassOptional.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody TblClass tblClass) {
        return ResponseEntity.ok(tblClassService.save(tblClass));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody TblClass tblClass) {
        TblClass tblClass1 = tblClassService.update(id, tblClass);
        if(tblClass == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tblClassService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        if(tblClassService.delete(id)) {
            return ResponseEntity.ok().body("Delete successfully !");
        }
        return ResponseEntity.badRequest().body("Delete failed !");
    }
}
