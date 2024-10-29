import styles from "./InputBusca.module.css"

function InputBusca({onSearch, handleClick}){
    const handleInputChange = (e) => {
        onSearch(e.target.value);
      };  

    return(
        <div className={styles.procurar}>
            <input onChange={handleInputChange}/>
            <button onClick={handleClick}>Buscar</button>
        </div>
    )
}

export default InputBusca