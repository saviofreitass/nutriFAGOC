import styles from './App.css';

import React, { useState, useEffect } from 'react';

import Header from './layout/Header';
import InputBusca from './layout/InputBusca'
import FoodContainer from './layout/FoodContainer';

function App() {

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

  return (
    <div className={styles.App}>
      <Header/>
      <div className={styles.main}>
        <InputBusca onSearch={setTermoBusca} />
        {foods.length > 0 && alimentoFiltro.map(food=> (
        <FoodContainer 
          name={food.descricaoalimento} 
          calorias={parseFloat(food.energiakcal).toFixed(2)}
          proteinas={parseFloat(food.proteina).toFixed(2)} 
          carboidratos={parseFloat(food.carboidrato).toFixed(2)} 
          gorduras={parseFloat(food.lipideos).toFixed(2)} 
          categoria={food.categoria}
          key={food.id}
          />))}
      </div>
    </div>
  );
}

export default App;
