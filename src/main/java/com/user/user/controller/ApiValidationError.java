package com.user.user.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
abstract class ApiSubError {

}

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiValidationError extends ApiSubError {


private String object2;
private String field2;
private Object rejectedValue2;
private String message2;


public String getObject2() {
return object2;
}
public void setObject2(String object2) {
this.object2 = object2;
}
public String getField2() {
return field2;
}
public void setField2(String field2) {
this.field2 = field2;
}
public Object getRejectedValue2() {
return rejectedValue2;
}
public void setRejectedValue2(Object rejectedValue2) {
this.rejectedValue2 = rejectedValue2;
}
public String getMessage2() {
return message2;
}
public void setMessage2(String message2) {
this.message2 = message2;
}



/*
* ApiValidationError(String object, String message) { this.object = object;
* this.message = message; }
*/
ApiValidationError(String object2, String field2, Object rejectedValue2, String message2) {
// TODO Auto-generated constructor stub
this.object2=object2;
this.field2=field2;
this.rejectedValue2=rejectedValue2;
this.message2=message2;
}
}



class ApiError {



private HttpStatus status;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
private LocalDateTime timestamp;
private String message;
private String debugMessage;
private List<ApiSubError> subErrors;
public HttpStatus getStatus() {
return status;
}



public void setStatus(HttpStatus status) {
this.status = status;
}



public LocalDateTime getTimestamp() {
return timestamp;
}



public void setTimestamp(LocalDateTime timestamp) {
this.timestamp = timestamp;
}



public String getMessage() {
return message;
}



public void setMessage(String message) {
this.message = message;
}



public String getDebugMessage() {
return debugMessage;
}



public void setDebugMessage(String debugMessage) {
this.debugMessage = debugMessage;
}



public List<ApiSubError> getSubErrors() {
return subErrors;
}



public void setSubErrors(List<ApiSubError> subErrors) {
this.subErrors = subErrors;
}



private ApiError() {
timestamp = LocalDateTime.now();
}



public ApiError(HttpStatus status) {
this();
this.status = status;
}



public ApiError(HttpStatus status, Throwable ex) {
this();
this.status = status;
this.message = "Unexpected error";
this.debugMessage = ex.getLocalizedMessage();
}



public ApiError(HttpStatus status, String message, Throwable ex) {
this();
this.status = status;
this.message = message;
this.debugMessage = ex.getLocalizedMessage();
}



private void addSubError(ApiSubError subError) {
if (subErrors == null) {
subErrors = new ArrayList<>();
}
subErrors.add(subError);
}



private void addValidationError(String object, String field, Object rejectedValue, String message) {
addSubError(new ApiValidationError(object, field, rejectedValue, message));
}



/*
* private void addValidationError(String object, String message) {
* addSubError(new ApiValidationError(object, message)); }
*/



private void addValidationError(FieldError fieldError) {
this.addValidationError(
fieldError.getObjectName(),
fieldError.getField(),
fieldError.getRejectedValue(),
fieldError.getDefaultMessage());
}



public void addValidationErrors(List<FieldError> fieldErrors) {
fieldErrors.forEach(this::addValidationError);
}



private void addValidationError(ObjectError objectError) {
/*
* this.addValidationError( objectError.getObjectName(),
* objectError.getDefaultMessage());
*/
}



public void addValidationError(List<ObjectError> globalErrors) {
globalErrors.forEach(this::addValidationError);
}



/**
* Utility method for adding error of ConstraintViolation. Usually when a @Validated validation fails.
*
* @param cv the ConstraintViolation
*/
private void addValidationError(ConstraintViolation<?> cv) {
this.addValidationError(
cv.getRootBeanClass().getSimpleName(),
((PathImpl) cv.getPropertyPath()).getLeafNode().asString(),
cv.getInvalidValue(),
cv.getMessage());
}



public void addValidationErrors(Set<ConstraintViolation<?>> constraintViolations) {
constraintViolations.forEach(this::addValidationError);
}
}