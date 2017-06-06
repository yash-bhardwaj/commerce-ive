package com.rccl.cp.ive.update.common;

import com.lightbend.lagom.javadsl.api.deser.ExceptionMessage;
import com.lightbend.lagom.javadsl.api.transport.BadRequest;
import com.lightbend.lagom.javadsl.api.transport.TransportErrorCode;

public interface Constant {

    String HEADER_API_KEY = "api-key";
    
    BadRequest BR_UNAUTHORIZED = new BadRequest(TransportErrorCode.fromHttp(401), new ExceptionMessage("error", "unauthorized request"));

    void constant();
}
