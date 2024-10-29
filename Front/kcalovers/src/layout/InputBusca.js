import styles from "./InputBusca.module.css"

function InputBusca({onSearch}){
    const handleInputChange = (e) => {
        onSearch(e.target.value);
      };  

    return(
        <div className={styles.procurar}>
            <input onChange={handleInputChange}/>
            <button>Buscar</button>
        </div>
    )
}

export default InputBusca