     const calcy = () =>{

        let TOC= document.getElementById('toc').value;
        let DBMS = document.getElementById('dbms').value;
        let IWT = document.getElementById('iwt').value;
        let CYBER = document.getElementById('cyber').value;
        let grades = "";     
      
        let totalGrades = parseFloat(TOC) + parseFloat(DBMS) + parseFloat(IWT) + parseFloat(CYBER);     
      
        let percentage = (totalGrades/80) * 100;
          
        if(percentage <= 100  && percentage >= 80){
          grades = 'A';
        }else if(percentage <= 79  && percentage >= 60){
           grades = 'B';
        }else if(percentage <= 59  && percentage >= 40){
           grades = 'C';
        }else{
           grades = 'F';
        }

        document.getElementById('showData').innerHTML = ` Out of 80 your total is  ${totalGrades} and percentage is ${percentage.toFixed(2)}%. <br> Your grade is ${grades}.`;

}