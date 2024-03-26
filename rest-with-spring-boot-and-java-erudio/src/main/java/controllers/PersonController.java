package controllers;

import converters.numberConverter;
import exceptions.UnsupporteMathOperationException;
import math.simpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    private simpleMath math = new simpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
            )throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupporteMathOperationException("Por favor defina um valor numerico");
        }
        return math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    )throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupporteMathOperationException("Por favor defina um valor numerico");
        }
        return math.sub(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    )throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupporteMathOperationException("Por favor defina um valor numerico");
        }
        return math.mult(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));    }
    @RequestMapping(value = "/div/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    )throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupporteMathOperationException("Por favor defina um valor numerico");
        }
        return math.div(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));    }
    @RequestMapping(value = "/med/{numberOne}/{numberTwo}",
            method= RequestMethod.GET)
    public Double med(
            @PathVariable(value = "numberOne")String numberOne,
            @PathVariable(value = "numberTwo")String numberTwo
    )throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupporteMathOperationException("Por favor defina um valor numerico");
        }
        return math.med(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));    }
    @RequestMapping(value = "/raiz/{number}",
            method= RequestMethod.GET)
    public Double raiz(
            @PathVariable(value = "number")String number
    )throws Exception{
        if(!numberConverter.isNumeric(number)) {
            throw new UnsupporteMathOperationException("Por favor defina um valor numerico");
        }
        return Math.sqrt(numberConverter.convertToDouble(number));
    }

}
