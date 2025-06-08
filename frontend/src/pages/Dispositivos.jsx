import '../styles/Dispositivo.css';
import Luces from '../components/ControlLuz.jsx';
import Camaras from '../components/ControlCamara.jsx'
import Termostatos from '../components/ControlTermostato.jsx'
import Asistentes from '../components/ControlAsistente.jsx'
import { useParams, useNavigate } from 'react-router-dom';
import {useEffect, useState} from 'react';
import {getUsuarioId} from "../APIs/usuariosAPI.js";
import logo from "../assets/usuario.png";

export default function Dispositivos() {

    const { usuarioId } = useParams();
    const navigate = useNavigate();
    const [nombreUsuario, setNombreUsuario] = useState('');

    const handleLogout = () => {
        navigate('/'); // Volver al lobby.
    };

    useEffect(() => {
        getUsuarioId(usuarioId).then(res => {
            const { nombre, apellido } = res.data;
            setNombreUsuario(`${nombre} ${apellido}`);
        }).catch(() => setNombreUsuario(usuarioId));
    }, [usuarioId]);

    return (
        <div>

            <header className="dashboard-header">
                <div className="user-box">
                    <img src={logo} alt="Logo" width="60" />
                    <span>{nombreUsuario}</span>
                </div>
                <h2>Panel de Dispositivos</h2>
                <button onClick={handleLogout} className="logout-button">Salir</button>
            </header>

            <div className="dispositivos-grid">
                <div className="dispositivo-panel">
                    <h3>Luces 💡</h3>
                    <Luces />
                </div>
                <div className="dispositivo-panel">
                    <h3>Cámaras 📷</h3>
                    <Camaras />
                </div>
                <div className="dispositivo-panel">
                    <h3>Termostatos 🌡️</h3>
                    <Termostatos />
                </div>
                <div className="dispositivo-panel">
                    <h3>Asistentes Virtuales 🗣️</h3>
                    <Asistentes />
                </div>
            </div>
        </div>
    );
}
