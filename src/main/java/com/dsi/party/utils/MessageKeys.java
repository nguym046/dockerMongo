package com.dsi.party.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nguym046 on 10/31/16.
 */
public class MessageKeys {

    public static final String _ERROR_MISSING_REQUIRED_PARAM = "_ERROR_MISSING_REQUIRED_PARAM";
    public static final String _ERROR_INVAlID_VALUES_PARAM = "_ERROR_INVALID_VALUES_PARAM";
    public static final String _ERR_BAD_WORD = "_ERR_BAD_WORD";
    public static final String _ERROR_INVALID_COMMERCE_ID = "_ERROR_INVALID_COMMERCE_ID";
    public static final String _ERROR_PROVIDER_HOST_CONNECTIVITY = "_ERROR_PROVIDER_HOST_CONNECTIVITY";
    public static final String _ERROR_GENERIC = "_ERROR_GENERIC";
    public static final String _ERROR_MISSING_REQUIRED_HEADER = "_ERROR_MISSING_REQUIRED_HEADER";

    public static final Map<String,String> ERRS_TO_HTTPSTATUS=  new HashMap<String, String>();

    static {
        ERRS_TO_HTTPSTATUS.put(_ERR_BAD_WORD, "BAD_REQUEST");
        ERRS_TO_HTTPSTATUS.put(_ERROR_MISSING_REQUIRED_PARAM, "BAD_REQUEST");
        ERRS_TO_HTTPSTATUS.put(_ERROR_INVAlID_VALUES_PARAM, "BAD_REQUEST");
        ERRS_TO_HTTPSTATUS.put(_ERROR_INVALID_COMMERCE_ID, "INTERNAL_SERVER_ERROR");
    }



}