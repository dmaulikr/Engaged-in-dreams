package Core.network;


/**
 * Created by SeaDevil on 27.07.2015.
 */

public class Handler {                  //Need to finish hendler

    public void handle (Signal S, NetworkMap NM) {

    }

    public void handleWay (Signal S, NetworkMap NM) {

    }

}

//public class Handler {                  //Need to finish hendler
//    Signal signal;
//    NetworkMap networkMap;
//    private Signal process (Signal S,NetworkMap NM,DigiCode DC){
//        Signal newS = DC.DigitDo(NM.getNeuron(S.x, S.y), S);
//        handle(newS,NM);               //Broken Java is better then the catch@ Be cerfull this functions can create singularity))
//        return newS;
//    }
//
//    public void handle (Signal S,NetworkMap NM) {
//        networkMap = NM;
//        signal = S;
//        DigiCode DC = new DigiCode();
//        SignalRules SR = new SignalRules();
//        while (!SR.stopEvent(signal)) {
//            signal = process(signal,NM,DC);
//        }
//    }
//}