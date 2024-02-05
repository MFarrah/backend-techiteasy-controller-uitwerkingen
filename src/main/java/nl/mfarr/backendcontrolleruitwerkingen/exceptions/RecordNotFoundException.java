package nl.mfarr.backendcontrolleruitwerkingen.exceptions;

import nl.mfarr.backendcontrolleruitwerkingen.controllers.ExceptionController;

public class RecordNotFoundException extends ExceptionController {
    public String getMessage() {
        return "Record not found";
    }

}

