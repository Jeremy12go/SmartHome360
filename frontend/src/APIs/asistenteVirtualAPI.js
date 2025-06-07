import axios from 'axios';
const API_URL = 'http://localhost:8080/api/asistentes';

export const registrarAV = (dispositivo) => axios.post(API_URL, dispositivo);
export const obtenerAV = () => axios.get(API_URL);
