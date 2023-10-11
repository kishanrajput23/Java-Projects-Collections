/**
 * Arguments:
 * canvas: element of canvas
 * labels: [January, feburary, ....] or [1,2,3,4]
 * stockData: [1,5,2,1,0,4,2,23]
 * buyDecision: The x positions of buying [January, feburary, 20, December]
 * sellDecision: Same thing above but for buying
 * 
 * Note: stockData.length MUST equal labels.length
*/
function generateChart(canvas, labels, stockData, buyDecision, sellDecision){
    function gen(decisions){
        var data = [];
        for(var eachLabel of decisions){
            data.push({
                x: eachLabel,
                y: stockData[labels.indexOf(eachLabel)],
                r: 5
            });
        }
        return data;
    }
    if(window.chartInstance){
        window.chartInstance.destroy();
    }
    window.chartInstance = new Chart(canvas.getContext('2d'), {
        type: 'line',
        data: {
            labels,
            datasets: [{
                label: 'Stock data',
                borderColor: 'rgb(0,0,0)',
                data: stockData,
                lineTension: 0,
                fill: false,
                radius: 0,
                borderWidth: 1
            },{
                label: 'Buy decision',
                borderColor: 'rgb(255,0,0)',
                data: gen(buyDecision),
                fill: false,
                type: 'bubble',
                backgroundColor: 'rgb(255,0,0)',
                pointStyle: 'triangle',
                rotation: 0
            },{
                label: 'Sell decision',
                borderColor: 'rgb(0,0,255)',
                data: gen(sellDecision),
                fill: false,
                type: 'bubble',
                backgroundColor: 'rgb(0,0,255)',
                pointStyle: 'triangle',
                rotation: 180
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Results'
            },
            maintainAspectRatio: false
        }
    });
}
window.onload = function(){
    var chartDom = document.getElementById('chart');
    
    // Dummy data for show
    window.mainChart = generateChart(chartDom, [1,2,3,4,5], [20, 60, 50, 99, 100], [2,3], [5]);
};