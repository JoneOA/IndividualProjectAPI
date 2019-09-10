package com.QA;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AppTest 
{
    App app;

    @Test
    public void shouldAnswerWithTrue() {
        app = new App();
        app.main(new String[]{});
        assertTrue(true);
    }
}
