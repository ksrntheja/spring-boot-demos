package io.theja.serviceup.service;

import java.util.List;
import java.util.UUID;

import io.theja.serviceup.dao.RecordEntity;

public interface MyService {

    List<RecordEntity> getAllRecords();

    RecordEntity getRecordById(UUID id);

    RecordEntity createRecord(RecordEntity record);

    RecordEntity createRecordAuto();

    void deleteRecord(UUID id);

}
