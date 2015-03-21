package org.reqlist.arch.exception;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
public class Error {
    private final ErrorLevel level;
    private final String message;
    private final String[] args;

    public Error(ErrorLevel level, String message, String... args) {
        this.level = level;
        this.message = message;
        this.args = args;
    }

    public ErrorLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String[] getArgs() {
        return args;
    }
}
