import {useState} from "react"
import { useNavigate, Link} from "react-router-dom"

import styles from "./Login.module.css"

function Login(){

    const navigate =  useNavigate();

    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [alert, setAlert] = useState("");

    function login(){
        const user ={
            email: email,
            senha: senha
        }

        fetch("http://localhost:8080/login",{
            method: "POST",
            headers:{
                "Content-type": "application/json"
            },
            body: JSON.stringify(user)
        }).then((resp)=> resp.json())
        .then((data) => {
            navigate("/")
        }).catch((err)=>{
            console.log(err);
            setAlert("Email e/ou senha inválidos!")
        })
    }

    return(
        <div className={styles.container}>
            <div className={styles.login}>
                <p className={styles.title}>LOGIN</p>
                <div className={styles.inputs}>
                    <label htmlFor="email">Email:</label>
                    <input name="email" id="email" className={styles.usuario} type="email" onChange={(e)=> setEmail(e.target.value)}></input>
                    <label htmlFor="senha">Senha:</label>
                    <input name="senha" id="senha" className={styles.senha} type="password"onChange={(e)=> setSenha(e.target.value)}></input>
                </div>
                <p className={styles.alert}>{alert}</p>
                <button onClick={login}>Entrar</button>
                <a href="EsqueciSenha.html">Esqueci minha senha</a>
            </div>
            <div className={styles.cadastro}>
                <p>Não possui cadastro?</p>
                <Link to={"/cadastro"}>
                    <button>Cadastrar</button>
                </Link>
            </div>
        </div>
    )
}

export default Login