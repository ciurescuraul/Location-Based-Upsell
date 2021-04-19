package ro.proiect.licenta.rau.lbufileprocessor.service.db.repository;

import org.springframework.data.repository.CrudRepository;

import ro.proiect.licenta.rau.lbufileprocessor.service.db.entity.LbuInterestArea;

public interface LbuInterestAreaRepo extends
                                     CrudRepository<LbuInterestArea, Integer>
{
}
