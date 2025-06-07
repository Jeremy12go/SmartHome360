import axios from 'axios';
const API_URL = 'http://localhost:8080/api/camaras';

export const registrarC = (dispositivo) => axios.post(API_URL, dispositivo);
export const obtenerC = () => axios.get(API_URL);
