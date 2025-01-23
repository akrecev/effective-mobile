package ru.akrecev.testTask.exception;

public class UnauthorizedException extends ApiException {
    public UnauthorizedException(String message) {
        super(message, "ADMIN_UNAUTHORISED");
    }
}
