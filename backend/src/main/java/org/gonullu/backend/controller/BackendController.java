package org.gonullu.backend.controller;

import org.gonullu.backend.domain.Organization;
import org.gonullu.backend.domain.UserEntity;
import org.gonullu.backend.exception.NotFoundException;
import org.gonullu.backend.exception.OrganizationNotFoundException;
import org.gonullu.backend.repository.OrganizationRepository;
import org.gonullu.backend.repository.UserRepository;
import org.gonullu.backend.ws.model.response.UserRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Gonullu Project Backend!";

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping(path = "/hello")
    public String sayHello() {
        LOG.info("GET called on /hello resource");
        return HELLO_TEXT;
    }
/*
    @RequestMapping(path = "/user/{lastName}/{firstName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser (@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        UserEntity savedUser = userRepository.save(new UserEntity(firstName, lastName));

        LOG.info(savedUser.toString() + " successfully saved into DB");

        return savedUser.getId();
    }*/

/*   @GetMapping(path = "/user/{id}")
    public UserEntity getUserById(@PathVariable("id") long id) {

        return userRepository.findById(id).map(user -> {
            LOG.info("Reading user with id " + id + " from database.");
            return user;
        }).orElseThrow(() -> new NotFoundException("The user with the id " + id + " couldn't be found in the database."));
    }
*/

  /*  @GetMapping(path = "/organization/{id}")
    public Organization getOrganizationById(@PathVariable("id") long id) {

        return organizationRepository.findById(id).map(org -> {
            LOG.info("Reading organization with id " + id + " from database.");
            return org;
        }).orElseThrow(() -> new OrganizationNotFoundException("The organization with the id " + id + " couldn't be found in the database."));
    }
*/



}
