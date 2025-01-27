package org.acme.getting.started;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;
import javax.inject.Inject;

@QuarkusMain
public class GreetingApplication implements QuarkusApplication {
    public static final Logger LOGGER = Logger.getLogger(GreetingApplication.class);

    @Inject
    GreetingService greetingService;

    @Override
    public int run(String... args) throws Exception {
        if (args[0].equals("--help")) {
            LOGGER.info(
                    "\nThis tool helps greet users by their name\n" +
                    "Available commands:\n" +
                    "\t--help\t\t\tShow helpful message\n" +
                    "\t--greet={name}\t\tGreet person by their name"
            );
            return 0;
        }
        if (args[0].startsWith("--greet")) {
            String name = args[0].substring(8);
            LOGGER.info(greetingService.greeting(name));
        } // ... more else if cases for diferent commands
        return 0;
    }
}