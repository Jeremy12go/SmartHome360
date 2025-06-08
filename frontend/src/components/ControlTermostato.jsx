import { useEffect, useState } from 'react';
import { obtenerT } from '../APIs/termostatoAPI.js';
import { obtenerTE } from '../APIs/termostatoExternaAPI.js'
import { ejecutarComando, cambiarModo } from '../APIs/usuariosAPI.js';
import { useParams } from 'react-router-dom';

export default function ControlTermostato() {
  const [termostatos, setTermostatos] = useState([]);
  const [termostatosE, setTermostatosE] = useState([]);
  const { usuarioId } = useParams();

  useEffect(() => {
    obtenerT(usuarioId).then(res => setTermostatos(res.data));
  }, []);

  useEffect(() => {
    obtenerTE(usuarioId).then(res => setTermostatosE(res.data));
  }, []);

  const handleComando = (termostatoId, comando, tipo) => {
    ejecutarComando(usuarioId, comando, tipo, termostatoId)
      .then(() => alert(`Termostato ${comando}`))
      .catch(() => alert('Error al ejecutar comando'));
  };

  const handleModo = (termostatoId, modo, tipo) => {
    cambiarModo(usuarioId, tipo, termostatoId, modo)
      .then(() => alert(`Modo ${modo} aplicado`))
      .catch(() => alert('Error al cambiar modo'));
  };

  return (
    <div>
      {termostatos.map((termostato) => (
        <div key={termostato.id}>
          <strong>{termostato.nombre}   </strong>
          <button className="btn btn-primary" onClick={() => handleComando(termostato.id, 'encender', 'termostato')}>Encender</button>
          <button className="btn btn-primary" onClick={() => handleComando(termostato.id, 'programar', 'termostato')}>Programar</button>
          <button className="btn btn-primary" onClick={() => handleComando(termostato.id, 'ajustar', 'termostato')}>Ajustar</button>
          <button className="btn btn-danger" onClick={() => handleComando(termostato.id, 'apagar', 'termostato')}>Apagar</button>
          <select className="btn btn-secondary" onChange={(e) => handleModo(termostato.id, e.target.value, 'termostato')}>
            <option value="">Cambiar modo</option>
            <option value="noche">Noche</option>
            <option value="ahorro">Ahorro</option>
            <option value="vacaciones">Vacaciones</option>
            <option value="ausente">Ausente</option>
          </select>
        </div>
      ))}
      {termostatosE.map((termostato) => (
          <div key={termostato.id}>
            <strong>{termostato.nombre}   </strong>
            <button className="btn btn-primary" onClick={() => handleComando(termostato.id, 'encender', 'termostato externa')}>Encender</button>
            <button className="btn btn-primary" onClick={() => handleComando(termostato.id, 'programar', 'termostato externa')}>Programar</button>
            <button className="btn btn-primary" onClick={() => handleComando(termostato.id, 'ajustar', 'termostato externa')}>Ajustar</button>
            <button className="btn btn-danger" onClick={() => handleComando(termostato.id, 'apagar', 'termostato externa')}>Apagar</button>
            <select className="btn btn-secondary" onChange={(e) => handleModo(termostato.id, e.target.value, 'termostato externa')}>
              <option value="">Cambiar modo</option>
              <option value="noche">Noche</option>
              <option value="ahorro">Ahorro</option>
              <option value="vacaciones">Vacaciones</option>
              <option value="ausente">Ausente</option>
            </select>
          </div>
      ))}
    </div>
  );
}
