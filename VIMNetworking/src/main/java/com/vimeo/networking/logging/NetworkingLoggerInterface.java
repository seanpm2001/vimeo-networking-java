package com.vimeo.networking.logging;

/**
 * Created by kylevenn on 10/9/15.
 */
public interface NetworkingLoggerInterface {

    void e(String error);

    void e(String error, Exception exception);

    void i(String info);
}
