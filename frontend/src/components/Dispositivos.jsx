import { useEffect, useState } from 'react';
import {getUsuarios} from '../APIs/usuariosAPI';
import '../styles/Lobby.css';
import logo from '../assets/Logo.png'

export default function Dispositivos({ onSelect }) {
    const [usuarios, setUsuarios] = useState([]);

    useEffect(() => {
        getUsuarios().then(res => setUsuarios(res.data));
    }, []);

    return (
        <div className="lobby-container">
            <h1 className="lobby-title">Bienvenido!</h1>
            <img src={logo} alt="Logo" width="150"/>
            <p className="lobby-subtitle">Selecciona tu usuario para comenzar</p>

            <div className="lobby-user-list">
                {usuarios.map((u) => (
                    <button
                        key={u.id}
                        className="lobby-user-button"
                        onClick={() => onSelect(u.id)}
                    >
                        {u.nombre} {u.apellido}
                    </button>
                ))}
            </div>
        </div>
    );
}
