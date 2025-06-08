import { useEffect, useState } from 'react';
import { obtenerC } from '../APIs/camaraAPI.js';
import { obtenerCE } from '../APIs/camaraExternaAPI.js'
import { ejecutarComando, cambiarModo } from '../APIs/usuariosAPI.js';
import { useParams } from 'react-router-dom';

export default function ControlCamara() {
  const [camaras, setCamaras] = useState([]);
  const [camarasE, setCamarasE] = useState([]);
  const { usuarioId } = useParams();

  useEffect(() => {
    obtenerC(usuarioId).then(res => setCamaras(res.data));
  }, []);

  useEffect(() => {
    obtenerCE(usuarioId).then(res => setCamarasE(res.data));
  }, []);

  const handleComando = (camaraId, comando, tipo) => {
    ejecutarComando(usuarioId, comando, tipo, camaraId)
      .then(() => alert(`Camara ${comando}`))
      .catch(() => alert('Error al ejecutar comando'));
  };

  const handleModo = (camaraId, modo, tipo) => {
    cambiarModo(usuarioId, tipo, camaraId, modo)
      .then(() => alert(`Modo ${modo} aplicado`))
      .catch(() => alert('Error al cambiar modo'));
  };

  return (
    <div>
      {camaras.map((camara) => (
        <div key={camara.id}>
          <strong>{camara.nombre}   </strong>
          <button className="btn btn-primary" onClick={() => handleComando(camara.id, 'encender', 'camara')}>Encender</button>
          <button className="btn btn-primary" onClick={() => handleComando(camara.id, 'programar', 'camara')}>Programar</button>
          <button className="btn btn-primary" onClick={() => handleComando(camara.id, 'ajustar', 'camara')}>Ajustar</button>
          <button className="btn btn-danger" onClick={() => handleComando(camara.id, 'apagar', 'camara')}>Apagar</button>
          <select className="btn btn-secondary" onChange={(e) => handleModo(camara.id, e.target.value, 'camara')}>
            <option value="">Cambiar modo</option>
            <option value="noche">Noche</option>
            <option value="ahorro">Ahorro</option>
            <option value="vacaciones">Vacaciones</option>
            <option value="ausente">Ausente</option>
          </select>
        </div>
      ))}
      {camarasE.map((camara) => (
          <div key={camara.id}>
            <strong>{camara.nombre}   </strong>
            <button className="btn btn-primary" onClick={() => handleComando(camara.id, 'encender', 'camara externa')}>Encender</button>
            <button className="btn btn-primary" onClick={() => handleComando(camara.id, 'programar', 'camara externa')}>Programar</button>
            <button className="btn btn-primary" onClick={() => handleComando(camara.id, 'ajustar', 'camara externa')}>Ajustar</button>
            <button className="btn btn-danger" onClick={() => handleComando(camara.id, 'apagar', 'camara externa')}>Apagar</button>
            <select className="btn btn-secondary" onChange={(e) => handleModo(camara.id, e.target.value, 'camara externa')}>
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
