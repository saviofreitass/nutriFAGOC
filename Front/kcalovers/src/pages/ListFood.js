import React, { useState, useEffect } from 'react';

import styles from "./ListFood.module.css"

import InputBusca from "../layout/InputBusca";
import FoodContainer from "../layout/FoodContainer";

function ListFood(){

    const [foods, setFoods] = useState([]);
    const [termoBusca, setTermoBusca] = useState("")
  
    useEffect(()=>{
      fetch("http://localhost:8080/foods",{
        method:"GET",
        headers:{
          'Content-type' : "application/json"
        },
      })
      .then((resp) => resp.json())
      .then((data)=>{
        setFoods(data)
      })
      .catch((err) => console.log(err))
    }, [])
  
    const alimentoFiltro = foods.filter(food =>
      food.descricaoalimento.toLowerCase().includes(termoBusca.toLowerCase())
    );

    return(
        <div className={styles.container}>
            <InputBusca onSearch={setTermoBusca}/>
            <div className={styles.list}>
              {foods.length > 0 && alimentoFiltro.map(food=> (
              <FoodContainer 
              name={food.descricaoalimento} 
              energia={parseFloat(food.energiakj).toFixed(2)}
              calorias={parseFloat(food.energiakcal).toFixed(2)}
              proteinas={parseFloat(food.proteina).toFixed(2)} 
              carboidratos={parseFloat(food.carboidrato).toFixed(2)} 
              gorduras={parseFloat(food.lipideos).toFixed(2)} 
              colesterol={parseFloat(food.colesterol).toFixed(2)}
              fibras={parseFloat(food.fibraalimentar).toFixed(2)}
              sodio={parseFloat(food.sodio).toFixed(2)}
              potassio={parseFloat(food.potassio).toFixed(2)}
              key={food.id}
              />))}
            </div>
        </div>
    ) 
}

export default ListFood