import styles from "./FoodContainer.module.css"

function FoodContainer({name, calorias, proteinas, carboidratos, gorduras, categoria}){

    return(
        <div className={styles.item}>
            <p className={styles.NomeItem}>Nome do Produto: {name}</p>
            <p className={styles.calorias}>Calorias: {calorias}</p>
            <p className={styles.proteinas}>Proteinas: {proteinas}</p>
            <p className={styles.carboidratos}>Carboidratos: {carboidratos}</p>
            <p className={styles.gorduras}>Gorduras: {gorduras}</p>
            <p className={styles.categoria}>Categoria: {categoria}</p>
        </div>
    )
}

export default FoodContainer;