import { useEffect, useState } from 'react';
import { obtenerAV } from '../APIs/asistenteVirtualAPI.js';
import { obtenerAVE } from '../APIs/asistenteVirtuaExternalAPI.js'
import { ejecutarComando, cambiarModo } from '../APIs/usuariosAPI.js';
import { useParams } from 'react-router-dom';

export default function ControlAsistente() {
  const [asistentes, setAsistentes] = useState([]);
  const [asistentesE, setAsistentesE] = useState([]);
  const { usuarioId } = useParams();

  useEffect(() => {
    obtenerAV(usuarioId).then(res => setAsistentes(res.data));
  }, []);

  useEffect(() => {
    obtenerAVE(usuarioId).then(res => setAsistentesE(res.data));
  }, []);

  const handleComando = (asistenteId, comando, tipo) => {
    ejecutarComando(usuarioId, comando, tipo, asistenteId)
      .then(() => alert(`Asistente ${comando}`))
      .catch(() => alert('Error al ejecutar comando'));
  };

  const handleModo = (asistenteId, modo, tipo) => {
    cambiarModo(usuarioId, tipo, asistenteId, modo)
      .then(() => alert(`Modo ${modo} aplicado`))
      .catch(() => alert('Error al cambiar modo'));
  };

  return (
    <div>
      {asistentes.map((asistente) => (
        <div key={asistente.id}>
          <strong>{asistente.nombre}   </strong>
          <button className="btn btn-primary" onClick={() => handleComando(asistente.id, 'encender', 'asistente virtual')}>Encender</button>
          <button className="btn btn-primary" onClick={() => handleComando(asistente.id, 'programar', 'asistente virtual')}>Programar</button>
          <button className="btn btn-primary" onClick={() => handleComando(asistente.id, 'ajustar', 'asistente virtual')}>Ajustar</button>
          <button className="btn btn-danger" onClick={() => handleComando(asistente.id, 'apagar', 'asistente virtual')}>Apagar</button>
          <select className="btn btn-secondary" onChange={(e) => handleModo(asistente.id, e.target.value, 'asistente virtual')}>
            <option value="">Cambiar modo</option>
            <option value="noche">Noche</option>
            <option value="ahorro">Ahorro</option>
            <option value="vacaciones">Vacaciones</option>
            <option value="ausente">Ausente</option>
          </select>
        </div>
      ))}
      {asistentesE.map((asistente) => (
          <div key={asistente.id}>
            <strong>{asistente.nombre}   </strong>
            <button className="btn btn-primary" onClick={() => handleComando(asistente.id, 'encender', 'asistente virtual externa')}>Encender</button>
            <button className="btn btn-primary" onClick={() => handleComando(asistente.id, 'programar', 'asistente virtual externa')}>Programar</button>
            <button className="btn btn-primary" onClick={() => handleComando(asistente.id, 'ajustar', 'asistente virtual externa')}>Ajustar</button>
            <button className="btn btn-danger" onClick={() => handleComando(asistente.id, 'apagar', 'asistente virtual externa')}>Apagar</button>
            <select className="btn btn-secondary" onChange={(e) => handleModo(asistente.id, e.target.value, 'asistente virtual externa')}>
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
