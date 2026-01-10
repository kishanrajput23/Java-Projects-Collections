async function getData(stockSymbol, limit){
    if(!stockSymbol){
        alert('Please enter in a value');
        return;
    }
    
    var flag = true;
    if(!limit){
        flag = false;
    }
    var rawData = await (await window.fetch('https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&outputsize=full&symbol='+encodeURIComponent(stockSymbol)+'&apikey=VFKNX13I1KQF3WRZ')).json();
    
    var errMsg = rawData['Error Message'];
    if(errMsg){
        if(errMsg.includes('Invalid API call')){
            alert('Stock symbol not found');
        }else if(errMsg.includes('if you would like to target a higher API call frequency')){
            alert('Oops, looks like you spammed too much. Wait a couple minutes before trying again');
        }else{
            alert('Weird error from alpha vantage:'+errMsg);
        }
        return;
    }
    
    var labels = [];
    var prices = [];
    var count = 0;
    for(var label in rawData['Time Series (Daily)']){
        if(flag && count >= limit) break;
        labels.push(label);
        prices.push(parseFloat(rawData['Time Series (Daily)'][label]['4. close']));
        count++;
    }
    return [labels.reverse(), prices.reverse()];
}