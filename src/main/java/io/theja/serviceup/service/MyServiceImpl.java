package io.theja.serviceup.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.theja.serviceup.dao.MyRepository;
import io.theja.serviceup.dao.RecordEntity;

@Service
class MyServiceImpl implements MyService {

    private final MyRepository myRepository;

    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public RecordEntity createRecordAuto() {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setTime(LocalDateTime.now());
        myRepository.save(recordEntity);
        return recordEntity;
    }

    @Override
    public List<RecordEntity> getAllRecords() {
        return myRepository.findAll();
    }

    @Override
    public RecordEntity getRecordById(UUID id) {
        return myRepository.findById(id).orElse(null);
    }

    @Override
    public RecordEntity createRecord(RecordEntity record) {
        return myRepository.save(record);
    }

    @Override
    public void deleteRecord(UUID id) {
        myRepository.deleteById(id);
    }

}
