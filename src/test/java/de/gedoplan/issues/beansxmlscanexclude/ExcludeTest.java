package de.gedoplan.issues.beansxmlscanexclude;

import static org.junit.Assert.assertTrue;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExcludeTest {

  protected SeContainer container;

  protected Log log = LogFactory.getLog(getClass());

  @BeforeClass
  public static void initLogging() {
    System.setProperty("java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager");
  }

  @Before
  public void startCdiContainer() {

    this.container = SeContainerInitializer.newInstance().initialize();
    this.log.trace("Container started: " + this.container);
  }

  @After
  public void stopCdiContainer() {
    if (this.container != null) {
      this.log.trace("Container stopping: " + this.container);
      this.container.close();
    }
  }

  @Test
  public void testA() throws Exception {
    assertTrue("BeanA is resolvable", this.container.select(BeanA.class).isResolvable());
  }

  @Test
  public void testB() throws Exception {
    assertTrue("BeanB is unsatisfied", this.container.select(BeanB.class).isUnsatisfied());
  }

  @Test
  public void testC() throws Exception {
    assertTrue("BeanC is resolvable", this.container.select(BeanC.class).isResolvable());
  }

  @Test
  public void testD() throws Exception {
    assertTrue("BeanD is unsatisfied", this.container.select(BeanD.class).isUnsatisfied());
  }

}
