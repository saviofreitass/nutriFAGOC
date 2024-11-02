import styles from "./Login.module.css"

function Login(){

    return(
        <div className={styles.container}>
            <div className={styles.login}>
                <p>LOGIN</p>
                <div className={styles.inputs}>
                    <label htmlFor="email">Email:</label>
                    <input name="email" id="email" className={styles.usuario} type="email"></input>
                    <label htmlFor="senha">Senha:</label>
                    <input name="senha" id="senha" className={styles.senha} type="password"></input>
                </div>
                <button>Entrar</button>
                <a href="EsqueciSenha.html">Esqueci minha senha</a>
            </div>
            <div className={styles.cadastro}>
                <p>Não possui cadastro?</p>
                <button>Cadastrar</button>
            </div>
        </div>
    )
}

export default Login