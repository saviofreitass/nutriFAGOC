import styles from "./Login.module.css"

function Login(){

    return(
        <div className={styles.container}>
            <div className={styles.login}>
                <p>LOGIN</p>
                <div className={styles.inputs}>
                    <label for=""></label>
                    <label for="usuario">Usuario:</label>
                    <input className={styles.usuario} type="text"></input>
                    <label for="senha">Senha:</label>
                    <input className={styles.senha} type="password"></input>
                </div>
                <button onclick="redirecionar2()">Entrar</button>
                <a href="EsqueciSenha.html">Esqueci minha senha</a>
            </div>
            <div className={styles.cadastro}>
                <p>Não possui cadastro?</p>
                <button onclick="redirecionar()">Cadastrar</button>
            </div>
        </div>
    )
}

export default Login