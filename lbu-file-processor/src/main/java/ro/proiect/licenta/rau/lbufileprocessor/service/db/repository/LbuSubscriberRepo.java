package ro.proiect.licenta.rau.lbufileprocessor.service.db.repository;

import org.springframework.data.repository.CrudRepository;

import ro.proiect.licenta.rau.lbufileprocessor.service.db.entity.LbuSubscriber;

public interface LbuSubscriberRepo extends
                                   CrudRepository<LbuSubscriber, Integer>
{
}
