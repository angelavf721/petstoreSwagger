package test.pet.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.pet.controller.PetController;
import test.pet.model.PetModel;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PetController.class
})
public class PetRunner {
}
