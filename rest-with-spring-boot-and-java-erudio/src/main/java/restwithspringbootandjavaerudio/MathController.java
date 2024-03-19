package restwithspringbootandjavaerudio;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong(); //papel desse cara é mocar um id

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method= RequestMethod.GET) //recuperar dados da URL
    public Double sum(
            // essa anotação permite que o controler lide com as requisições de urls parametrizadas
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
            )throws Exception{
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new Exception();
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    private Double convertToDouble(String strNumber){
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }
    private boolean isNumeric(String strNumber){
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
