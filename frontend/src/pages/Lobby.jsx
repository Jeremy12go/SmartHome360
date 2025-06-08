import { useEffect, useState } from 'react';
import {getUsuarios} from '../APIs/usuariosAPI.js';
import { useNavigate } from 'react-router-dom';
import '../styles/Lobby.css';
import logo from '../assets/Logo.png'

export default function Lobby() {
    const [usuarios, setUsuarios] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getUsuarios().then(res => setUsuarios(res.data));
    }, []);

    const handleSelect = (usuarioId) => {
        navigate(`/dispositivos/${usuarioId}`);
    };

    return (
        <div className="lobby-container">
            <h1 className="lobby-title">Bienvenido!</h1>
            <img src={logo} alt="Logo" width="200"/>
            <p className="lobby-subtitle">Quien esta controlando?</p>

            <div className="lobby-user-list">
                {usuarios.map((u) => (
                    <button
                        key={u.id}
                        className="lobby-user-button"
                        onClick={() => handleSelect(u.id)}
                    >
                        {u.nombre} {u.apellido}
                    </button>
                ))}
            </div>
        </div>
    );
}
