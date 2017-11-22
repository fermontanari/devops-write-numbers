package write.literal.number;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        assertThat( t.translate(new BigDecimal(42.00)), equalTo("Quarenta e dois reais") );
    }
    
    public void testBaseTwoNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(10.00)), equalTo("Dez reais") );
    }
    
    public void testBaseThreeNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(100.00)), equalTo("Cem reais") );
    }
    
    public void testExceptionTwoNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(12.00)), equalTo("Doze reais") );
    }
    
    public void testThreeNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(678.00)), equalTo("Seiscentos e setenta e oito reais") );
    }
    
    public void testNegativeNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(-21.00)), equalTo("Valor Inválido") );
    }
    
    public void testBiggerNumbersTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(1456.00)), equalTo("Valor Inválido") );
    }
    
    public void testCentsTranslation()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(21.34)), equalTo("Vinte e um reais e trinta e quatro centavos") );
    }
    
    public void testCentsTranslationWithBiggerDecimalPlaces()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(21.123)), equalTo("Vinte e um reais e doze centavos") );
    }
    
    public void testCentsTranslationWithOneDecimalPlace()
    {
    	Translate t = new Translate();
        assertThat( t.translate(new BigDecimal(21.1)), equalTo("Vinte e um reais e dez centavos") );
    }
}
