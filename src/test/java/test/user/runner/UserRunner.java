package test.user.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.user.controller.UserController;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserController.class
})public class UserRunner {
}
