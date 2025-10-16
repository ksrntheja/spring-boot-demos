package io.theja.serviceup.contoller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.theja.serviceup.dao.RecordEntity;
import io.theja.serviceup.service.MyService;

@RestController
@RequestMapping("/api/records")
public class MyRestController {

    private MyService myService;

    public MyRestController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public List<RecordEntity> getAllRecords() {
        return myService.getAllRecords();
    }

    @GetMapping("/{id}")
    public RecordEntity getRecordById(@PathVariable UUID id) {
        return myService.getRecordById(id);
    }

    @PostMapping
    public RecordEntity createRecord(@RequestBody RecordEntity record) {
        return myService.createRecord(record);
    }

    @PostMapping("/auto")
    public RecordEntity createRecordAuto() {
        return myService.createRecordAuto();
    }

    @DeleteMapping("/{id}")
    public void deleteRecord(@PathVariable UUID id) {
        myService.deleteRecord(id);
    }

}
