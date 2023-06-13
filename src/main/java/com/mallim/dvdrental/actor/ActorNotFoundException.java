package com.mallim.dvdrental.actor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActorNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 8732907115274367029L;

    public ActorNotFoundException(final Integer actorId) {
        super("Could not find actor with id '" + actorId + "'.");
    }
}
