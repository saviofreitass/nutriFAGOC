import styles from "./FoodContainer.module.css"

function FoodContainer({name, energia, calorias, proteinas, carboidratos, gorduras, colesterol, fibras, sodio, potassio}){

    return(
        <div className={styles.item}>
            <div className={styles.nameContainer}>
                <h1>{name}</h1>
            </div>
            <div className={styles.quantContainer}>
                <strong>Quantidade</strong>
                <strong>100g</strong>
            </div>
            <div className={styles.porcaoContainer}>
                <strong>Por porção</strong>
            </div>
            <div className={styles.energiaContainer}>
                <strong>Energia</strong>
                <p>{energia} kj</p>
            </div>
            <div className={styles.caloriaContainer}>
                <p>{calorias} kcal</p>
            </div>
            <div className={styles.carboContainer}>
                <strong>Carboidratos</strong>
                <strong>{carboidratos}g</strong>
            </div>
            <div className={styles.protContainer}>
                <strong>Proteínas</strong>
                <p>{proteinas}g</p>
            </div>
            <div className={styles.gordContainer}>
                <strong>Gorduras:</strong>
                <p>{gorduras}g</p>
            </div>
            <div className={styles.geral}>
                <p>Colesterol:</p>
                <p>{colesterol}mg</p>
            </div>
            <div className={styles.geral}>
                <p>Fibras:</p>
                <p>{fibras}mg</p>
            </div>
            <div className={styles.geral}>
                <p>Sodio:</p>
                <p>{sodio}mg</p>
            </div>
            <div className={styles.geral}>
                <p>Potássio:</p>
                <p>{potassio}mg</p>
            </div>
        </div>
        /*<div className={styles.item}>
            <h1 className={styles.NomeItem}>{name}</h1>
            <h4>Por porção</h4>
            <p className={styles.calorias}>Calorias: {calorias}</p>
            <p className={styles.proteinas}>Proteinas: {proteinas}</p>
            <p className={styles.carboidratos}>Carboidratos: {carboidratos}</p>
            <p className={styles.gorduras}>Gorduras: {gorduras}</p>
            <p className={styles.categoria}>Categoria: {categoria}</p>
        </div>*/
    )
}

export default FoodContainer;