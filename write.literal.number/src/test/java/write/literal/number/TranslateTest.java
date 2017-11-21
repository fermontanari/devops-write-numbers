package write.literal.number;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class TranslateTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TranslateTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TranslateTest.class );
    }
    
    public void testTwoNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(42.00), equalTo("Quarenta e dois reais") );
    }
    
    public void testThreeNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(678.00), equalTo("Seiscentos e setenta e oito reais") );
    }
    
    public void testNegativeNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(-21.00), equalTo("Valor Inválido") );
    }
    
    public void testBiggerNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(1456.00), equalTo("Valor Inválido") );
    }
}
