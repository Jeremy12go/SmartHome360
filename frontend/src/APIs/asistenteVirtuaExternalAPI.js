import axios from 'axios';
const API_URL = 'http://localhost:8080/api/asistentes/externa';

export const registrarAVE = (dispositivo) => axios.post(API_URL, dispositivo);
export const obtenerAVE = () => axios.get(API_URL);
