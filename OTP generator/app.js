
let fun=()=>{

    let a=[0,1,2,3,4,5,6,7,8,9]

    let c="";

    for(let i=0;i<4;i++){
        c+=a[Math.floor(Math.random()*10)];
    }

    document.getElementById('t1').textContent=c;
}


document.getElementById('bt').addEventListener('click',fun)