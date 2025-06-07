import axios from 'axios';

const API_URL = 'http://localhost:8080/api/usuarios';

export const crearUsuario = (usuario) =>
    axios.post(API_URL, usuario);

export const getUsuarios = () =>
    axios.get(API_URL);

export const ejecutarComando = (id, tipoComando, tipoDispositivo, dispositivoId) =>
    axios.post(`${API_URL}/${id}/comando`, null, {
        params: { tipoComando, tipoDispositivo, dispositivoId },
    });

export const cambiarModo = (userId, tipoDispositivo, dispositivoId, modo) =>
    axios.post(`${API_URL}/${userId}/modo`, null, {
        params: { tipoDispositivo, dispositivoId, modo },
    });