import { useState } from 'react';
import { registrarLuz } from '../../APIs/luzAPI.js';

export default function RegistroLuz() {
    const [id, setId] = useState('');
    const [ubicacion, setUbicacion] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        registrarLuz({ id, ubicacion, estadoEncendido: false }).then(() => {
            alert('Luz registrada');
            setId('');
            setUbicacion('');
        });
    };

    return (
        <form onSubmit={handleSubmit}>
            <h3>Registrar luz</h3>
            <input placeholder="ID de luz" value={id} onChange={(e) => setId(e.target.value)} required />
            <input placeholder="Ubicación" value={ubicacion} onChange={(e) => setUbicacion(e.target.value)} required />
            <button type="submit">Registrar</button>
        </form>
    );
}