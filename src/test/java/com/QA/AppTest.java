package com.QA;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppTest
{
    App app;

    @Test
    public void mainAppTest()
    {
        app = new App();
        app.main(new String[]{});
        assertTrue( true );
    }

    private void assertTrue(boolean b) {
    }
}
