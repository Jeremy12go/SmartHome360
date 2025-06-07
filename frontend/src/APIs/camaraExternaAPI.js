import axios from 'axios';
const API_URL = 'http://localhost:8080/api/camaras/externa';

export const registrarCE = (dispositivo) => axios.post(API_URL, dispositivo);
export const obtenerCE = () => axios.get(API_URL);
