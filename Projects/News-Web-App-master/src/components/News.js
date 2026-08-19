import React, { Component } from "react";
import NewsItem from "./NewsItem";

export class News extends Component {
  constructor() {
    super();
    this.state = { 
      articles:[],
      loading:true, 
      page:1
    
    
    
    };
  }
   async componentDidMount(){
    let url="https://newsapi.org/v2/top-headlines?country=in&apiKey=ad35d5a7e5d84483bcff2f86a53ba009&page=2&pageSize=20";

    let data= await fetch(url);this.props.pageSize
    let parsedData= await data.json()
    console.log(parsedData);
    this.setState({articles:parsedData.articles,totalResults:parsedData.totalResults})

  }
  handlePrevoiusClick= async ()=>{
    console.log("prev");
    let url="https://newsapi.org/v2/top-headlines?country=in&apiKey=ad35d5a7e5d84483bcff2f86a53ba009&page=$ {this.state.page-1}&pageSize=20";
    let data= await fetch(url);
    let parsedData= await data.json()
    console.log(parsedData);
    this.setState({
      page:this.state.page-1,
      articles:parsedData.articles
    })

  }
  handleNextClick= async ()=>{
    console.log("next");

    if (this.state.page +1 >Math.ceil(this.state.totalResults/20)){

    }
    else {

    let url="https://newsapi.org/v2/top-headlines?country=in&apiKey=ad35d5a7e5d84483bcff2f86a53ba009&page=${this.state.page + 1}&pageSize=20";
    
    let data= await fetch(url);
    let parsedData= await data.json()
    console.log(parsedData);
    this.setState({
      page:this.state.page + 1,
      articles:parsedData.articles
    })


    }
    


  }


  render() {
    console.log("this is console");
    return (
      <div className="container my-3">
        <h2 className="text-center">NewsApp-Top Headlines</h2>
        <div className="row">
        {this.state.articles.map((element)=>{
           return  <div className="col-md-4" key={element.url}>
            <NewsItem title={element.title}
              description={element.description}
              imageUrl={element.urlToImage} newsUrl={element.url}/>
          </div>

        })}
          
        </div>
        <div className="container d-flex justify-content-between" >
        <button disabled={this.state.page<=1} type="button" className="btn btn-dark" onClick={this.handlePrevoiusClick}> &larr; previous</button>
        <button disabled={this.state.page +1 >Math.ceil(this.state.totalResults/this.props.pageSize)} type="button" className="btn btn-dark" onClick={this.handleNextClick}>next &rarr;</button>


        </div>
      </div>
    );
  }
}

export default News;

