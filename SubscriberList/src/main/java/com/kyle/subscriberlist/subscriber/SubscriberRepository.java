package com.kyle.subscriberlist.subscriber;

import org.springframework.data.repository.CrudRepository;

//describes HOW subscribers will be entered into the database
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

}