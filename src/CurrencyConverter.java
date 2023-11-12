import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;


public class CurrencyConverter {

    private  static void sendHttpGETRequest(String from_Curr,String to_Curr,double amount) throws IOException {


        //calling frankfurter API
        String GET_URL = "https://api.frankfurter.app/latest?to="+to_Curr+","+from_Curr;
        URL url=new URL(GET_URL);
        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responsecode=httpURLConnection.getResponseCode();

        if(responsecode==HttpURLConnection.HTTP_OK){
            BufferedReader in=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response=new StringBuffer();

            while((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }in.close();
            JSONObject obj=new JSONObject(response.toString());
            double exchangeRate = obj.getJSONObject("rates").getDouble(to_Curr);

            System.out.println(obj.getJSONObject("rates"));//
            System.out.println(exchangeRate);
            System.out.println(amount+from_Curr+"="+amount*exchangeRate + to_Curr);
        }
        else{
            System.out.println("Get request failed");
        }
    }
    public static void main(String[] args) throws IOException {

        String from_Curr,to_Curr;
        double amount;

        //hashmap for codes for currencies
        HashMap<Integer,String> CurrencyCodes=new HashMap<Integer,String>();

        //adding currency codes
        CurrencyCodes.put(1,"USD");
        CurrencyCodes.put(2,"INR");
        CurrencyCodes.put(3,"EUR");
        CurrencyCodes.put(4,"CAD");
        CurrencyCodes.put(5,"HKD");

        Scanner sc=new Scanner(System.in);

        //taking input for original currency
        System.out.println("Which currency you want to convert from ? ");
        System.out.println("1:USD(American dollar) \t 2:INR(Indian rupee) \t 3:EUR(Euro) \t 4:CAD(Canadian dollar) \t 5:HKD(Hong kong dollar)");
        from_Curr=CurrencyCodes.get(sc.nextInt());

        //taking input for converted currency
        System.out.println("Which currency you want to convert to ? ");
        System.out.println("1:USD(American dollar) \t 2:INR(Indian rupee) \t 3:EUR(Euro) \t 4:CAD(Canadian dollar) \t 5:HKD(Hong kong dollar)");
        to_Curr=CurrencyCodes.get(sc.nextInt());


        System.out.println("Enter the amount you want to convert : ");
        amount=sc.nextFloat();

        sendHttpGETRequest(from_Curr,to_Curr,amount);

    }

}
