package write.literal.number;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Translate 
{
	Map <Integer, String> centenas = new HashMap<Integer, String>();
	Map <Integer, String> dezenas = new HashMap<Integer, String>();
	Map <Integer, String> unidades = new HashMap<Integer, String>();
	
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
    
    public String translate(Double value){
    	StringBuilder result = new StringBuilder();
    	Double mapValue;
    	if (value / 100 > 10 || value < 0){
    		return "Valor Inválido";
    	}
    	else if (value / 100 >= 1){
    		mapValue = value /100;
    		result.append(centenas.get(mapValue.intValue()));
    		value = value%100;
    	}
    	if (value / 10 >= 1){
    		mapValue = value/10;
    		if (result.length() == 0){
    			result.append(dezenas.get(mapValue.intValue()));
    		}
    		else{
    			result.append(" e " + dezenas.get(mapValue.intValue()).toLowerCase());
    		}
    		value = value%10;
    	}
    	if (value > 0){
    		if (result.length() == 0){
    			result.append(unidades.get(value.intValue()));
    		}
    		else{
    			result.append(" e " + unidades.get(value.intValue()).toLowerCase());
    		}
    	}
    	return result.append(" reais").toString();
    }
}
