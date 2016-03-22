package com.example.test.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
  @Override
  public String getModuleName() {
    return "com.example.test.Project";
  }

  public void testSandbox() {
    assertTrue(true);
  }
  
}
