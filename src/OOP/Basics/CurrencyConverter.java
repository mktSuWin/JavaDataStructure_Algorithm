package OOP.Basics;
// static is global , therefore, it is accessible from both static and instant methods
// However, instant variables, methods can not be accessed by static method.
class CurrencyConverter {
    // Currency exchange rates of different currencies relative to 1 $US.
    double[] exchangeRates;

    void setExchangeRates(double[] rates){
        exchangeRates = rates;
    }

    void updateExchangeRates(int arrayIndex, double newValue){
        exchangeRates[arrayIndex] = newValue;
    }

    double getExchangeRate(int arrayIndex){
        return exchangeRates[arrayIndex];
    }

    double computeTransferAmount(int arrayIndex, double amount){
        return amount * getExchangeRate(arrayIndex);
    }

    String[] currencyNames = new String[]{"Rupee", "Dirham" , "Real" , "Chilean", "Mexico", "Yen" , "$Australian"};
    void printCurrencies(){
        for(int i = 0; i < exchangeRates.length; i++){
            System.out.println( currencyNames[i] + "\t : " + exchangeRates[i]);
        }
    }



    public static void main(String[] args) {
        CurrencyConverter cc = new CurrencyConverter();
        double[] rates = {63.0, 3.0, 3.0, 595, 18.0, 107.0, 2.9};
        cc.setExchangeRates(rates);
//        cc.printCurrencies();

//        rates = new double[] {63.0, 32.0, 30.0, 55, 1800.0, 107.0, 2.9};
//        cc.setExchangeRates(rates);
//        cc.printCurrencies();

        cc.updateExchangeRates(0, 69);
//        cc.printCurrencies();

        double amount = cc.computeTransferAmount(0, 100);
        System.out.println(amount);
    }
}
