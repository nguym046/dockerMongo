package com.dsi.party.exceptions;

import java.util.ArrayList;
import java.util.List;

import com.disneystore.api.v30.services.schema.model.Error;
import com.disneystore.api.v30.services.schema.model.Fault;

public class FaultException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1694059962086074540L;
    private Fault fault;

    public FaultException(String msg) {
        super(msg);
    }

    public FaultException(Fault fault) {
        this.fault = fault;
    }

    public Fault getFault() {
        return this.fault;
    }

    public FaultException(String errorCode, String errorKey, String errorMessage) {
        Error error = new Error();
        error.setErrorCode(errorCode);
        error.setErrorKey(errorKey);
        error.setErrorMessage(errorMessage);
        Fault newFault = new Fault();
        List<Error> errorList = new ArrayList<Error>();
        errorList.add(error);
        newFault.setErrors(errorList);
        newFault.setHasFault(true);
        this.fault = newFault;
    }
}
