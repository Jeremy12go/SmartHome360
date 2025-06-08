import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarCE = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/camaras/externa`, dispositivo);
export const obtenerCE = (userId) => axios.get(`${API_URL}/usuarios/${userId}/camaras/externa`);