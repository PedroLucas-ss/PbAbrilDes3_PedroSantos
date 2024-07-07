package org.pl.mspayment.dto.mapper;

import org.pl.mspayment.entities.CalculateTotalDto;
import org.pl.mspayment.entities.Payment;

public class PaymentToCalculateMapper {

    public static CalculateTotalDto calculatePayment(Payment paymentcalc){
        CalculateTotalDto calc = new CalculateTotalDto();
        calc.setCategoryId(paymentcalc.getCategory_id());
        calc.setValue(paymentcalc.getTotal());
        return calc;
    }


}
