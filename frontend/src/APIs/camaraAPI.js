import axios from 'axios';
const API_URL = 'http://localhost:8080/api';

export const registrarC = (userId, dispositivo) => axios.post(`${API_URL}/usuarios/${userId}/camaras`, dispositivo);
export const obtenerC = (userId) => axios.get(`${API_URL}/usuarios/${userId}/camaras`);