package ru.otus.springconfiguration.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springconfiguration.domain.User;
import ru.otus.springconfiguration.service.IOService;
import ru.otus.springconfiguration.service.UserService;
import ru.otus.springconfiguration.utils.Message;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final IOService ioService;

    @Override
    public User getUser() {
        ioService.output(Message.MSG_INTRODUCE);
        var firstName = ioService.readLn(Message.MSG_ENTER_FIRST_NAME);
        var lastName = ioService.readLn(Message.MSG_ENTER_LAST_NAME);
        return new User(firstName, lastName);
    }
}
