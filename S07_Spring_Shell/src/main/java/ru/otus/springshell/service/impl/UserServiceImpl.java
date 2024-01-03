package ru.otus.springshell.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.springshell.domain.User;
import ru.otus.springshell.service.IOService;
import ru.otus.springshell.service.LocalizationMessageService;
import ru.otus.springshell.service.UserService;
import ru.otus.springshell.validator.LettersOnlyValidator;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final IOService ioService;

    private final LocalizationMessageService messageService;

    private final LettersOnlyValidator validator;

    @Override
    public User getUser() {
        ioService.output(messageService.getLocalizedMessage("message.introduce"));

        String firstName;
        String lastName;

        do {
            firstName = ioService.readLn(messageService.getLocalizedMessage("message.enter.first.name"));
            if (validator.validate(firstName)) {
                ioService.output(messageService.getLocalizedMessage(validator.errorMessage()));
            }
        } while (validator.validate(firstName));

        do {
            lastName = ioService.readLn(messageService.getLocalizedMessage("message.enter.last.name"));
            if (validator.validate(lastName)) {
                ioService.output(messageService.getLocalizedMessage(validator.errorMessage()));
            }
        } while (validator.validate(lastName));

        return new User(firstName, lastName);
    }
}
