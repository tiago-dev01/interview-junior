package br.com.brainweb.interview.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HeroNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6568441337405429719L;
	
    public HeroNotFoundException() {
        super();
    }
    public HeroNotFoundException(String s) {
        super(s);
    }
    public HeroNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public HeroNotFoundException(Throwable throwable) {
        super(throwable);
    }

}
