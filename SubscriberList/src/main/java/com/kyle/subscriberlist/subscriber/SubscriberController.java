package com.kyle.subscriberlist.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller	//marks this as the controller
public class SubscriberController {
	
	//puts place in controller to store crud repository?
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping(value = "/")	//used for our index method, which will return the template specified
	public String index(Subscriber subscriber) {
		return "subscriber/index";	//makes a call to an "index" html in the "subscriber" folder
	}

	private Subscriber subscriber;
	@PostMapping(value = "/")
	public String addNewSubscriber(Subscriber subscriber, Model model) {
		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
	    subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
		model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("userName", subscriber.getUserName());
		return "subscriber/result"; //when new subscriber is added, show subscriber/result rather than index.html
	}


}
