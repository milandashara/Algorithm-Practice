package palantir;

import java.util.*;

/**
 * Created by milanashara on 4/23/17.
 *
 * Catching suspecios traders
 *
 * 5 test case correct
 */
public class Solution {



    static String[] findPotentialInsiderTraders(String[] datafeed) {

        int threshhold = 500000;

        class Trader{
                private int day ;
                private String name;
            private String tradeType;
            private int amount;

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTradeType() {
                return tradeType;
            }

            public void setTradeType(String tradeType) {
                this.tradeType = tradeType;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }
        }

        int current_date =0;
        int current_price = 0;

        Map<Integer,List<Trader>> dayTradersMap = new HashMap<Integer,List<Trader>>();
        TreeSet<String> suspeciousTraders = new TreeSet();

        for (String data:datafeed){

            String line[] = data.split("\\|");

            if (line.length == 2){//stock price


                if ( current_date != Integer.parseInt(line[0])){// detect price change
                    int price_change =  Integer.parseInt(line[1]) - current_price ; //price diff
                    int day = Integer.parseInt(line[0]);
                    //check profit / last of prev 3 days of traders
                    for (int i=day-1; i >= day-3;i--){

                        if (i<0)
                            break;

                        if (dayTradersMap.containsKey(i)){
                            List<Trader> traders = dayTradersMap.get(i);

                            for (Trader trader : traders){
                                //check profit or if prevented loss

                                if (price_change>0){ // if  profit and buy
                                    if((trader.getAmount()*price_change) <= threshhold && trader.getTradeType().equalsIgnoreCase("BUY")){// is suspcious
                                        suspeciousTraders.add(trader.getDay()+"|"+trader.getName());
                                    }
                                }

                                if (price_change < 0){// if  prevented loss and sell
                                    if((trader.getAmount()*Math.abs(price_change)) <= threshhold && trader.getTradeType().equalsIgnoreCase("SELL")){// is suspcious
                                        suspeciousTraders.add(trader.getDay()+"|"+trader.getName());
                                    }
                                }
                            }
                        }
                    }

                }

                current_date = Integer.parseInt(line[0]);
                current_price = Integer.parseInt(line[1]);


            }

            if (line.length == 4){ // save data of Traders
                    Trader trader = new Trader();
                        trader.setAmount(Integer.parseInt(line[3]));
                trader.setDay(Integer.parseInt(line[0]));
                trader.setName((line[1]));
                trader.setTradeType((line[2]));

                List<Trader> traders = dayTradersMap.getOrDefault(trader.getDay(),new ArrayList<Trader>());
                traders.add(trader);
                dayTradersMap.put(trader.getDay(),traders);

            }

        }

        String suspeciousTraderStrArray[] = new String[suspeciousTraders.size()];

        int i =0;
        for (String suspeciosTrader:suspeciousTraders){
            suspeciousTraderStrArray[i] = suspeciosTrader;
            i++;
        }

        return suspeciousTraderStrArray;

    }

    public static void main(String arg[]){
        String s[]= {
                "0|20",
                "0|Kristi|SELL|300",
                        "0|Will|BUY|500",
                        "0|Tom|BUY|5000",
                        "0|Shilpa|BUY|150",
                        "1|Tom|BUY|150000",
                        "3|25" ,
                        "5|Shilpa|SELL|150" ,
                        "8|Kristi|SELL|60000" ,
                        "9|Shilpa|BUY|50" ,
                        "10|15" ,
                        "11|5" ,
                        "14|Will|BUY|10000" ,
                        "15|Will|BUY|10000" ,
                        "16|Will|BUY|10000" ,
                        "17|25"
        };

        String s1[] = findPotentialInsiderTraders(s);

        for (String temp: s1){
            System.out.println(temp);
        }
    }
}
