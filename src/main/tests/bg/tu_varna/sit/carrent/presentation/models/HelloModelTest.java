package bg.tu_varna.sit.carrent.presentation.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloModelTest {

    private HelloModel helloModel;
    @BeforeEach
    void setUp() {
        helloModel=new HelloModel();
    }

    @Test
    void getWelcomeMassage(){
        assertEquals(" Hello SIT I am Java FX Project",helloModel.getWelcomeMessage());
    }
}