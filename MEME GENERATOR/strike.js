const kt = () => {
    fetch("https://meme-api.herokuapp.com/gimme")
      .then((data) => data.json())
      .then((data_val) => {
        const u_data = data_val.url;
        document.getElementById("myImg").src = u_data;
        console.log(u_data);
      });
  };
  kt();
  
  //function to refresh the page every 5 seconds
  const myfunc = () =>{
    kt();
  }
  
  
  //function to share the generated meme on social networks
  function share(){
      if (navigator.share !== undefined) {
          navigator.share({
              title: 'Meme Genrator',
              text: 'meme generator',
              url: 'u_data',
          })
          .then(() => console.log('Successful share'))
          .catch((error) => console.log('Error sharing', error));
      }
  }