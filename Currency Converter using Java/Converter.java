package currencyConverter;

import java.util.ArrayList;

import java.util.HashMap;

public class Currency {

private String name;

private String shortName;

private HashMap<String, Double> exchangeValues = new HashMap<String, Double>();

// “Currency” Constructor

public Currency(String nameValue, String shortNameValue) {

this.name = nameValue;

this.shortName = shortNameValue;

}

// Getter for name

public String getName() {

return this.name;

}

// Setter for name

public void setName(String name) {

this.name = name;

}

// Getter for shortName

public String getShortName() {

return this.shortName;

}

// Setter for shortName

public void setShortName(String shortName) {

this.shortName = shortName;

}

// Getter for exchangeValues

public HashMap<String, Double> getExchangeValues() {

return this.exchangeValues;

}

// Setter for exchangeValues

public void setExchangeValues(String key, Double value) {

this.exchangeValues.put(key, value);

}

// Set default values for a currency

public void defaultValues() {

String currency = this.name;

switch (currency) {

case “US Dollar”:

this.exchangeValues.put(“USD”, 1.00);

this.exchangeValues.put(“EUR”, 0.93);

this.exchangeValues.put(“GBP”, 0.66);

this.exchangeValues.put(“CHF”, 1.01);

this.exchangeValues.put(“CNY”, 6.36);

this.exchangeValues.put(“JPY”, 123.54);

break;

case “Euro”:

this.exchangeValues.put(“USD”, 1.073);

this.exchangeValues.put(“EUR”, 1.00);

this.exchangeValues.put(“GBP”, 0.71);

this.exchangeValues.put(“CHF”, 1.08);

this.exchangeValues.put(“CNY”, 6.83);

this.exchangeValues.put(“JPY”, 132.57);

break;

case “British Pound”:

this.exchangeValues.put(“USD”, 1.51);

this.exchangeValues.put(“EUR”, 1.41);

this.exchangeValues.put(“GBP”, 1.00);

this.exchangeValues.put(“CHF”, 1.52);

this.exchangeValues.put(“CNY”, 9.60);

this.exchangeValues.put(“JPY”, 186.41);

break;

case “Swiss Franc”:

this.exchangeValues.put(“USD”, 0.99);

this.exchangeValues.put(“EUR”, 0.93);

this.exchangeValues.put(“GBP”, 0.66);

this.exchangeValues.put(“CHF”, 1.00);

this.exchangeValues.put(“CNY”, 6.33);

this.exchangeValues.put(“JPY”, 122.84);

break;

case “Chinese Yuan Renminbi”:

this.exchangeValues.put(“USD”, 0.16);

this.exchangeValues.put(“EUR”, 0.15);

this.exchangeValues.put(“GBP”, 0.11);

this.exchangeValues.put(“CHF”, 0.16);

this.exchangeValues.put(“CNY”, 1.00);

this.exchangeValues.put(“JPY”, 19.41);

break;

case “Japanese Yen”:

this.exchangeValues.put(“USD”, 0.008);

this.exchangeValues.put(“EUR”, 0.007);

this.exchangeValues.put(“GBP”, 0.005);

this.exchangeValues.put(“CHF”, 0.008);

this.exchangeValues.put(“CNY”, 0.051);

this.exchangeValues.put(“JPY”, 1.000);

break;

}

}

// Initialize currencies

public static ArrayList<Currency> init() {

ArrayList<Currency> currencies = new ArrayList<Currency>();

currencies.add( new Currency(“US Dollar”, “USD”) );

currencies.add( new Currency(“Euro”, “EUR”) );

currencies.add( new Currency(“British Pound”, “GBP”) );

currencies.add( new Currency(“Swiss Franc”, “CHF”) );

currencies.add( new Currency(“Chinese Yuan Renminbi”, “CNY”) );

currencies.add( new Currency(“Japanese Yen”, “JPY”) );

for (Integer i =0; i < currencies.size(); i++) {

currencies.get(i).defaultValues();

}

return currencies;

}

// Convert a currency to another

public static Double convert(Double amount, Double exchangeValue) {

Double price;

price = amount * exchangeValue;

price = Math.round(price * 100d) / 100d;

return price;

}

}
