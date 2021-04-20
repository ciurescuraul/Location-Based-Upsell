package ro.proiect.licenta.rau.lbu.fileprocessor.service.db.repository;

import org.springframework.data.repository.CrudRepository;

import ro.proiect.licenta.rau.lbu.fileprocessor.service.db.entity.LbuInterestArea;

public interface LbuInterestAreaRepo extends
                                     CrudRepository<LbuInterestArea, Integer>
{
}
