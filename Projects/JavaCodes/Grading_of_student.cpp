//  https://www.hackerrank.com/challenges/grading/problem?isFullScreen=true
vector<int> gradingStudents(vector<int> grades) {
    vector<int> lmao(grades.size());
for(int i = 0 ; i<grades.size();i++ ){
        int nextval = grades[i]+(5-(grades[i]%5));
        if(grades[i]%5==0){
            lmao[i]=grades[i];
        }
        else if(grades[i]<=37){
            lmao[i]=grades[i];
        }
        else {
 
        if(nextval-grades[i]<3){
        lmao[i]=nextval;
        }
        else if (nextval-grades[i]==3) {
        lmao[i]=grades[i];
        }  
        else if(nextval-grades[i]>3){
            lmao[i]=grades[i];
        }
 
        }
 
     }
 
    return lmao;
 
}