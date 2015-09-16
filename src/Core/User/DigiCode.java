package Core.User;
import Core.network.Signal;

/**
 * Created by SeaDevil on 27.07.2015.
 */
public class DigiCode {
    public Signal DigiDo(char digit, Signal s){
        switch (digit) {
            case '0':return  zero(s);
            case '1':return  one(s);
            case '2':return  two(s);
            case '3':return  three(s);
            case '4':return  four(s);
            case '5':return  five(s);
            case '6':return  six(s);
            case '7':return  seven(s);
            case '8':return  eight(s);
            case '9':return  nine(s);
            default: return  s;
        }
    }

    public Signal zero (Signal s) {
        return s;
    }
    public Signal one (Signal s) {
        return s;
    }
    public Signal two (Signal s) {
        return s;
    }
    public Signal three (Signal s) {
        return s;
    }
    public Signal four (Signal s) {
        return s;
    }
    public Signal five (Signal s) {
        return s;
    }
    public Signal six (Signal s) {
        return s;
    }
    public Signal seven (Signal s) {
        return s;
    }
    public Signal eight (Signal s) {
        return s;
    }
    public Signal nine (Signal s) {
        return s;
    }
}
