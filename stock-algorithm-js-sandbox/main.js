async function getDataClick(...args){
    var stockData = await getData(...args);
    if(stockData){
        window.labels = stockData[0];
        window.stockPrices = stockData[1];
        generateChart(document.getElementById('chart'), window.labels, window.stockPrices, [], []);
    }
}
function run(){
    if(!window.stockPrices){
        alert('That chart to the left is just for show. Now get some data!');
        return;
    }
    
    var userProgram = window.editor.session.getValue();
    try{
        eval(userProgram);
    }catch(e){
        console.error(e);
        alert('An error occurred while running your script. Check the console for more details.\n'+e);
        return;
    }
    if(!this.previousDataAmt){
        this.previousDataAmt = 10;
    }
    if(this.previousDataAmt >= window.stockPrices.length){
        alert('previousDataAmt is greater or equal to the amount of stock prices. Adjust to a lower value');
        return;
    }
    
    var wallet = 0;
    var buyDecisionCount = 0;
    var sellDecisionCount = 0;
    var numberOfCheatingSells = 0;
    var stocks = 0;
    
    var buyPosition = [];
    var sellPosition = [];
    for(var count = this.previousDataAmt; count < window.stockPrices.length; count++){
        try{
            var result = this.main(window.stockPrices.slice(count-this.previousDataAmt, count), stocks);
            if(result === true){
                buyDecisionCount += 1;
                stocks += 1;
                wallet -= window.stockPrices[count];
                
                buyPosition.push(window.labels[count]);
            }else if(result === false){
                if(stocks <= 0){
                    numberOfCheatingSells += 1;
                }else{
                    sellDecisionCount += 1;
                    stocks -= 1;
                    wallet += window.stockPrices[count];
                    
                    sellPosition.push(window.labels[count]);
                }
            }else if(result === undefined){
                // Do nothing
            }else{
                alert('Your main function returned something other than a boolean or "undefined"!');
                return;
            }
        }catch(e){
            console.error(e);
            alert('An error occurred while running your script. Check the console for more details.\n'+e);
            return;
        }
    }
    
    generateChart(document.getElementById('chart'), window.labels, window.stockPrices, buyPosition, sellPosition);
    
    document.getElementsByClassName('info-after')[0].innerHTML = wallet.toFixed(2);
    document.getElementsByClassName('info-after')[1].innerHTML = buyDecisionCount;
    document.getElementsByClassName('info-after')[2].innerHTML = sellDecisionCount;
    document.getElementsByClassName('info-after')[3].innerHTML = numberOfCheatingSells;
    document.getElementsByClassName('info-after')[4].innerHTML = stocks;
}