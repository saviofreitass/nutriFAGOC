import styles from "./InputBusca.module.css"

function InputBusca({onSearch}){
    const handleInputChange = (e) => {
        onSearch(e.target.value);
      };  

    return(
        <div className={styles.procurar}>
            <h1>Buscar alimento</h1>
            <p>Busque um alimento e descubra <br></br>se ele se encaixa no seu dia a dia</p>
            <input onChange={handleInputChange}/>
            <button>Buscar</button>
        </div>
    )
}

export default InputBusca