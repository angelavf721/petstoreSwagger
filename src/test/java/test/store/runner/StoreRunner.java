package test.store.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import test.pet.controller.PetController;
import test.store.controller.StoreController;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    StoreController.class
})
public class StoreRunner {
}
