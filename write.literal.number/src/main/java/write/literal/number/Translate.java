package write.literal.number;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Translate 
{
	private Map <Integer, String> centenas = new HashMap<Integer, String>();
	private Map <Integer, String> dezenas = new HashMap<Integer, String>();
	private Map <Integer, String> unidades = new HashMap<Integer, String>();
	private BigDecimal decimalValue;
	
	Translate(){
		centenas.put(1, "Cem");
		centenas.put(2, "Duzentos");
		centenas.put(3, "Tresentos");
		centenas.put(4, "Quatrocentos");
		centenas.put(5, "Quinhentos");
		centenas.put(6, "Seiscentos");
		centenas.put(7, "Setecentos");
		centenas.put(8, "Oitocentos");
		centenas.put(9, "Novecentos");

		dezenas.put(1, "Dez");
		dezenas.put(2, "Vinte");
		dezenas.put(3, "Trinta");
		dezenas.put(4, "Quarenta");
		dezenas.put(5, "Cinquenta");
		dezenas.put(6, "Sessenta");
		dezenas.put(7, "Setenta");
		dezenas.put(8, "Oitenta");
		dezenas.put(9, "Noventa");
		dezenas.put(11, "Onze");
		dezenas.put(12, "Doze");

		unidades.put(1, "Um");
		unidades.put(2, "Dois");
		unidades.put(3, "Tres");
		unidades.put(4, "Quatro");
		unidades.put(5, "Cinco");
		unidades.put(6, "Seis");
		unidades.put(7, "Sete");
		unidades.put(8, "Oito");
		unidades.put(9, "Nove");
	}
    
    public String translate(BigDecimal value){
    	StringBuilder result = new StringBuilder();
    	decimalValue = value;
    	if ( (decimalValue.divide(new BigDecimal(100)).compareTo(BigDecimal.valueOf(10)) > 0) || decimalValue.compareTo(BigDecimal.ZERO) < 0){
    		return new StringBuilder("Valor Inválido").toString();
    	}
    	else {
	    	translateReais(result);
	    	translateCents(result);
    	}
    	
    	return result.toString();
    }

	private StringBuilder translateReais(StringBuilder result) {
		if (decimalValue.divide(new BigDecimal(100)).compareTo(BigDecimal.ONE) >= 0){
			calculateCurrentValue(result, centenas.get(decimalValue.divide(new BigDecimal(100)).intValue()), 100);
    	}
		if (decimalValue.intValue() == 11){
			calculateCurrentValue(result, dezenas.get(decimalValue.intValue()), 11);
		}
		if (decimalValue.intValue() == 12){
			calculateCurrentValue(result, dezenas.get(decimalValue.intValue()), 12);
		}
    	if (decimalValue.divide(new BigDecimal(10)).compareTo(BigDecimal.ONE) >= 0){
    		calculateCurrentValue(result, dezenas.get(decimalValue.divide(new BigDecimal(10)).intValue()), 10);
    	}
    	if (decimalValue.compareTo(BigDecimal.ZERO) > 0){
    		calculateCurrentValue(result, unidades.get(decimalValue.intValue()), 1);
    		
    		decimalValue = decimalValue.subtract(new BigDecimal(decimalValue.intValue()));
    	}
    	return result.append(" reais");
	}
	
	private StringBuilder translateCents(StringBuilder result) {
		decimalValue = decimalValue.multiply(new BigDecimal(100));
		if (decimalValue.compareTo(BigDecimal.ZERO) > 0){
			if (decimalValue.intValue() == 11){
				calculateCurrentValue(result, dezenas.get(decimalValue.intValue()), 11);
			}
			if (decimalValue.intValue() == 12){
				calculateCurrentValue(result, dezenas.get(decimalValue.intValue()), 12);
			}
			if (decimalValue.divide(new BigDecimal(10)).compareTo(BigDecimal.ONE) >= 0){
	    		calculateCurrentValue(result, dezenas.get(decimalValue.divide(new BigDecimal(10)).intValue()), 10);
	    	}
	    	if (decimalValue.compareTo(BigDecimal.ZERO) > 0){
	    		calculateCurrentValue(result, unidades.get(decimalValue.intValue()), 1);
	    		decimalValue = decimalValue.subtract(new BigDecimal(decimalValue.intValue()));
	    	}
	    	result.append(" centavos");
		}
    	return result;
	}

	private void calculateCurrentValue(StringBuilder result, String correspondingValue, int unit) {
		if (result.length() == 0){
			result.append(correspondingValue);
		}
		else{
			result.append(" e " + correspondingValue.toLowerCase());
		}
		decimalValue = decimalValue.remainder(new BigDecimal(unit)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
