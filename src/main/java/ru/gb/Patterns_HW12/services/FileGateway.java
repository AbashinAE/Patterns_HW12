package ru.gb.Patterns_HW12.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInputChannel")
public interface FileGateway {
    void writeFile(@Header(FileHeaders.FILENAME) String filename, String data);
}