import { useEffect, useState } from 'react';
import { obtenerL } from '../APIs/luzAPI.js';
import { obtenerLE } from '../APIs/luzExternaAPI.js'
import { ejecutarComando, cambiarModo } from '../APIs/usuariosAPI.js';
import { useParams } from 'react-router-dom';

export default function ControlLuz() {
  const [luces, setLuces] = useState([]);
  const [lucesE, setLucesE] = useState([]);
  const { usuarioId } = useParams();

  useEffect(() => {
    obtenerL(usuarioId).then(res => setLuces(res.data));
  }, []);

  useEffect(() => {
    obtenerLE(usuarioId).then(res => setLucesE(res.data));
  }, []);

  const handleComando = (luzId, comando, tipo) => {
    ejecutarComando(usuarioId, comando, tipo, luzId)
      .then(() => alert(`Luz ${comando}`))
      .catch(() => alert('Error al ejecutar comando'));
  };

  const handleModo = (luzId, modo, tipo) => {
    cambiarModo(usuarioId, tipo, luzId, modo)
      .then(() => alert(`Modo ${modo} aplicado`))
      .catch(() => alert('Error al cambiar modo'));
  };

  return (
    <div>
      {luces.map((luz) => (
        <div key={luz.id}>
          <strong>{luz.nombre}   </strong>
          <button className="btn btn-primary" onClick={() => handleComando(luz.id, 'encender', 'luz')}>Encender</button>
          <button className="btn btn-primary" onClick={() => handleComando(luz.id, 'programar', 'luz')}>Programar</button>
          <button className="btn btn-primary" onClick={() => handleComando(luz.id, 'ajustar', 'luz')}>Ajustar</button>
          <button className="btn btn-danger" onClick={() => handleComando(luz.id, 'apagar', 'luz')}>Apagar</button>
          <select className="btn btn-secondary" onChange={(e) => handleModo(luz.id, e.target.value, 'luz')}>
            <option value="">Cambiar modo</option>
            <option value="noche">Noche</option>
            <option value="ahorro">Ahorro</option>
            <option value="vacaciones">Vacaciones</option>
            <option value="ausente">Ausente</option>
          </select>
        </div>
      ))}
      {lucesE.map((luz) => (
          <div key={luz.id}>
            <strong>{luz.nombre}   </strong>
            <button className="btn btn-primary" onClick={() => handleComando(luz.id, 'encender', 'luz externa')}>Encender</button>
            <button className="btn btn-primary" onClick={() => handleComando(luz.id, 'programar', 'luz externa')}>Programar</button>
            <button className="btn btn-primary" onClick={() => handleComando(luz.id, 'ajustar', 'luz externa')}>Ajustar</button>
            <button className="btn btn-danger" onClick={() => handleComando(luz.id, 'apagar', 'luz externa')}>Apagar</button>
            <select className="btn btn-secondary" onChange={(e) => handleModo(luz.id, e.target.value, 'luz externa')}>
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
